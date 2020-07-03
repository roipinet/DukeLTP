// Author: Enrique Rodrigo Ledesma Pinet | email: rodrigopinet@outlook.com
// Duke LTP Course 1 Week 2
//Program that defines swaps blue for yellow pixels in an image, 

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
