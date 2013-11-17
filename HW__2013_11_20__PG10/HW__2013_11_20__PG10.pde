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

}

void draw() {
  background(0);
  debuggingGrid(255);
}

void debuggingGrid(int lineColor) {
  line(mouseX, 0, mouseX, height);
  line(0, mouseY, width, mouseY);

  fill(lineColor);
  strokeWeight(3);
  stroke(lineColor);

  text(mouseX, mouseX + 10, mouseY - 20);
  text(mouseY, mouseX + 10, mouseY - 10);
}

