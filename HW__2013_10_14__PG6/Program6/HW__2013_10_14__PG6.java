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

public class HW__2013_10_14__PG6 extends PApplet {

/*
Nate Mara
2013-10-12

"Space Invaders"

This program A *very* barebones version of the game "Space Invaders" . 
I currently have not implimented any actual game mechanics, like score 
or shot collisions with enemies, but it's a WIP.

*/

// Triggers a user can change
boolean isSpaceInvaders = true;
int textStartY = 720/2;
final int textLineSpacing = 30;
final int shotSpeed = 9;
int sStartY = 100;
int sStartX = 75;
int sDeltaY = 75;

// Variables that the program uses
boolean shotExists = false;
int shotX;
int score = 0;
int playerPosX;
int playerPosY;
int shotY;

// Loads outside resources (image and font)
PFont pixelFont;
PImage roof;

// Arrays that store positions of the Invaders
int[] row1X = new int[11];
int[] row2X = new int[11];
int[] row3X = new int[11];
int[] row4X = new int[11];
int[] row5X = new int[11];

int[] row1Y = new int[11];
int[] row2Y = new int[11];
int[] row3Y = new int[11];
int[] row4Y = new int[11];
int[] row5Y = new int[11];

public void setup() {
	pixelFont = loadFont("Courier.vlw");
	roof = loadImage("roof.png");

	size(651, 744);
	FormatText();
	SpaceInvaderChecker();
	noStroke();
}

public void draw(){
	background(0);
	CreatePlayer(mouseX, height - 100);
	ShotChecker();
	RenderGUI();
	makeSIArray();
	DrawSIArray();
	DrawRoofs();
	FuckAllShow();
}

public void SpaceInvaderChecker() {
	if (!isSpaceInvaders) {
		TextLine("Well look at you, messing with source code, thinking you\'re soooo great.", -1);
		TextLine("Tell me, what exactly did you think would happen,", 0);
		TextLine("When you changed the value of \"isSpaceInvaders\" from true to false?", 1);
		TextLine("Did you think that PacMan would start?", 2);
	}
}

public void TextLine(String inputText, int inputLine) {
	int textLine = textStartY + (inputLine - 1) * textLineSpacing;
	text(inputText, width/2, textLine);
}

public void FormatText() {
	textAlign(CENTER);
	textSize(30);
}

public void DrawPlayer(int posX, int posY) {
	/*
	Draws the player "space ship" at the coordinates given by the 
	parameters. posX refers to the X coordinate of the center of the
	player, and posY refers to the Y coordinate of the top of the player.
	*/
	fill(0xff00FC00);

	rectMode(CENTER);
	rect(posX, posY + 20, 52, 16);
	rect(posX, posY + 10, 44, 04);
	rect(posX, posY + 06, 12, 8);
	rect(posX, posY + 00, 4, 4);
}

public void CreatePlayer(int posX, int posY) {
	int leftBarrier = 30;
	int rightBarrier = width - 30;
	playerPosY = posY;

	if (posX > leftBarrier && posX < rightBarrier) {
		playerPosX = posX;

		DrawPlayer(posX, posY);
	}
	else if (posX < leftBarrier) {
		playerPosX = leftBarrier;

		DrawPlayer(leftBarrier, posY);
	}
	else if (posX > rightBarrier) {
		playerPosX = rightBarrier;

		DrawPlayer(rightBarrier, posY);
	}
}

public void Shoot(int posX) {
	fill(255);
	rect(posX, shotY, 5, 20);

}

public void mousePressed() {
	if (!shotExists) {
		shotX = playerPosX;
		shotY = playerPosY - 10;
		shotExists = true;
	}
	
}

public void ShotChecker() {
	/*
	Runs in background, controls various aspects of the laser shot.
	*/
	boolean collidesWithRoof1 = 45<shotX && shotX<145;
	boolean collidesWithRoof2 = 195<shotX && shotX<295;
	boolean collidesWithRoof3 = 345<shotX && shotX<445;
	boolean collidesWithRoof4 = 495<shotX && shotX<595;

	boolean collidesWithRoofs = collidesWithRoof1 || 
		collidesWithRoof2 || collidesWithRoof3 || collidesWithRoof4;


	if (shotExists) {
		Shoot(shotX);
		shotY -= shotSpeed;
	}
	if (shotY < 0 || (collidesWithRoofs) && shotY < 550) {
		shotExists = false;
	}
}

public void RenderGUI() {
	fill(255);
	textFont(pixelFont, 20);
	text("SCORE: " + score, 50, 20);
}

public void RenderSI(int centerX, int centerY) {
	// this massive ClusterFuck of code creates one Space Invader.
	// I will not be making the other 5...
	rect(centerX, centerY + 5, 28, 8);
	rect(centerX, centerY, 12, 16);
	rect(centerX - 12, centerY + 10, 4, 4);
	rect(centerX + 12, centerY + 10, 4, 4);
	rect(centerX - 6, centerY + 14, 8, 4);
	rect(centerX + 6, centerY + 14, 8, 4);
	rect(centerX - 8, centerY - 10, 4, 4);
	rect(centerX + 8, centerY - 10, 4, 4);
	rect(centerX - 12, centerY - 14, 4, 4);
	rect(centerX + 12, centerY - 14, 4, 4);
	rect(centerX - 10, centerY - 6, 8, 4);
	rect(centerX + 10, centerY - 6, 8, 4);
	rect(centerX - 12, centerY - 1, 4, 6);
	rect(centerX + 12, centerY - 1, 4, 6);
	rect(centerX - 16, centerY - 0, 4, 8);
	rect(centerX + 16, centerY - 0, 4, 8);
	rect(centerX - 20, centerY + 6, 4, 12);
	rect(centerX + 20, centerY + 6, 4, 12);
}

public void makeSIArray() {
	for (int i = 0; i<11; i++) {
		row1X[i] = sStartX + (i * 50);
		row2X[i] = sStartX + (i * 50);
		row3X[i] = sStartX + (i * 50);
		row4X[i] = sStartX + (i * 50);
		row5X[i] = sStartX + (i * 50);

		row1Y[i] = sStartY;
		row2Y[i] = sStartY + sDeltaY * 1;
		row3Y[i] = sStartY + sDeltaY * 2;
		row4Y[i] = sStartY + sDeltaY * 3;
		row5Y[i] = sStartY + sDeltaY * 4;
	}
}

public void DrawSIArray() {
	for (int i = 0; i<11; i++) {
		RenderSI(row1X[i], row1Y[i]);
		RenderSI(row2X[i], row2Y[i]);
		RenderSI(row3X[i], row3Y[i]);
		RenderSI(row4X[i], row4Y[i]);
		RenderSI(row5X[i], row5Y[i]);
	}
}

public void DrawRoof(int posX, int posY) {
	image(roof, posX, posY, 88, 64);
}

public void DrawRoofs() {
	DrawRoof(50, 525);
	DrawRoof(200, 525);
	DrawRoof(350, 525);
	DrawRoof(500, 525);
}

public int FuckAll(int arg1, int arg2, int arg3, int arg4, boolean arg5) {
	/*
	Because I needed to fill this condition. I'm sure I'll use
	this for something. This function generates an int value that will
	be used as a psuedo-boolean value by incorporating it into an if 
	statement.
	*/
	if (arg5) {
		return ((arg1 + arg2)/arg3)- arg4;
	}
	else {
		return 4;
	}
}

public boolean FuckAllBoolean(int arg1, int arg2, int arg3, int arg4, boolean arg5) {
	int FuckAll = FuckAll(arg1, arg2, arg3, arg4, arg5);
	if (FuckAll < 685) {
		return true;
	}
	else {
		return false;
	}
}

public void FuckAllShow() {
	if (!FuckAllBoolean(1,5,77,mouseX,true)) {
		text("This will never show up.", 500, 500);
	}
}
  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#F0F0F0", "HW__2013_10_14__PG6" });
  }
}
