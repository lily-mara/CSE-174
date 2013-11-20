/*
Nate Mara
2013-11-17

"pacman"

This program creates a pacman object 
and allows the user to interact with it

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

// sets size and appearance
void setup() {
  size(597, 768);
  setAppearance();

  smooth();
}

// calls the talk, update, and display methods from the pacman class
// , draws the grid in the background, and makes the collision objects 
void draw() {
  background(0);
  drawDots();
  drawPacManGrid();
  //debuggingGrid(255, pacman.getPosX(), pacman.getPosY());
  //debuggingGrid(#FF0000, mouseX, mouseY);
  noStroke();
  pacman.update();
  pacman.talk();
  pacman.display();
  makePacManGrid();
  movePix();
  wrapAround();
}

// debugging method that draws a crosshair at the argument
// position with the argument color
void debuggingGrid(color lineColor, float posX, float posY) {
  fill(lineColor);
  strokeWeight(3);
  stroke(lineColor);

  line(posX, 0, posX, height);
  line(0, posY, width, posY);

  text((int) posX, 20, 40);
  text((int) posY, 20, 60);
}

// draws the outline of the playing field
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

// calls all of the methods that draw the playing field grid
void drawPacManGrid() {
  drawBorders();
  drawLowerBowl();
  drawUpperBowl();
  drawGhostBox();
}

// calls all of the methods that make the physics
// of the playing field grid
void makePacManGrid() {
  borderHitBoxes(pacman);
  makeLowerBowl();
  makeUpperBowl();
  makeGhostBox();
}

// makes all of the hit boxes for the playing field border
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

// the next several methods control movement
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

// if pacman object goes to the side, teleports to the
// other side in the same place
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

// sets the color of a new pacman object, and makes it roll
// instead of the standard sliding
void setAppearance() {
  pacman.changeRollMode();
  pacman.setColor(255, 255, 0);
}

// draws the platforms in the lower bowl
void drawLowerBowl() {
  //start platform
  drawCollisionBox(230, 560, 137, 10);

  //lower bowl devider
  drawCollisionBox(79, 652, 182, 10);
  drawCollisionBox(336, 652, 182, 10);

  //upper-lower bowl
  drawCollisionBox(5, 560, 150, 10);
  drawCollisionBox(442, 560, 150, 10);
}

// makes the hitboxes for the platforms in the lower bowl
void makeLowerBowl() {
  //start platform
  pacman.repel(230, 560, 137, 10);

  //lower bowl devider
  pacman.repel(79, 652, 182, 10);
  pacman.repel(336, 652, 182, 10);

  //upper-lower bowl
  pacman.repel(5, 560, 150, 10);
  pacman.repel(442, 560, 150, 10);

}

// how a platform should look. 
// called in a similar manner to the rect function
void drawCollisionBox(float bX, float bY, float bWidth, float bHeight) {
  line(bX, bY, bX + bWidth, bY);
  line(bX, bY + bHeight, bX + bWidth, bY + bHeight);
  line(bX, bY, bX, bY + bHeight);
  line(bX + bWidth, bY, bX + bWidth, bY + bHeight);
}

// draws the platforms in the upper bowl
void drawUpperBowl() {
  //lower bowl devider
  drawCollisionBox(79, 127, 182, 10);
  drawCollisionBox(336, 127, 182, 10);

  //upper-lower bowl
  drawCollisionBox(5, 200, 150, 10);
  drawCollisionBox(230, 200, 137, 10);
  drawCollisionBox(442, 200, 150, 10);
}

// makes the hitboxes for the platforms in the upper bowl
void makeUpperBowl() {
  //lower bowl devider
  pacman.repel(79, 127, 182, 10);
  pacman.repel(336, 127, 182, 10);

  //upper-lower bowl
  pacman.repel(5, 200, 150, 10);
  pacman.repel(230, 200, 137, 10);
  pacman.repel(442, 200, 150, 10);
}

//makes the hitbox for the box in which the ghosts stay
void makeGhostBox() {
  pacman.repel(198, 309, 200, 96);
}

// draws the box in which the ghosts stay
void drawGhostBox() {
  PImage ghosts = loadImage("ghosts.png"); 

  drawCollisionBox(198, 309, 200, 96);
  drawCollisionBox(208, 319, 180, 76);

  image(ghosts, 234, 330);
}

// draws the dots that pacman should eat, but that's
// beyond the scope of this program.
void drawDots() {
  fill(255);
  int[] heights = {95, 164, 242, 519, 611, 691, 373};

  for (int j : heights) {
    for (int i = 35; i < width - 35; i += 30)
      rect(i, j, 5, 5);
  }

  fill(0);
  rect(117, 348, 353, 40);
}
