function buttonClicked(){
  var choice = confirm('Hey there!');
  if (choice){
    var message = 'You pressed OK!';
  }
  else{
    var message = 'Are you sure you want to cancel?';
  }
  alert(message);
}
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

function changeText(){
  
}