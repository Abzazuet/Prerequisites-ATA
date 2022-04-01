function doChange() {
    let choice = confirm("Press a button");
    let message;
    if (choice) {
        message = 'You pressed OK!';
        changeColor();
    }
    else {
        message = 'Are you sure you want to cancel?!';
    }
    console.log(message);
}
function changeColor (){
    let dd1 = document.getElementById("firstHelloContainer");
    let dd2 = document.getElementById("secondHelloContainer");
    let button = document.getElementById("changingButton");
    dd1.className = "blueback";
    dd2.className = "yellowback";
    dd1.innerHTML = "Heeeeeello";
    dd2.innerHTML = "We just changed";
    button.value = "nothing";
    button.innerHTML = "Nothing will happen";
    console.log(button.value);
}