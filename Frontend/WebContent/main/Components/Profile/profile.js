var updateButton = document.getElementById("update-butt");
var emArrow = document.getElementById("em-arrow");
var emArrow2 = document.getElementById("em-arrow2");
var signOutButton = document.getElementById("sign-out-butt");

function showArrow(e) {
    emArrow.style.visibility = "visible"; 
}

function showArrow2(e) {
    emArrow2.style.visibility = "visible"; 
}

updateButton.addEventListener("mouseover", showArrow);
signOutButton.addEventListener("mouseover", showArrow2);

function hideArrow(e) {
    emArrow.style.visibility = "hidden"; 
}

function hideArrow2(e) {
    emArrow2.style.visibility = "hidden"; 
}

updateButton.addEventListener("mouseout", hideArrow);
signOutButton.addEventListener("mouseout", hideArrow2);