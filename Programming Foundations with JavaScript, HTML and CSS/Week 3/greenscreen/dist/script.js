var bgImage = null;
var fgImage = null;
var output = null;

function loadForegroundImage(){
//   Get the uploaded image
  fgImage = new SimpleImage(document.getElementById("fgInput"));
//   Draw the image in the canvas
  fgImage.drawTo(document.getElementById("fgCanvas"));
}
function loadBackgroundImage(){
  //   Get the uploaded image
  bgImage = new SimpleImage(document.getElementById("bgInput"));
//   Draw the image in the canvas
  bgImage.drawTo(document.getElementById("bgCanvas"));
}
function doGreenScreen(){
//   Check if the images are loaded
  if(bgImage == null || ! bgImage.complete()){
    alert('The background image is not loaded');
    return;
  }
  else if(fgImage == null || ! fgImage.complete()){
    alert('The foreground image is not loaded');
    return;
  }
  else{
//     Do green screen algorithm
      output = new SimpleImage(fgImage.getWidth(), fgImage.getHeight());
    for(var pixel of fgImage.values()){
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
    }
//     Draw the image in the output canvas
    output.drawTo(document.getElementById("compCanvas"));
  }
  
}
function clearCanvas(){
//   Get the three canvas
  var bgCanvas = document.getElementById("bgCanvas");
  var fgCanvas = document.getElementById("fgCanvas");
  var compCanvas = document.getElementById("compCanvas");
//   Get the contexts
  var bgContext = bgCanvas.getContext("2d");
  var fgContext = fgCanvas.getContext("2d");
  var compContext = compCanvas.getContext("2d");
//   Clear the contexts
  bgContext.clearRect(0, 0, bgImage.getWidth(), bgImage.getHeight());
  fgContext.clearRect(0, 0, fgImage.getWidth(), fgImage.getHeight());
  compContext.clearRect(0, 0, output.getWidth(), output.getHeight());
}