function doChange(){
    let choice = confirm("Press a button");
    let message;
    if (choice){
        message = 'You pressed OK!';
    }
    else{
        message = 'Are you sure you want to cancel?!';
    }
    console.log(message);   
}