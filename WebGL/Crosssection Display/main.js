function setup() {
  // Crate Canvas for Project
  createCanvas(500, 500, WEBGL);
  rectMode(CENTER);
  angleMode(DEGREES);

  HSFOptions = createSelect();
  HSFOptions.option("Remove Hidden Surfaces");
  HSFOptions.option("Show Hidden Surfaces");

  changeOrder = createButton("Change Object Order");
  changeOrder.mousePressed(buttonPressed);
  changeNum = 0;

  //Top
  rect1 = new Rectangle();
  rect1.pos(0, -100);
  rect1.size(50, 400);
  rect1.rot(75);
  rect1.color(250, 0, 0);

  //Left
  rect2 = new Rectangle();
  rect2.pos(-100, 0);
  rect2.size(50, 400);
  rect2.rot(-25);
  rect2.color(0, 250, 0);

  //Bottom
  rect3 = new Rectangle();
  rect3.pos(0, 100);
  rect3.size(50, 400);
  rect3.rot(75);
  rect3.color(250, 250, 0);

  //Right
  rect4 = new Rectangle();
  rect4.pos(100, 0);
  rect4.size(50, 400);
  rect4.rot(-25);
  rect4.color(0, 0, 250);

  //Top Right
  rect5 = new Rectangle();
  rect5.pos(50, -113);
  rect5.size(50, 200);
  rect5.rot(75);
  rect5.color(250, 0, 0);
}

function draw() {

  if (HSFOptions.value() == "Remove Hidden Surfaces") {
    noStroke();
    update();
  } else if (HSFOptions.value() == "Show Hidden Surfaces") {
    stroke(0);
    update();
  }
  function update() {
    clear();
    background(50);
    insertRectangles();
  }
  function insertRectangles() {
    console.log(changeNum);
    switch (changeNum) {
        case 1:
            rect1.display();
            rect3.display();
            rect5.display();
            rect2.display();
            rect4.display();
            break;
        case 2:
            rect2.display();
            rect4.display();
            rect1.display();
            rect3.display();
            rect5.display();
            break;
        case 3:
            rect1.display();
            rect5.display();
            rect4.display();
            rect2.display();
            rect3.display();
            break;
        default:
            rect1.display();
            rect2.display();
            rect3.display();
            rect4.display();
            rect5.display();
            break;
    }
  }
}

function buttonPressed() {
    changeNum += 1;
    changeNum %= 4;
}

function Rectangle() {
  this.pos = function (x, y) {
    this.x = x;
    this.y = y;
  }
  this.rot = function(a) {
    this.a = a;
  }
  this.size = function (w, h) {
    this.w = w;
    this.h = h;
  }
  this.color = function (r, g, b) {
    this.r = r;
    this.g = g;
    this.b = b;
  }

  this.display = function () {
    push();
    translate(this.x, this.y);
    rotate(this.a);
    fill(this.r, this.g, this.b);
    
    rect(0, 0, this.w, this.h);
    pop();
  };
}
