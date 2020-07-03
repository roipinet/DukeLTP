// Author: Enrique Rodrigo Ledesma Pinet | email: rodrigopinet@outlook.com
// Duke LTP Course 1 Week 2
// Greenscreen algorithm

//Function definition
function swapBlueYellow(pixel){
    pixel.setRed(255);
    pixel.setGreen(255);
    pixel.setBlue(0);
    return pixel;
}

//Open image
var img = new SimpleImage("duke_blue_devil.png");
//iterate through all pixels
for(var pixel of img.values()){
    if(pixel.getRed() == 0 && pixel.getBlue() > 200 && pixel.getGreen() > 40 && pixel.getGreen() < 60){
    img.setPixel(pixel.getX(), pixel.getY(), swapBlueYellow(pixel));
    }
}
//Show image
print(img);

// Foreground image:
var fgImage = new SimpleImage("drewRobert.png");
// Background image:
var bgImage = new SimpleImage("dinos.png");
//Output image:
var output = new SimpleImage(fgImage.getWidth(), fgImage.getHeight());

//Go through all pixels in the foreground
for (var pixel of fgImage.values()){
    // Check if the current pixel goes above the threshold
    if(pixel.getGreen() > pixel.getBlue() + pixel.getRed()){
        //get the equivalent pixel in the background
        var bgX = pixel.getX();
        var bgY = pixel.getY();
        var bgPixel = bgImage.getPixel(bgX,bgY);
        //Paste this pixel in the output image
        output.setPixel(bgX, bgY, bgPixel);
    }
    //IF it does not go above the threshold, paste the foreground verision
    else{
        output.setPixel(pixel.getX(),pixel.getY(), pixel);
    }
