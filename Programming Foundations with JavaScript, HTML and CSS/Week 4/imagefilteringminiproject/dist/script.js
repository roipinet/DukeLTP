var uploadedImage = null;
var canvas = document.getElementById("myCanvas");

function imageLoaded(){
  if(uploadedImage == null || ! uploadedImage.complete()){
    return false;
  }
  else{
    return true;
  }
}

function upload(){
//   Get the uploaded file
  uploadedImage = new SimpleImage(document.getElementById("imageInput"));
//   Display the image
  uploadedImage.drawTo(canvas);  
}
function doNegative(){
// check that the image is already uploaded.
  if(! imageLoaded()){
    alert('No image Uploaded')
}
  else{
//     create an output image
    var output = new SimpleImage(uploadedImage.getWidth(), uploadedImage.getHeight());
//     Iterate through the input image.
    for(var pixel of uploadedImage.values()){
//      Check change the value of the pixel to its compliment
      output.getPixel(pixel.getX(), pixel.getY()).setRed(255-pixel.getRed());
      output.getPixel(pixel.getX(), pixel.getY()).setGreen(255-pixel.getGreen());
      output.getPixel(pixel.getX(), pixel.getY()).setBlue(255-pixel.getBlue());
    }
//     draw the output image
    output.drawTo(canvas);
  }
}

function doGrayscale(){
    if(! imageLoaded()){
    alert('No image Uploaded')
}
  else{
//     Create output image
    var output = new SimpleImage(uploadedImage.getWidth(), uploadedImage.getHeight());
//     Iterate throught the uploaded image\
    for(var pixel of uploadedImage.values()){
//       get average
      var average = (pixel.getRed() + pixel.getGreen() + pixel.getBlue())/3;
//       set new value
      output.getPixel(pixel.getX(), pixel.getY()).setRed(average);
      output.getPixel(pixel.getX(), pixel.getY()).setGreen(average);
      output.getPixel(pixel.getX(), pixel.getY()).setBlue(average);
    }
//     draw the output image
    output.drawTo(canvas);
  }
  
}

function doBinary(){
      if(! imageLoaded()){
    alert('No image Uploaded')
}
  else{
//     Create output image
    var output = new SimpleImage(uploadedImage.getWidth(), uploadedImage.getHeight());
//     Get Grayscale
      for(var pixel of uploadedImage.values()){
//       get average
      var average = (pixel.getRed() + pixel.getGreen() + pixel.getBlue())/3;
//       set new value
      if(average >= 127){
      output.getPixel(pixel.getX(), pixel.getY()).setRed(255);
      output.getPixel(pixel.getX(), pixel.getY()).setGreen(255);
      output.getPixel(pixel.getX(), pixel.getY()).setBlue(255);
      }
      else{
      output.getPixel(pixel.getX(), pixel.getY()).setRed(0);
      output.getPixel(pixel.getX(), pixel.getY()).setGreen(0);
      output.getPixel(pixel.getX(), pixel.getY()).setBlue(0);
      }
    }
//     Draw the image
    output.drawTo(canvas)
  }
}

function doReset(){
    if(! imageLoaded()){
    alert('No image Uploaded')
}
  else{
//     draw the original image
    uploadedImage.drawTo(canvas);
  }
}