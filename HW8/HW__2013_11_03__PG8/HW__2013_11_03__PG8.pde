/*
Nate Mara
2013-10-29

"Loop Art HW"

This program Draws some stuff using loops. 
Nothing special really. 

I originally wrote an animated version of the 
drawRainbowTriangles() function in September that used no 
loops, but I modified the code slightly to fit this program.

*/

//some constants that the user can edit to change appearence
final int triRate = 2;
final int triWidth = 2;

void setup()
{
	//sets up the window's appearence
	size(1280, 720);
	noStroke();
	smooth();


	//calls the functions
	makeBoxesRight(0, height - 100);
	makeBoxesLeft(width - 100, height - 100);
	drawTriangleBackground(15, 15);
	drawLines();
	drawCirclesToRight(width/2 , height/2);
	drawCirclesToLeft(width/2 - 124, height/2);
	drawRainbowTriangles();
}

void drawRainbowTriangles() {
	// Draws rainbow-colored triangles from bottom and top borders
	// to the center of window.

	for (int m = 0; m < width * triRate; m++) {
		int x = m/triRate;
		int topY = 0; 
		int botY = height;

		fill(m%150+50, m/2%150+50, m/4%150+50);
		
		triangle(x, topY, x - triWidth, topY,width/2,height/2);//top triangle
		
		triangle(x, botY, x - triWidth, botY,width/2,height/2);//bottom triangle
	}
}

void drawCirclesToRight(int startX, int y) {
	// Draws a group of 40 circles starting at point (startX, y) and
	// moving forward by 3 pixels, with random color and increasing
	// opacity.

	for (int i = 1; i <= 40; i++) {
		fill(random(256), random(256), random(256), i * 4);
		ellipse(startX + 3*i, y, 40, 40);
	}
}

void drawCirclesToLeft(int startX, int y) {
	// Draws a group of 40 circles starting at point (startX, y) and
	// moving forward by 3 pixels, with random color and increasing
	// opacity.

	int i = 40;

	while (i >= 1) {
		fill(random(256), random(256), random(256), 160 - i * 4);
		ellipse(startX + 3*i, y, 40, 40);
		i--;
	}
}

void drawTriangleBackground(int numColumns, int numRows) {
	// Draws an array of overlaping triangles `numColumns` wide, and
	// `numRows` high. The triangles have similar, non-random colors.

	int squareWidth = width / numColumns;
	int squareHeight = height / numRows;
	int squareSpacing = 30;
	int squareX = squareWidth + squareSpacing + 18;
	int squareY = squareHeight + squareSpacing;

	fill(0); 

	for (int i = 0; i < numColumns; i++) {
		for (int r = 0; r < numRows; r ++) {
			fill(100 + i * 50 % 100, 100 + r * 50 % 100, 100);
			//rect(i * squareX, r * squareY, squareWidth, squareHeight);
			triangle(i * squareX, r * squareY, i * squareX,
				r * squareY - squareHeight, i * squareX + squareWidth,
				r * squareY);
			
			fill(100 + i * 50 % 100, 100, 100 + r * 50 % 100);
			triangle(i * squareX, r * squareY, i * squareX + squareWidth,
				r * squareY - squareHeight, i * squareX + squareWidth,
				r * squareY);
		}
	}
}

void drawVerticalLineWithCircles(int x) {
	// Draws vertical rectangles of random colors
	// inside those rectangles, circles are drawn

	int colorR = (int)random(100);
	int colorG = (int)random(125);
	int colorB = (int)random(150);

	fill(#3c5680);

	rect(x, 0, 20, height);

	final int circleSize = 20;
	final int circleSpacing = 10;
	int circleY;
	
	int i = 0;
	while (i<25) {
		circleY = i * (circleSize + circleSpacing) + circleSize/2;

		// fill(colorB, colorG, colorR);
		fill(#966464);

		ellipse(x + circleSize/2, circleY, circleSize, circleSize);
		// ellipse(width - circleSize/2, circleY, circleSize, circleSize);

		i++;
	}
}

void drawLines() {
	// draws vertical lines with circles, one at each border, and two in the middle

	for (int i = 0; i < 2; i++) {
		drawVerticalLineWithCircles(i * (width - 20));
	}

	int i = width/ 4;

	while (i < width) {
		drawVerticalLineWithCircles(i);
		i*=3;
	}
}

void makeBoxesRight(int x, int y) {
	// Creates a series of boxes starting at position (x, y)
	// and contiuing in a right arc.
int opacity = 250;
int xSpacing = 100;
int ySpacing = 100;
int rectSize = 100;

	while (rectSize > 0){
		fill(random(100), random(100), random(100), opacity);
		rect(x, y, rectSize, rectSize);

		opacity -= 50;
		x += xSpacing;
		y -= ySpacing;
		ySpacing -= 10;
		rectSize -= 10;
	}
}

void makeBoxesLeft(int x, int y) {
	// Creates a series of boxes starting at position (x, y)
	// and contiuing in a right arc.
int opacity = 250;
int xSpacing = 100;
int ySpacing = 100;
int rectSize = 100;

	while (rectSize > 0){
		fill(random(100), random(100), random(100), opacity);
		rect(x, y, rectSize, rectSize);

		opacity -= 50;
		x -= xSpacing;
		y -= ySpacing;
		ySpacing -= 10;
		rectSize -= 10;
	}
}