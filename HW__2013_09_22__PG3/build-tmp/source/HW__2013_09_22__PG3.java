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

public class HW__2013_09_22__PG3 extends PApplet {

/*
Nate Mara
2013-09-21

"House"

This program draws a simple house that follows 
the mouse cursor and responds to various user inputs

*/

// defines variables/constants for the house
// --size
int houseWidth = 50;
int houseHeight = 100;
final int houseSizeDelta = 5;

// --color
int colorR = 17;
int colorG = 46;
int colorB = 209;
final int colorDelta = 3;

// --position
int baseX = mouseX;
int baseY = mouseY - houseHeight;
final int housePosDelta = 5;

// --roof
int triX1 = mouseX - houseWidth;
int triX2 = mouseX;
int triX3 = mouseX - houseWidth/2;
int triY = mouseY - houseHeight;

// declares variables for the color of the background
int bgR = mouseX % 256;
int bgG = 255 - (mouseY % 256);
int bgB = mouseY % 256;

// defines constants for the spacing and position of text
final int textX = 15;
final int textY = 20;
final int textSpace = 14;

public void setup() {
	size(400, 400);
}

public void draw() {
	colorTheBackground();
	drawBase();
	drawRoof();
	printStats();
}

public void colorTheBackground() {
	
	// defines the background color variables
	bgR = mouseX % 256;
	bgG = 255 - (mouseY % 256);
	bgB = mouseY % 256;

	// colors the background according to the position of the mouse
	background(bgR, bgG, bgB);
}

public void printStats(){
	// defines the fill of the text
	fill(255);
	
	// the text printed to screen
	text("Location of cursor: " + mouseX + ", " + mouseY, 
		textX, lineNum(1));
	
	text("House Size: " + houseWidth + " x " + houseHeight,
		textX, lineNum(2));
	
	text("House Color: " + colorR + ", " + colorG + ", " + colorB,
		textX, lineNum(3));
	
	text("Roof Color: " + invCol(colorR) + ", " + 
		invCol(colorG) + ", " + invCol(colorB),
		textX, lineNum(4));
	
	text("Background color: " + bgR + ", " + bgG + ", " + bgB, 
		textX, lineNum(5));

	text("Created by Nate Mara",
		textX, lineNum(6));
	
	// text("A Nate Mara Production", 
	// 	textX, lineNum(7));
	// text("Produced and directed by Nate Mara", 
	// 	textX, lineNum(8));
	// text("All proceeds benefit Nate Mara", 
	// 	textX, lineNum(9));

}

public void drawBase(){
	// defines color for house
	fill(colorR, colorG, colorB);
		
	// draws "house" rectangle
	rect(baseX, baseY, houseWidth, houseHeight);

	// defines boolean for house touching mouse
}

public void drawRoof(){
	// defines roof color
	fill(invCol(colorR), invCol(colorG), invCol(colorB));
	
	// draws roof
	triangle(triX1, triY, 
		triX2 , triY,
		triX3, triY - houseHeight/2);
}

public int invCol(int inputColor) {
	// returns the inverted color passed as an int argument
	return 255 - inputColor;
}

public int lineNum(int lineNumber) {
	return textY + textSpace * (lineNumber - 1);
}

public void keyPressed() {
	// makes the arrow keys affect house size
	if (key == CODED) {
		if (keyCode == UP) {
			houseHeight = houseHeight + houseSizeDelta;
			defineHouse();
		}
		if (keyCode == DOWN) {
			houseHeight = houseHeight - houseSizeDelta;
			defineHouse();
		}
		if (keyCode == RIGHT) {
			houseWidth = houseWidth - houseSizeDelta;
			defineHouse();
		}
		if (keyCode == LEFT) {
			houseWidth = houseWidth + houseSizeDelta;
			defineHouse();
		}
	}

	// makes RGB keys affect RGB color of house
	if (key == 'r' | key == 'R') {
		colorR = (colorR + colorDelta) % 256;
	}
	if (key == 'g' | key == 'G') {
		colorG = (colorG + colorDelta) % 256;
	}
	if (key == 'b' | key == 'B') {
		colorB = (colorB + colorDelta) % 256;
	}

	// the WASD keys change the house's position
	if (key == 's' | key == 'S') {
		baseY = baseY - housePosDelta;
		triY = triY - housePosDelta;
	}
	if (key == 'w' | key == 'W') {
		baseY = baseY + housePosDelta;
		triY = triY + housePosDelta;
	}
	if (key == 'a' | key == 'A') {
		baseX = baseX - housePosDelta;
		triX1 =  triX1 - housePosDelta;
		triX2 =  triX2 - housePosDelta;
		triX3 =  triX3 - housePosDelta;
	}
	if (key == 'd' | key == 'D') {
		baseX = baseX + housePosDelta;
		triX1 =  triX1 + housePosDelta;
		triX2 =  triX2 + housePosDelta;
		triX3 =  triX3 + housePosDelta;
	}
}

public void mouseMoved() {
	// redefines house position whenever mouse is moved
	defineHouse();
}

public void defineHouse() {
	// redefines the houseX & Y variables
	baseX = mouseX - houseWidth;
	baseY = mouseY - houseHeight;
	triX1 = mouseX - houseWidth;
	triX2 = mouseX;
	triX3 = mouseX - houseWidth/2;
	triY = mouseY - houseHeight;
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "HW__2013_09_22__PG3" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
