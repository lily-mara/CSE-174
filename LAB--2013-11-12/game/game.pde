Pixelite pete; // just a variable, not an object.
Pixelite tony;
boolean moveRight;
boolean moveLeft;

void setup() {
  size(600, 400);
  smooth();
  pete = new Pixelite(10); // creates pixelite object
  tony = new Pixelite(10);
}

void draw() {
  pete.update();
  tony.update();
  
  background(200);
  fill(255, 0,0);
  rect(100, 300, 75, 10);
  pete.repel(100, 300, 75, 10);
  pete.display();
  tony.repel(100, 300, 75, 10);
  tony.display();
  
  if (moveRight) {
    pete.moveRight();
    tony.moveRight();
  }
  if (moveLeft) {
    pete.moveLeft();
    tony.moveLeft();
  }
}

void keyPressed() {
  if (keyCode == LEFT) {
    moveLeft = true;
  }
  
  if (keyCode == RIGHT) {
    moveRight = true;
  }
  
  if (keyCode == DOWN) {
    pete.changeRollMode();
  }
  
  if (keyCode == UP) {
    pete.jump();
  }
}

void keyReleased() {
  if (keyCode == LEFT) {
    moveLeft = false;
  }
  
  if (keyCode == RIGHT) {
    moveRight = false;
  }
}
