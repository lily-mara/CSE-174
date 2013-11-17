///// 	DO NOT MODIFY THIS FILE!!!     ///////

//The Pixelite, created by Doug Blase. Brandon Sonoda, the author 
//of the Sprite, contributed to the Pixelite by providing the
//Pixelite's hat, and showing how to make the Pixelite roll. Other
//segments of code were inspired/based on the Sprite program.
//Call these methods in the following order: update, repel, display.

public class Pixelite {
  private String name;
  private boolean rollMode;
  private boolean rightFace;
  private float velocityX;
  private float velocityY;
  private float posX;//Center of the circular body
  private float posY;//Center of the circular body
  private float leftBorder;//Left edge of body (radius)
  private float rightBorder;//Right edge of body (radius)
  private float upperBorder;//radius to top of body
  private float lowerBorder;//distance to bottom of body
  private color c;
  private int jumpStatus;//Number of times he can jump before touching the ground
  private int faceDirection;//helps place eyes and mouth based on the rightFace boolean
  private int talkingMouthSize;//height of mouth when talking
  private int mouthSizeIncrease;// either 1 or -1
  private final int MAX_JUMP_STATUS;//Number of times he can jump w/o touching the ground
  private float spinVal = 0;//Rotation for rollMode

  public Pixelite (String name, float posX, float posY, color c, int jumpStatus) {
    this.posX = posX;
    this.posY = posY;
    this.c = c;
    this.rightFace=true;
    this.rollMode=false;
    this.velocityX = 0;
    this.velocityY = 0;
    this.leftBorder = posX-30;
    this.rightBorder = posX+30;
    this.upperBorder = posY-30;
    this.lowerBorder = posY+40;
    this.jumpStatus = jumpStatus;
    this.MAX_JUMP_STATUS = max(1, jumpStatus);
    this.talkingMouthSize = 0;
    this.mouthSizeIncrease = 1;
    this.faceDirection = 1;
  }

  public Pixelite() {
    this("Doug", width/2, height/2, color(40, 121, 206), 1);
  }

  public Pixelite(float posX, float posY, int jumpStatus) {
    this("Doug", posX, posY, color(40, 121, 206), jumpStatus);
  }

  public Pixelite(float posX, float posY) {
    this(posX, posY, 1);
  }
  
  public Pixelite(int jumpStatus){
    this(width/2, height/2, jumpStatus);
  }

  public void display() {
    if (!rightFace)
      faceDirection = -1;
    else faceDirection = 1;

    pushMatrix();
    translate(posX, posY);
    if (rollMode)
      rotate(spinVal);//It looks like he's always rolling forward

    //Legs
    strokeWeight(2);
    fill(c);
    if (!rollMode) {
      rect(-15, 25, 10, 15);
      rect(5, 25, 10, 15);
    }

    //Trailing arm
    if (!rollMode) {
      if (!rightFace)
        rect(-32, 5, 8, 18);
      else   rect(24, 5, 8, 18);
    }
    //Body 
    ellipse(0, 0, 60, 60);

    // Hat
    if (!rollMode) {

      rotate(-faceDirection*30*6.28/360);
      fill(230, 0, 0);
      ellipse(-faceDirection*2, -30, 55, 25);
      //fill(200, 0, 0);
      ellipse(5*faceDirection, -20, 70, 10);
      ellipse(-faceDirection*2, -43.5, 6, 6);
      rotate(faceDirection*30*6.28/360); 
      fill(c);
    }

    //leading arm
    if (!rollMode) {
      if (!rightFace)
        rect(24, 5, 8, 18);
      else rect(-32, 5, 8, 18 );
    }

    //eyes
    fill(255);
    strokeWeight(1.5);

    ellipse(faceDirection*16, -10, 14, 14);
    ellipse(faceDirection*6, -10, 13, 13);
    fill(0);
    ellipse(faceDirection*7, -10, 4, 4);
    ellipse(faceDirection*17, -10, 4, 4);


    //mouth
    if (!rollMode)
      line(faceDirection*16, 10, faceDirection*6, 10);
    else {
      //  if(!isTalking)
      arc(faceDirection*11, 10, 10, 10, 0, PI);
    }

    popMatrix();
  }


  public void talk() {
    pushMatrix();
    translate(posX, posY);
    if (rollMode)
      rotate(spinVal);
    if (talkingMouthSize>5)
      this.mouthSizeIncrease *=-1;
    if (talkingMouthSize<0)
      this.mouthSizeIncrease *=-1;

    talkingMouthSize += mouthSizeIncrease;
    if (!rollMode)
      rect(faceDirection*6, 10, faceDirection*10, talkingMouthSize);
    popMatrix();
  }

