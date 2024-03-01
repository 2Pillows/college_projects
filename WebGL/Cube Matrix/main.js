// Create Canvas
const canvas = document.querySelector("canvas");
const gl = canvas.getContext("webgl");

// Set vertex data
const vertexData = [
  // Front
  1, 1, 1, 1, -1, 1, -1, 1, 1, -1, 1, 1, 1, -1, 1, -1, -1, 1,

  // Left
  -1, 1, 1, -1, -1, 1, -1, 1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1,

  // Back
  -1, 1, -1, -1, -1, -1, 1, 1, -1, 1, 1, -1, -1, -1, -1, 1, -1, -1,

  // Right
  1, 1, -1, 1, -1, -1, 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, -1, -1,

  // Top
  1, 1, 1, 1, 1, -1, -1, 1, 1, -1, 1, 1, 1, 1, -1, -1, 1, -1,

  // Bottom
  1, -1, 1, 1, -1, -1, -1, -1, 1, -1, -1, 1, 1, -1, -1, -1, -1, -1,
];

// Set color data
const colorData = [
  // Front
  1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0,

  // Left
  0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0,

  // Back
  0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1,
  
  // Right
  1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0,

  // Top
  0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1,

  // Bottom
  1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1,
];

// Use vertex data to create position buffer
const positionBuffer = gl.createBuffer();
gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(vertexData), gl.STATIC_DRAW);

// Use color data to create color buffer
const colorBuffer = gl.createBuffer();
gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(colorData), gl.STATIC_DRAW);

// Crate vertex shader
var vertexCode =
`
precision mediump float;
uniform mat4 vMatrix;
attribute vec3 color;
attribute vec3 position;
varying vec3 vColor;
void main() {
    gl_Position = vMatrix * vec4(position, 1);
    vColor = color;
}
`;
var vertexShader = gl.createShader(gl.VERTEX_SHADER);
gl.shaderSource(vertexShader, vertexCode);
gl.compileShader(vertexShader);

// Create fragment shader
var fragmentCode =
`
precision mediump float;
varying vec3 vColor;
void main() {
    gl_FragColor = vec4(vColor, 1);
}
`;
const fragmentShader = gl.createShader(gl.FRAGMENT_SHADER);
gl.shaderSource(fragmentShader, fragmentCode);
gl.compileShader(fragmentShader);

// Create shader program and attach shaders
const shaderProgram = gl.createProgram();
gl.attachShader(shaderProgram, vertexShader);
gl.attachShader(shaderProgram, fragmentShader);
gl.linkProgram(shaderProgram); 
gl.useProgram(shaderProgram);

// Position
const positionLocation = gl.getAttribLocation(shaderProgram, "position");
gl.enableVertexAttribArray(positionLocation);
gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
gl.vertexAttribPointer(positionLocation, 3, gl.FLOAT, false, 0, 0);

// Colors
const colorLocation = gl.getAttribLocation(shaderProgram, "color");
gl.enableVertexAttribArray(colorLocation);
gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
gl.vertexAttribPointer(colorLocation, 3, gl.FLOAT, false, 0, 0);

// Matrix to Move and Matrix of Cube
const movMatrix = mat4.create();
const vMatrix = gl.getUniformLocation(shaderProgram, `vMatrix`);

// Shrink to fit on screen
mat4.scale(movMatrix, movMatrix, [0.1, 0.1, 0.1]);

// Enable depth test to make faces solid
gl.enable(gl.DEPTH_TEST);

// Draw Cube and give Rotations
function animate() {
  requestAnimationFrame(animate);
  mat4.rotateZ(movMatrix, movMatrix, 0.005);
  mat4.rotateX(movMatrix, movMatrix, 0.005);
  gl.uniformMatrix4fv(vMatrix, false, movMatrix);
  gl.drawArrays(gl.TRIANGLES, 0, vertexData.length / 3);
}

animate();
