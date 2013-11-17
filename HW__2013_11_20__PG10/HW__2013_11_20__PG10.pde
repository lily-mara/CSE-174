/*
Nate Mara
2013-11-17

"Pixelite"

This program Creates several pixelite objects 
and allows the user to interact with them

*/

boolean moveLeft = false;
boolean moveRight = false;

Pixelite pacman = new Pixelite(300, 430, 999);
color gridColor = (#2121de);

void setup() {
  size(597, 768);
  pacman.changeRollMode();
  pacman.setColor(255, 255, 0);

  smooth();
}

void draw() {
  background(0);
  drawPacManGrid();
  debuggingGrid(255);
  noStroke();
  pacman.update();
  pacman.talk();
  pacman.display();
  makeHitBoxes(pacman);
  movePix();
}

void debuggingGrid(int lineColor) {
  fill(lineColor);
  strokeWeight(3);
  stroke(lineColor);

  line(mouseX, 0, mouseX, height);
  line(0, mouseY, width, mouseY);

  text(mouseX, mouseX + 10, mouseY - 20);
  text(mouseY, mouseX + 10, mouseY - 10);
}

void drawBorders() {
  stroke(gridColor);
  strokeWeight(2);

  // left border
  line(5, 67, width - 5, 67);
  line(5, 67, 5, 277);
  line(5, 476, 5, 724);
  line(5, 476, 116, 476);
  line(5, 277, 116, 277);
  line(116, 277, 116, 341);
  line(116, 404, 116, 476);
  line(5, 341, 116, 341);
  line(5, 404, 116, 404);

  //right border
  line(5, 724, width - 5, 724);
  line(width - 5, 67, width - 5, 277);
  line(width - 5, 476, width - 5, 724);
  line(width - 5, 476, width - 116, 476);
  line(width - 5, 277, width - 116, 277);
  line(width - 116, 277, width - 116, 341);
  line(width - 116, 404, width - 116, 476);
  line(width - 5, 341, width - 116, 341);
  line(width - 5, 404, width - 116, 404);

}

void drawPacManGrid() {
  drawBorders();

}

void makeHitBoxes(Pixelite inPixelite) {
  inPixelite.repel(0, 722, width, height - 722); //bottom 
  inPixelite.repel(0, 277, 116, 64);
  inPixelite.repel(0, 404, 116, 64);
  inPixelite.repel(481, 277, 116, 64);
  inPixelite.repel(481, 404, 116, 64);
}

void keyPressed() {
  if (keyCode == RIGHT) {
    moveRight = true;
  }

  if (keyCode == LEFT) {
    moveLeft = true;
  }

  if (keyCode == UP) {
    pacman.jump();
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

void movePix() {
  if (moveRight) {
    pacman.moveRight();
  }
  if (moveLeft) {
    pacman.moveLeft();
  }
}
