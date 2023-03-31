let form = document.getElementById('form');
form.onsubmit = () =>{
    let username = document.getElementById('username');
    let age = document.getElementById('age');
    let email = document.getElementById('email');
    let address = document.getElementById('address');
    let user_password = document.getElementById('user_password');

    if(username.trim() === ''){
        alert('Username cannot be empty...');
        return false;
    }

    if(age.trim() === ''){
        alert('Age cannot be empty...');
        return false;
    }

    if(email.trim() === ''){
        alert('Email cannot be empty...');
        return false;
    }

    if(address.trim() === ''){
        alert('Address cannot be empty...');
        return false;
    }

    if(user_password.trim() === ''){
        alert('Username cannot be empty...');
        return false;
    }

    if(user_password.length < 6){
        alert('Username length must > 6');
        return false;
    }
}



$("#username").blur(function () {
    let username = $("#username").val();

    $.ajax("http://localhost:8080/check/username_exist",{
        type:"POST",
        data:{username:username},
        success:function(data){
            if(data===false){
                $("#username_callback").innerHTML("<i>Username is existed, so you need change a new one!</i>");

            }else if(data===true){
                $("#username_callback").innerHTML("Such a cool name!");

            }
        }
    });

});
