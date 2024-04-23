$(".side-bar").load("sidebar");

function clickOption(data){
    // $(".side-list").css("background-color","#4e4e4e");
    if ($(data).parent().find(".sub-list").css('display') === 'block') {
        $(".sub-list").slideUp(150);
    }else{
        $(".sub-list").slideUp(150);
        $(data).parent().find(".sub-list").slideDown(150);
        console.log("success");
    }

    // $(data).parent().css("background-color", "#808080");

}
$(".container").click(function (){
   $(".sub-list").slideUp(150);
});

function modalOn(){
    $(".modal").css("display", "flex");
    $(".modal").css("height", "");
    $("body").addClass("stopScrolling");
}
function modalOff(){
    $(".modal").fadeOut();
    console.log("cancel button click");
    $("body").removeClass("stopScrolling");
}


