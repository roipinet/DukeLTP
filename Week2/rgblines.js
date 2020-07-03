// Author: Enrique Rodrigo Ledesma Pinet | email: rodrigopinet@outlook.com
// Duke LTP Course 1 Week 2
//Program that opens an image and modifies it to have tree vertical lines in it (RGB). 

//Open the image
var img = new SimpleImage("hilton.jpg");
//Iterate through the pixels
for(var pixel of img.values()) {
    //Check if the pixel is on the first vertical third
    if(pixel.getX() < img.getWidth()/3){
        pixel.setRed(255);
    }
    //Check if the pixel is on the second vertical third 
    else if (pixel.getX() > img.getWidth()/3 && pixel.getX() < img.getWidth()/3*2){
        pixel.setGreen(255);
    }
    //Else the pixel is on the final vertical third. 
    else{
        pixel.setBlue(255);
    }
}
//Show the image.
print(img);
