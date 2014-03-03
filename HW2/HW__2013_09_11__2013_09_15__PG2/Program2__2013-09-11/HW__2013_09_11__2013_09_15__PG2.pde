/*
Nate Mara
 2013-09-11
 
 "Processing"
 
 This program creates an environment similar to the processing IDE's
 "about"/splash page.
 --When the user clicks, this will spawn circles at the mouse position,
 and the circles will be connected with lines.
 
 */

//////////////////////////////////////////////////////////////////////

//defines variables
int clickCount = 0;
float preMouseX;
float preMouseY;

void setup()
{
  size(1280, 720);
  background(#08111a);
  noStroke();
}

void draw()
{
}

void mousePressed()
{
  //draws line from previous circle to current circle
  if (clickCount > 0)
  {
    stroke(255);
    line((float)mouseX, (float)mouseY, preMouseX, preMouseY);
  }

  //increases the counter variable by 1
  clickCount += 1;

  preMouseX = mouseX;
  preMouseY = mouseY;

  //puts the current mouse position into the list
  //circleListX.add(mouseX);
  //circleListY.add(mouseY);
 
  //creates point in middle of circle
  noStroke();
  fill(255);
  ellipse(mouseX, mouseY, 3, 3);

  //creates circle of random size at mouse cursor
  fill(#03294d, 100);
  float circleRadius = random(30, 70);
  ellipse(mouseX, mouseY, circleRadius, circleRadius);
}

