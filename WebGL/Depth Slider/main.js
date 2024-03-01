// Slider to Control Depth
let slider;


// Create Canvas and Get Slider Value
function setup() {
  createCanvas(500, 500, WEBGL);
  dropdown = createSelect();
}

function draw() {
  background(100);

  // Draw Rectangle
  rectMode(CENTER);

  // Rotate cube
  rotateX(frameCount * 0.01);
  rotateY(frameCount * 0.01);

  // Color Cube
  normalMaterial();
  push();
  
  fill

  // Control Depth through changing Height and Width
  box(slider.value(), slider.value(), slider.value(), 50, 50);
}
