import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class HW__2013_09_11__2013_09_15__PG2 extends PApplet {

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

public void setup()
{
  size(1280, 720);
  background(0xff08111a);
  noStroke();
}

public void draw()
{
}

public void mousePressed()
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
  fill(0xff03294d, 100);
  float circleRadius = random(30, 70);
  ellipse(mouseX, mouseY, circleRadius, circleRadius);
}

  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#F0F0F0", "HW__2013_09_11__2013_09_15__PG2" });
  }
}
