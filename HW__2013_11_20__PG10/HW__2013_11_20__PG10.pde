/*
Nate Mara
2013-11-17

"Pixelite"

This program Creates several pixelite objects 
and allows the user to interact with them

*/

Pixelite pacman = new Pixelite();

void setup() {
  size(597, 768);
  pacman.changeRollMode();

}

void draw() {
  background(0);
  drawPacManGrid();
  debuggingGrid(255);
  pacman.update();
  pacman.display();
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
  color gridColor = (#2121de);
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
