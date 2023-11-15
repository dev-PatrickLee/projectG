const $loginButton = $("#login-button");
const $joinButton = $("#join-button");
const $email = $("#email");
const $password = $("#password");

let emailExptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
let passwordExptext = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/;



$joinButton.click(function (){
    // button clicked
    console.log("login.....");
    console.log("ID : " + $email.val());
    console.log("PW : " + $password.val());
    checkEmail();
    checkPassword();
});


function gotoFindPassword(){
    console.log("go to find password............");
}

// $email.on("propertychange change keyup paste input",checkIt());
function checkEmail(){
    let email = $email.val();


    if(emailExptext.test(email)==false){
        //이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우

        console.log(email + " is wrong eamil type");
        $email.css({
            "background-color" : "red"
        });
        $email.focus();
    }
    else{
        console.log(email + " is good email");
    }
}
function checkPassword(){
    let password = $password.val();

    if(passwordExptext.test(password)==false){
        //이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우

        console.log(password + " is wrong password type");
        $password.css({
            "background-color" : "red"
        });
        $email.focus();
    }
    else{
        $email.css({
           "background-color" : "green"
        });
        console.log(password + " is good password");
    }
}
function join(){
    console.log("join");
}
