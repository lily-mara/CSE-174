/*
- Nate Mara
- This program creates a rendition of my Facebook Timeline page
- 2013-08-27 
- CSE 174
*/

void setup()
{

  //Sets style options and window size
  noStroke();
  size(1280, 720);


  int winWidth = 1280;
  background(#e9eaed);
  //creates variables for page
  String name = "Nate Mara";


  //creates top blue bar
  fill(#4c66a4);
  rect(0, 0, winWidth, 39);
  stroke(#3c5998);
  line(0,39,winWidth,39);
  noStroke();


  //creates search bar and white box
  fill(255);
  rect(winWidth/4, 7, winWidth/2 - 60, 25);
  rect(winWidth/4 - 35, 7, 25 , 25);


  //creates "f" in white box
  fill(#4c66a4);
  textSize(32);
  text("f", winWidth/4 - 25, 35);


  //creates name in search bar
  fill(0);
  textSize(17);
  text(name, winWidth/4 + 4, 27);

  //loads images
  PImage search = loadImage("search.png");
  PImage friend = loadImage("friends.png");
  PImage message = loadImage("message.png");
  PImage not = loadImage("notification.png");
  PImage cover = loadImage("cover.jpg");
  PImage pPic = loadImage("pPic.jpg");
  PImage pPicTop = loadImage("pPicTop.jpg");

  //adds images to the top search bar
  image(search, winWidth/2+233, 7, 25, 25);
  image(friend, winWidth/2+375,9);
  image(message, winWidth/2+405,6);
  fill(#374f8a);
  ellipse(winWidth/2+450,18,20,20);


  //creates box at bottom of cover photo containing area chosing information

  //--actual box
  fill(255);
  rect(270,340,858,55);

  //--deviding lines (in order from left to right)
  stroke(#d3d6db);
  line(270, 340, 270, 394);
  line(480, 352, 480, 394);
  line(558, 352, 558, 394);
  line(618, 352, 618, 394);
  line(708, 352, 708, 394);
  line(803, 352, 803, 394);
  line(864, 352, 864, 394);
  line(1128, 340, 1128, 394);

  //--line at bottom of box
  line(270, 394, 1128, 394);

  //--labels
  fill(#37404e);
  textSize(15);
  text("Timeline", 490, 380);
  fill(#89919c);
  textSize(11);
  text("478", 680, 380);
  text("530", 775, 380);
  fill(#3b59b1);
  text("About", 568, 380);
  text("Photos", 628, 380);
  text("Friends", 718, 380);
  text("More", 813, 380);

  //--Triangle to the right of "more" label
  noStroke();
  int tCent = 850;
  triangle(tCent - 4, 373, tCent + 4, 373, tCent, 380);

  //--indication triangle at bottom of "timeline" section
  stroke(#d3d6db);
  fill(#e9eaed);
  tCent = 518;
  triangle(tCent - 6, 394, tCent + 6, 394, tCent, 387);
  stroke(#e9eaed);
  line(tCent-5,394,tCent+5,394);


  //creates cover picture area
  image(cover, 270,40);
  stroke(#b2b2b2);
  fill(255);
  rect(290,205,170,170);
  noStroke();
  image(pPic ,295,210);


  //creates name information area
  textSize(20);
  text(name, 478, 335);

  //creates update info box
  fill(#f6f7f8);
  stroke(#d3d6db);
  rect(270,413,315,42);
  fill(#6a7480);
  textSize(12);
  text("Update Info", 284, 440);
  fill(#89aad5);
  ellipse(355, 435, 2, 2);
  fill(#89919c);
  text("2", 361, 440);
  int pX1 = 555;
  int pX2 = 560;
  int pX3 = 565;
  int pY1 = 433;
  int pY2 = 438;
  int pY3 = pY1;
  line(pX1, pY1, pX2-1, pY2-1);
  line(pX1, pY1-1, pX2, pY2-1);
  line(pX1+1, pY1-1, pX2, pY2-2);
  line(pX2, pY2, pX3, pY3);
  line(pX2, pY2-1, pX3, pY3-1);
  line(pX2-1, pY2-1, pX3-1, pY3-1);
  point(pX2, pY2);

  //Creates status update box
  stroke(#d3d6db);
  fill(#f6f7f8);
  rect(602, 413, 526, 41);
  fill(255);
  rect(602, 454, 526, 50);
  fill(#37404e);
  text("Status", 635, 439);
  fill(#3b5998);
  text("Photo", 710, 439);
  text("Place", 780, 439);
  text("Life Event", 850, 439);
  fill(#777777);
  text("What's on your mind?", 619, 483);

  //triangle under status box
  stroke(#d3d6db);
  fill(255 );
  tCent = 651;
  int tHeight = 454;
  triangle(tCent - 6, tHeight, tCent + 6, tHeight, tCent, tHeight-6);
  stroke(255 );
  line(tCent-5, tHeight, tCent+5, tHeight);


  //creates profile pic update box
  stroke(#d3d6db);
  fill(255);
  rect(602, 519, 526, 202);
  image(pPic , 616, 531, 40, 40);
  fill(#3b59b1);
  text("Nate Mara", 664, 548);
  text("profile picture", 802, 548);
  fill(#89919c);
  text("changed his", 728, 548);
  point(885, 547);
  point(886, 547);
  point(886, 548);
  point(885, 548);
  textSize(10);
  text("22 hours ago", 664, 565);
  image(pPicTop, 612, 582);

  //creates "about/info" box
  fill(#f6f7f8);
  rect(270, 470, 315, 42);
  fill(255);
  rect(270, 512, 315, 160);
  rect(270, 512, 315, 160);
  fill(#6a7480);
  textSize(12);
  text("About", 284, 497);
  text("Former Intern at", 300, 530);
  text("Studies Computer Science at", 300, 572);
  text("Lives in", 300, 616);
  text("From", 300, 655);
  fill(#3b5998);
  text("DTE Energy", 398,530);
  text("Miami University", 467, 572);
  text("Oxford, Ohio", 345, 616);
  text("Commerce, Michigan", 333, 655);
  line(285, 553, 570, 553);
  line(285, 593, 570, 593);
  line(285, 630, 570, 630);
  fill(#adb3bc);
  text("Past: Dolphins Plus Inc.", 300, 546);
  text("Past: Walled Lake Central", 300, 587);


  //creates whitespace at bottom
  fill(#f6f7f8);
  rect(270, 687, 315, 34);

  /*
  //debugging lines for coordinate locations
  stroke(0);
  line(mouseX, 0,mouseX,height);
  line(0,mouseY,width,mouseY);
  fill(0);
  text("x: " + mouseX, mouseX + 20, mouseY + 20);
  text("y: " + mouseY, mouseX + 20, mouseY + 40);
  */

}

