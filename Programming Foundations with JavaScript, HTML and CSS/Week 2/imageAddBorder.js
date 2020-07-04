// Author: Enrique Rodrigo Ledesma Pinet | Email: rodrigopinet@outlook.com
// Duke LTP Course 1 Week 2
// Description: black border (padding) generation.

//Black pixel function definition
function setBlack(pixel){
    pixel.setRed(0);
    pixel.setGreen(0);
    pixel.setBlue(0);
    return pixel;
}
//Border adding function definition
function addBorder(image, borderSize){
    //Iterate through the pixels
    for(var pixel of image.values()){
        if(pixel.getX() < borderSize || pixel.getX() > image.getWidth()-borderSize){
            image.setPixel(pixel.getX(), pixel.getY(), setBlack(pixel));
        }
        else if(pixel.getY() < borderSize || pixel.getY() > image.getHeight() - borderSize){
            image.setPixel(pixel.getX(), pixel.getY(), setBlack(pixel));
        }
    }
}
//Open image
var img = new SimpleImage("smallPanda.png");
//Apply border
addBorder(img, 10);
print (img);
