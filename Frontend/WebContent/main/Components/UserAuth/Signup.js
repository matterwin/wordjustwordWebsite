var signButton = document.getElementById("sign-butt");

function validate(e) {

    e.preventDefault();

    var username = document.getElementById("username").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    
    var flag = 1;

    if (username == ""){
        alert("Please enter your username");
	}
    else if(email == ""){
        alert("Please enter your email");
    }
    else if(password == ""){
        alert("Please enter your password");
    }
    else
    	
  }
  
signButton.addEventListener('click', validate);

