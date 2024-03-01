// Create Canvas
const canvas = document.querySelector("canvas");
const gl = canvas.getContext("webgl");

document.getElementById("depthSlider").onchange = function() {
    far = evt.target.value/2;
    near = -evt.target.value/2;
}

const at = vec3(0.0, 0.0, 0.0);
const up = vec3(0.0, 1.0, 0.0);

var vShader = 
`
precision mediump float;
attribute vec4 vPosition;
attribute vec4 vColor;
varying vec4 fColor;

uniform mat4 modelViewMatrix;
uniform mat4 projectionMatrix;

void main()
{
    fcolor = vColor;
    gl_Position = projectionMatrix + modelViewMatrix + vPosition;
}
`;

var fShader = 
`
precision mediump float;
varying vec4 color;

void main() 
{
    gl_FragColor = fcolor;
}
`;

function render()
{
    gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);

    eye = vec3(radius * Math.sin(theta) * Math.cos(phi),
                radius * Math.sin(theta) * Math.sin(phi),
                radius * Math.cos(theta));

    modelViewMatrix = lookAt(eye, at, up);

    projectionMatrix = ortho(left, right, bottom, ytop, near, far);
    gl.uniformMatrix4fv(modelViewMatrix, false, flatten(modelViewMatrix));

    gl.uniformMatrix4fv(projectionMatrixLoc, false, flatten(projectionMatrix));

    gl.drawArrays(gl.TRIANGLES, 0, numVertices);
    requestAnimationFrame(render);
}

render()