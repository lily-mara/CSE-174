/*
Nate Mara
2013-11-17

"Pixelite"

This program Creates several pixelite objects 
and allows the user to interact with them

methods used:
update
repel
display
talk
moveRight
moveLeft
changeRollMode
jump
getPosX
getPoxY
setColor

*/

boolean moveLeft = false;
boolean moveRight = false;
boolean jump = false;
boolean keyHeld = false;

int curTime = 0;

Pixelite pacman = new Pixelite(300, 507, 999);

color gridColor = (#2121de);

void setup() {
  size(597, 768);
  setAppearance();

  smooth();
}

void draw() {
  background(0);
  drawPacManGrid();
  //debuggingGrid(255, pacman.getPosX(), pacman.getPosY());
  debuggingGrid(#FF0000, mouseX, mouseY);
  noStroke();
  pacman.update();
  pacman.talk();
  pacman.display();
  makePacManGrid();
  movePix();
  wrapAround();
}

void debuggingGrid(color lineColor, float posX, float posY) {
  fill(lineColor);
  strokeWeight(3);
  stroke(lineColor);

  line(posX, 0, posX, height);
  line(0, posY, width, posY);

  text((int) posX, 20, 40);
  text((int) posY, 20, 60);
}

void drawBorders() {
  stroke(gridColor);
  strokeWeight(1);

  //top
  line(5, 67, width - 5, 67);

  //bottom
  line(5, 724, width - 5, 724);

  // left border
  line(5, 67, 5, 277);
  line(5, 476, 5, 724);
  line(5, 476, 116, 476);
  line(5, 277, 116, 277);
  line(116, 277, 116, 341);
  line(116, 404, 116, 476);
  line(5, 341, 116, 341);
  line(5, 404, 116, 404);

  //right border
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
  drawLowerBowl();
}

void makePacManGrid() {
  borderHitBoxes(pacman);
  makeLowerBowl();
}

void borderHitBoxes(Pixelite inPixelite) {
  inPixelite.repel(0, 722, width, height - 722); //bottom 
  inPixelite.repel(0, 277, 116, 64);
  inPixelite.repel(0, 404, 116, 64);
  inPixelite.repel(481, 277, 116, 64);
  inPixelite.repel(481, 404, 116, 64);
  inPixelite.repel(0, 0, width, 67);
  inPixelite.repel(0, 0, 5, height);
  inPixelite.repel(width - 5, 0, 5, height);
}

void keyPressed() {
  if (keyCode == RIGHT) {
    moveRight = true;
  }

  if (keyCode == LEFT) {
    moveLeft = true;
  }

  if (keyCode == UP) {
    jump = true;
  }

  if (key == 'r') {
    pacman = new Pixelite(300, 530, 999);
    setAppearance();
  }
}

void keyReleased() {
  keyHeld = false;

  if (keyCode == LEFT) {
    moveLeft = false;
  }

  if (keyCode == RIGHT) {
    moveRight = false;
  }

  if (keyCode == UP) {
    jump = false;
  }
}

void movePix() {
  if (moveRight) {
    pacman.moveRight();
  }
  if (moveLeft) {
    pacman.moveLeft();
  }
  if (jump && !keyHeld) {
    keyHeld = true;
    pacman.jump();
  }
}

void jumpTest() {
  if (millis() > curTime + 500) {
    curTime = millis();
    pacman.jump();
  }
}

void wrapAround() {
  int correctHeight = 374;
  int leftWall = 35;
  int rightWall = 562;
  float x = pacman.getPosX();
  float y = pacman.getPosY();

  if (y == correctHeight) {
    if (x == leftWall && moveLeft) {
      pacman = new Pixelite(rightWall, correctHeight, 999);
      setAppearance();
    }
    else if (x == rightWall && moveRight) {
      pacman = new Pixelite(leftWall, correctHeight, 999);
      setAppearance();
    }
  }
}

void setAppearance() {
  pacman.changeRollMode();
  pacman.setColor(255, 255, 0);
}

void drawLowerBowl() {
  //start platform
  drawCollisionBox(230, 560, 137, 20);

  //lower bowl devider
  drawCollisionBox(79, 652, 182, 10);
  drawCollisionBox(336, 652, 182, 10);

  //upper-lower bowl
  drawCollisionBox(5, 560, 150, 10);
  drawCollisionBox(442, 560, 150, 10);
}

void makeLowerBowl() {
  //start platform
  pacman.repel(230, 560, 137, 20);

  //lower bowl devider
  pacman.repel(79, 652, 182, 10);
  pacman.repel(336, 652, 182, 10);

  //upper-lower bowl
  pacman.repel(5, 560, 150, 10);
  pacman.repel(442, 560, 150, 10);

}

void drawCollisionBox(float bX, float bY, float bWidth, float bHeight) {
  line(bX, bY, bX + bWidth, bY);
  line(bX, bY + bHeight, bX + bWidth, bY + bHeight);
  line(bX, bY, bX, bY + bHeight);
  line(bX + bWidth, bY, bX + bWidth, bY + bHeight);
}
