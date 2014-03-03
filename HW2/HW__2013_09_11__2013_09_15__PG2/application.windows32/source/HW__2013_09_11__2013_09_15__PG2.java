import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class HW__2013_09_11__2013_09_15__PG2 extends PApplet {

/*
Nate Mara
2013-09-11

"Processing"

This program creates an environment similar to the processing IDE's
"about"/splash page.
--When the user clicks, this will spawn circles at the mouse
  position, and the circles will be connected with lines.

*/

/////////////////////////////////////////////////////////////////////

//defines variables
//--counter variable
int clickCount = 0;

//--array for storage of circle location
float[] circleX = new float[1000];
float[] circleY = new float[1000];

//--variables for the opacity of text
int helpTextFill = 255;
int helpFileFill = 255;

//--variable for text position in help file
final int helpFileX = 1280/2 - 100;

//--boolean variables for different help screens/states
boolean helpFileShowing = false;
boolean keyFileShowing = false;
boolean randomness = false;

//--color variables
int bgColor = 0xff08111a;
int circleColor = 0xff03294d;

//----Color placeholder variables
int colorD1;
int colorD2;
int colorD3;
int returnColor;

public void setup()
{
  size(1280, 720);
  background(bgColor);
  noStroke();
  randomColor();
}

public void draw()
{
  //if opacity is greater than 1, draw the help text
  if (helpTextFill > 1)
  {
    helpText();
  }

  //if opacity equal to 1, kill help text
  if (helpTextFill == 1)
  {
    hideHelpText();
    helpTextFill = 0;
  }

  //if x is pressed, do y
  if (keyPressed)
  {

    //pressing h brings up help info
    if (key == 'h' || key == 'H')
    {
      if (helpFileShowing == false)
      {
        showHelpFile();
        delay(100);
      }
      else
      {
        hideHelpFile();
        delay(100);
      }
    }

    //pressing K brings up keyboard interaction info
    if (key == 'k' || key == 'K')
    {
      if (keyFileShowing == false)
      {
        showKeys();
        delay(100);
      }
      else
      {
        hideKeys();
        delay(100);
      }
    }

    //pressing c clears the screen
    if (key == 'c' || key == 'C')
    {
      cls();
      delay(100);
    }

    //pressing r toggles random colors
    if (key == 'r' || key == 'R')
    {
      if (randomness == false)
      {
        randomOn();
        delay(100);
      }
      else
      {
        randomOff();
        delay(100);
      }
    }
  }
}

public void mousePressed()
{
  //draws line from previous circle to current circle
  if (clickCount > 0)
  {
    stroke(255);
    line((float)mouseX, (float)mouseY,
      circleX[clickCount-1], circleY[clickCount-1]);
  }

  //draws line from two circles ago to current circle
  if (clickCount > 1)
  {
    stroke(255);
    line((float)mouseX, (float)mouseY,
      circleX[clickCount-2], circleY[clickCount-2]);
  }

  //creates point in middle of circle
  noStroke();
  fill(255);
  ellipse(mouseX, mouseY, 3, 3);

  //creates circle of (loosely) random size at mouse cursor
  fill(circleColor, 100);
  float circleRadius = random(30, 70);
  ellipse(mouseX, mouseY, circleRadius, circleRadius);

  //puts the current mouse position into the array
  circleX[clickCount] = mouseX;
  circleY[clickCount] = mouseY;

  //increases the counter variable by 1
  clickCount += 1;
}

public void helpText()
{
  //hides the help text(since it is redrawn until it fades away)
  hideHelpText();

  //creates text
  fill(255, helpTextFill);
  textSize(20);
  textAlign(CENTER);
  text("Press 'H' for help", width/2, height/2);

  //increments counter variable
  helpTextFill = helpTextFill - 1;
}

public void hideHelpText()
{
  //creates rectangle to hide text
  fill(bgColor);
  rectMode(CENTER);
  rect(width/2, height/2-8, 178, 25);
}

public void showHelpFile()
{
  //clears the screen
  cls();

  //sets helpfile variable to true
  helpFileShowing = true;

  //creates rectangle backdrop for helpfile
  fill(0xff003366);
  rectMode(CORNER);
  rect(helpFileX-20, 180, 260, 150);

  //sets text options
  fill(255, helpFileFill);
  textSize(12);
  textAlign(LEFT);

  //creates helpfile text
  text("Welcome to \"Processing\"!", helpFileX, 200);
  text("This program was designed to emulate", helpFileX, 220);
  text("the look of the Processing IDE\'s", helpFileX, 235);
  text("splash screen.", helpFileX, 250);
  text("To start, just click the screen!", helpFileX, 280);
  text("For keyboard information, press \'K\'", helpFileX, 310);
}

public void hideHelpFile()
{
  //hides the help info
  cls();
  helpFileShowing = false;
}

public void cls()
{
  //clears the screen
  background(bgColor);
  clickCount = 0;
  keyFileShowing = false;
  helpFileShowing = false;
}

public void showKeys()
{
  //clears the screen
  cls();

  //sets keyfile variable to true
  keyFileShowing = true;

  //creates rectangle backdrop for keyfile
  fill(0xff003366);
  rectMode(CORNER);
  rect(helpFileX-20, 180, 235, 130);

  //creates keyfile text
  fill(255, helpFileFill);
  textSize(12);
  textAlign(LEFT);
  text("Keys:", helpFileX, 200);
  text("K - Show/Hide this key list", helpFileX, 230);
  text("C - Clears the screen", helpFileX, 250);
  text("R - Turns random color on/off", helpFileX, 270);
  text("H - Show/Hide help document", helpFileX, 290);
}

public void hideKeys()
{
  //hides the keyboard info
  cls();
  keyFileShowing = false;
}

public void randomOn()
{
  //clears the screen and assigns the background and circle colors
  //  to two seperate values
  randomness = true;
  bgColor = randomColor();
  circleColor = randomColor();
  cls();
}

public void randomOff()
{
  //puts the colors back to their normal values
  randomness = false;
  bgColor = 0xff08111a;
  circleColor = 0xff03294d;
  cls();
}

public int randomColor()
{
  //returns a random color in the RGB color space
  colorD1 = (int)random(0,256);
  colorD2 = (int)random(0,256);
  colorD3 = (int)random(0,256);
  returnColor = color(colorD1, colorD2, colorD3);
  return(returnColor);
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "HW__2013_09_11__2013_09_15__PG2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
