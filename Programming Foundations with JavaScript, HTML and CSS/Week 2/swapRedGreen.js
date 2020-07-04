// Author: Enrique Rodrigo Ledesma Pinet | email: rodrigopinet@outlook.com
// Duke LTP Course 1 Week 2
//Program that defines and uses a function to swap the red and green values of each pixel in an image. 

//Function definition
function swapRedGreen(pixel){
    var tempRed = pixel.getRed();
    var tempGreen = pixel.getGreen();
    pixel.setRed(tempGreen);
    pixel.setGreen(tempRed);
    return pixel;
}

//Open image
var img = new SimpleImage("drewRobert.png");
//iterate through all pixels
for(var pixel of img.values()){
    img.setPixel(pixel.getX(), pixel.getY(), swapRedGreen(pixel));
}
//Show image
print(img);
