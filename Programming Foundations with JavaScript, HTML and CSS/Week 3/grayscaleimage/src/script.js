var uploadedImage;
var grayImage;
function upload(){
//  Get the canvas
  var myCanvas = document.getElementById("canvas1");
//   Get the uploaded image
  uploadedImage = new SimpleImage(document.getElementById("fileUpload"));
  grayImage = uploadedImage;
//   Draw the image
  uploadedImage.drawTo(myCanvas);
}

function makeGray(){
//   Iterate through the image
  for(var pixel of grayImage.values()){
//     get the average
    var average = (pixel.getRed() + pixel.getGreen() + pixel.getBlue())/3;
//     set the new value
    pixel.setRed(average);
    pixel.setGreen(average);
    pixel.setBlue(average);
  }
//   Draw the image
  grayImage.drawTo(document.getElementById("canvas2"));
}