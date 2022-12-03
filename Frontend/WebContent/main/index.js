var signButton = document.getElementById("sign-butt-home");
var emArrow = document.getElementById("em-arrow");
var emArrow2 = document.getElementById("em-arrow2");
var logButton = document.getElementById("log-butt-home");

function showArrow(e) {
    emArrow.style.visibility = "visible"; 
}

function showArrow2(e) {
    emArrow2.style.visibility = "visible"; 
}

signButton.addEventListener("mouseover", showArrow);
logButton.addEventListener("mouseover", showArrow2);

function hideArrow(e) {
    emArrow.style.visibility = "hidden"; 
}

function hideArrow2(e) {
    emArrow2.style.visibility = "hidden"; 
}

signButton.addEventListener("mouseout", hideArrow);
logButton.addEventListener("mouseout", hideArrow2);

