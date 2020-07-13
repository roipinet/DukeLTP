// Author: Enrique Rodrigo Ledesma Pinet | email: rodrigopinet@outlook.com
// Duke LTP Course 1 Honors Content
// Steganography Exercise

function clearbits(colorval){
    // This function clears the least significant bits of an 8 bit binary number. 
    var cleared = Math.floor(colorval/16)*16;
    return cleared;
}

function chop2hide(image){
    // Traverse the image
    for (var pixel of image.values()){
        // Clear the low bits of each color.
        pixel.setRed(clearbits(pixel.getRed()));
        pixel.setGreen(clearbits(pixel.getGreen()));
        pixel.setBlue(clearbits(pixel.getBlue()));
    }
    return image;
}

function shift(image){
    // Traverse the image
    for(var pixel of image.values()){
        // shift each color MSBs to the LSBs
        pixel.setRed(pixel.getRed()/16);
        pixel.setGreen(pixel.getGreen()/16);
        pixel.setBlue(pixel.getBlue()/16);
    }
    return image;
}

function combine(show,hide){
    // Create output image
    var output = new SimpleImage(show.getWidth(), show.getHeight());
    // Traverse the image
    for(var pixel of output.values()){
        var x = pixel.getX();
        var y = pixel.getY();
        // Get the pixels to show and hide. 
        var showPixel = show.getPixel(x,y);
        var hidePixel = hide.getPixel(x,y);
        // Add the two values of each color of both pixels. 
        pixel.setRed(showPixel.getRed() + hidePixel.getRed());
        pixel.setGreen(showPixel.getGreen() + hidePixel.getGreen());
        pixel.setBlue(showPixel.getBlue() + hidePixel.getBlue());
    }
    return output;
}


var start = new SimpleImage("usain.jpg");
var hide = new SimpleImage("skyline.jpg");

start = chop2hide(start);
hide = shift(hide);
var ans = combine(start,hide);
print(ans)