  //-----------MOVING COMMANDS-----------------//
  public void moveLeft() {
    rightFace = false;
    if (rollMode)
      this.changeVelocityX(-8);
    else
      this.changeVelocityX(-3);
  }

  public void moveRight() {
    rightFace = true;
    if (rollMode)
      this.changeVelocityX(8);
    else
      this.changeVelocityX(3);
  }

  public void changeRollMode() {
    rollMode = !rollMode;
    if (rollMode)
      posY +=10;
    if (!rollMode)
      posY -=10;
    spinVal = 0;
  }

  public void jump() {
    if (rollMode)
      this.changeVelocityY(-4.5);
    else
      this.changeVelocityY(-6.5);
  }



  //-----------ACTUAL MOVEMENT------------------------//
  private void changeVelocityX(float newVelocity) {
    if (abs(getVelocityY()) >.4) {
      if (velocityX*newVelocity < 0)
        velocityX*=-.15;
      else
        velocityX = .5*newVelocity;
    }
    else
      velocityX = newVelocity;
  }

  private void changeVelocityY(float newVelocity) {
    if (jumpStatus != 0 ) {
      velocityY = newVelocity;
      jumpStatus--;
    }
  }

  private void changeX(float deltaX) {
    posX+=deltaX;
    leftBorder = posX-30;
    rightBorder = posX+30;
  }

  private void changeY(float deltaY) {
    posY +=deltaY;
    upperBorder = posY-30;
    if (rollMode)
      lowerBorder = posY+30;
    else lowerBorder = posY+40;
  }

  //----------GETTERS-------------------------------//
  public float getPosX() {
    return posX;
  }

  public float getPosY() {
    return posY;
  }

  public float getVelocityY() {
    return velocityY;
  }

  public float getVelocityX() {
    return velocityX;
  }

  public float getLeftBorder() {
    return leftBorder;
  }

  public float getRightBorder() {
    return rightBorder;
  }

  public float getUpperBorder() {
    return upperBorder;
  }

  public float getLowerBorder() {
    return lowerBorder;
  }

  public boolean getRollMode() {
    return rollMode;
  }

  public boolean isFacingRight() {
    return rightFace;
  }
  //------------SETTERS-------------------------------//  
  public void setName(String name) {
    this.name = name;
  }
  
  public void setColor(int r, int g, int b) {
    c = color(r, g, b);
  }


  //------APPLY MOVEMENTS AND WORLD INTERACTION-------// 
  public void update() {
    this.changeX(velocityX);
    this.changeY(velocityY);
    this.applyFriction();

    if (rollMode && abs(velocityX)>0) { 
      spinVal+= .1 *(velocityX/8.0);
    }
    if (abs(spinVal) > 6.28)
      spinVal = 0;
  }

  private void applyFriction() {
    //Also keeps the Pixelite on the screen
    int rollModeFactor;
    if (rollMode)
      rollModeFactor = 30;
    else rollModeFactor = 40;
    velocityX *=.95;

    //if (velocityY!=0)
      velocityY +=.2;

    if (posY+rollModeFactor > height) {
      this.velocityY=0;
      posY = height-rollModeFactor;
      jumpStatus = MAX_JUMP_STATUS;
    }


    if (posX+30>width) {
      velocityX=0;
      posX=width-30;
    }
    if (posX-30<0) {
      velocityX=0;
      posX=30;
    }
  }

  public void repel(float x, float y, float w, float h) {
    int rollModeFactor;
    if (!rollMode)
      rollModeFactor = 40;
    else rollModeFactor = 30;

    //If bottom of body hits top of rectangle
    if ((lowerBorder>y && posY> y-40 && posY<y-10) &&
      (leftBorder+15<x+w && rightBorder-15>x)) {
      velocityY=0;
      posY = y-rollModeFactor;
      jumpStatus = MAX_JUMP_STATUS;
    }
    //Make him fall until he hits something/bottom of screen
    else { 
      velocityY +=.000001;
    }
    //If top of body hits bottom of rectangle
    if ((upperBorder<y+h && posY <y+h+30 && posY> y+h+20) && 
      (leftBorder<x+w && rightBorder>x)) {
      velocityY =abs(velocityY) *.5;
    }

    //If left side of body hits right side of rectange
    if ((upperBorder<y+h && lowerBorder>y) && 
      (leftBorder<x+w && posX<x+w+30 && posX>x+w+21)) {
      velocityX=0;
      posX = x+w+30;
    }

    //If right side of body hits left side of rectangle
    else if ((upperBorder<y+h && lowerBorder>y) && 
      (rightBorder>x && posX>x-30 && posX<x-21)) {
      velocityX=0;
      posX = x-30;
    }
  }
}

