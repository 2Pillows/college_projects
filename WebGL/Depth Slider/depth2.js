var canvas = document.getElementById("canvas");
var gl = canvas.getContext("webgl");

// const at = vec3(0.0, 0.0, 0.0); 
// const up = vec3(0.0, 1.0, 0.0);

var vertexShaderText = [
    `
    precision mediump float;
    attribute vec4 vertPosition;
    attribute vec4 vertColor;
    varying vec4 fragColor;
    
    void main()
    {
        fragColor = vertColor;
        gl_Position = vec4(vertPosition, 0.0, 1.0);
    }`];

var fragmentShaderText = [
    `
    precision mediump float;
    varying vec3 fragColor;
    void main()
    {
        gl_FragColor = vec4(fragColor, 1.0);
    }`];

gl.clearColor(0.0, 0.0, 0.0, 0.1);
gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);

var vertexShader = gl.createShader(gl.VERTEX_SHADER);
gl.shaderSource(vertexShader, vertexShaderText);

var fragmentShader = gl.createShader(gl.FRAGMENT_SHADER);
gl.shaderSource(fragmentShader, fragmentShaderText);

gl.compileShader(vertexShader);
gl.compileShader(fragmentShader);

var program = gl.createProgram();
gl.attachShader(program, vertexShader);
gl.attachShader(program, fragmentShader);
gl.linkProgram(program);

gl.validateProgram(program);

var triangleVertices = [
  // X, Y | R, G, B
  0.0, 0.5, 
  0.0, 0.0, 0.5, 

  -0.5, -0.5, 
  0.0, 0.0, 0.5, 

  0.5, -0.5, 
  0.0, 0.0, 0.5,
];

var triangleVertexBufferObject = gl.createBuffer();
gl.bindBuffer(gl.ARRAY_BUFFER, triangleVertexBufferObject);
gl.bufferData(
  gl.ARRAY_BUFFER,
  new Float32Array(triangleVertices),
  gl.STATIC_DRAW
);

var positionAttribLocation = gl.getAttribLocation(program, "vertPosition");
var colorAttribLocation = gl.getAttribLocation(program, "vertColor");
gl.vertexAttribPointer(
  positionAttribLocation, // Attribute location
  2, // Number of elements per attribute
  gl.FLOAT, // Type of elements
  gl.FALSE,
  5 * Float32Array.BYTES_PER_ELEMENT, // Size of an individual vertex
  0 // Offset from the beginning of a single vertex to this attribute
);
gl.vertexAttribPointer(
  colorAttribLocation, // Attribute location
  3, // Number of elements per attribute
  gl.FLOAT, // Type of elements
  gl.FALSE,
  5 * Float32Array.BYTES_PER_ELEMENT, // Size of an individual vertex
  2 * Float32Array.BYTES_PER_ELEMENT // Offset from the beginning of a single vertex to this attribute
);

gl.enableVertexAttribArray(positionAttribLocation);
gl.enableVertexAttribArray(colorAttribLocation);

document.getElementById("depthSlider").onchange = function() {
    far = evt.target.value/2;
    near = -evt.target.value/2;
}

//
// Main render loop
//
gl.useProgram(program);
gl.enable(gl.DEPTH_TEST);
gl.drawArrays(gl.TRIANGLES, 0, 3);
