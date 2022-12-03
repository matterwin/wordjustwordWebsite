var logButton = document.getElementById("log-button");

function validate(e) {

    e.preventDefault();

    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    if (username == "")
        alert("Please enter your username")
    else if(password == "")
        alert("Please enter your password")
  }
  
logButton.addEventListener('click', validate);

