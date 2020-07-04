// Author: Enrique Rodrigo Ledesma Pinet | email: rodrigopinet@outlook.com
// Duke LTP Course 1 Week 2
// Greenscreen algorithm

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
print(output);
