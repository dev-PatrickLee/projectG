function clickOption(data){
    // $(".side-list").css("background-color","#4e4e4e");
    $(".sub-list").slideUp(150);
    // $(data).parent().css("background-color", "#808080");
    $(data).parent().find(".sub-list").slideDown(150);
    console.log("success");
}
$(".container").click(function (){
   $(".sub-list").slideUp(150);
});


