function setup() {
  // Crate Canvas for Project
  createCanvas(500, 500, WEBGL);

  // Dropdown Options for Material
  dropdownMaterial = createSelect();
  dropdownMaterial.option("Normal Material");
  dropdownMaterial.option("Ambient Material");
  dropdownMaterial.option("Specular Material");

  // Dropdown Option for Lighting
  dropdownLight = createSelect();
  dropdownLight.option("Ambient Light");
  dropdownLight.option("Point Light");
  dropdownLight.option("Directional Light");

  noStroke();
}

function draw() {
  // Set Background Color
  background(50);

  // Rotate Sphere
  rotateX(frameCount * 0.01);
  rotateY(frameCount * 0.01);
  rotateZ(frameCount * 0.01);

  // Material Optiosn
  if (dropdownMaterial.value() == "Normal Material") normalMaterial();
  else if (dropdownMaterial.value() == "Ambient Material") ambientMaterial(255);
  else if (dropdownMaterial.value() == "Specular Material") specularMaterial(255);
  
  // Create Vector for Direction Light in order to normalize 
  let v = createVector(250, 0, 0);
  v.normalize();

  // Light Options
  if (dropdownLight.value() == "Ambient Light") ambientLight(255, 0, 0);
  else if (dropdownLight.value() == "Point Light") pointLight(0, 255, 0, 200, 0, 0);
  else if (dropdownLight.value() == "Directional Light") directionalLight(0, 0, 255, v);

  // Create Sphere to Demonstrate Light
  sphere(100);
}
