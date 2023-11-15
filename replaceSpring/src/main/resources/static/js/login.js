const $loginButton = $("#login-button");
const $joinButton = $("#join-button");
const $email = $("#email");
const $password = $("#password");

$loginButton.click(function (){
    // button clicked
    console.log("login.....");
    console.log("ID : " + $email.val());
    console.log("PW : " + $password.val());
    checkIt();
});
$joinButton.click(function (){
   console.log("go to join page.....");
});

function gotoFindPassword(){
    console.log("go to find password............");
}

// $email.on("propertychange change keyup paste input",checkIt());
function checkIt(){
    var email = $email.val();
    var emailExptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;


    if(emailExptext.test(email)==false){
        //이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우

        console.log(email + " is wrong eamil type");
        $email.css({
           "background-color" : "red"
        });
        $email.focus();
    }
    else{
        console.log("email confirm");
    }

}
$joinButton.click(function (){
    location.href = "/member/joinPage";
});