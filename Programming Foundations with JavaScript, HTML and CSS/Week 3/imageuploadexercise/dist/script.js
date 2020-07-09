function upload(){
// //   Get the value of the text input
//   var text = document.getElementById("textInput").value;
//   alert(text);
  
//  Get the canvas
  var myCanvas = document.getElementById("canvas1");
//   Get the uploaded image
  var myImage = new SimpleImage(document.getElementById("fileUpload"));
//   Draw the image
  myImage.drawTo(myCanvas);
}