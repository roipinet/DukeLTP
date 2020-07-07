function doSquare(){
  //Get canvas
  var myCanvas = document.getElementById("canvas1");
//   Get context
  var context = myCanvas.getContext("2d");
//   Wipe canvas
  context.clearRect(0,0,myCanvas.width,myCanvas.height);
//   Draw rectangle
context.fillStyle = "red";
  var size = document.getElementById("squareSize").value;
  context.fillRect(10,10,size,size);
}