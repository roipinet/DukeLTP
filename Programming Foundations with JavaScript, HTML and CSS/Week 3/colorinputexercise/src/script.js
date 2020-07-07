function doGreen(){
  //Get canvas
  var myCanvas = document.getElementById("canvas1");
  myCanvas.style.backgroundColor = "Green";
}

function doColor(){
  //Get canvas
  var myCanvas = document.getElementById("canvas1");
  //Get value
  var myColor = document.getElementById("colorPicker").value;
  //Change background
  myCanvas.style.backgroundColor = myColor;
  
}