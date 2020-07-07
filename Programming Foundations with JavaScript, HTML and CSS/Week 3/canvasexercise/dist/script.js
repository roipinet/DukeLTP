function changeColor(){
  //Get divs
  var divCanvas = document.getElementById("canvas");
  var divButtons = document.getElementById("buttons");
  var divInstructions = document.getElementById("instructions");
  //Change classes
  divCanvas.className = "middleredback";
  divButtons.className = "rustback";
  divInstructions.className = "metallicseaweedback";
}

function doRed(){
  //Get left canvas
  var leftCanvas = document.getElementById("canvas");
  //Change the background to red
  leftCanvas.style.backgroundColor = "red";
  //Get context
  var leftCanvasContext = leftCanvas.getContext("2d");
  //Draw rectangles
  leftCanvasContext.fillStyle = "Orange";
  leftCanvasContext.fillRect(15,15,100,100);
  //Draw text
  leftCanvasContext.fillStyle = "black";
  leftCanvasContext.font = "12px Arial";
  leftCanvasContext.fillText("This is Red", 15,100);
}

function doBlue(){
    //Get left canvas
  var leftCanvas = document.getElementById("canvas");
  //Change the background to blue
  leftCanvas.style.backgroundColor = "blue";
    //Get context
  var leftCanvasContext = leftCanvas.getContext("2d");
  //Draw rectangles
  leftCanvasContext.fillStyle = "purple";
  leftCanvasContext.fillRect(15,15,100,100);
    //Draw text
  leftCanvasContext.fillStyle = "black";
  leftCanvasContext.font = "12px Arial";
  leftCanvasContext.fillText("This is Blue", 15,100);
}

function doClear(){
  //Get Canvas
  var leftCanvas = document.getElementById("canvas");
  //Get context
  var leftCanvasContext = leftCanvas.getContext("2d");
  //Clear context
  leftCanvasContext.clearRect(0,0,leftCanvas.width,leftCanvas.height);
}