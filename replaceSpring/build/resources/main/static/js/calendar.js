const $calendar = $("#calendar");
const $dateOfToday = $("#dateOfToday");

const days = "일월화수목금토";

let sdate = new Date();
let todayDate = new Date();
$dateOfToday.text(todayDate.getFullYear() + "/" + (todayDate.getMonth()+1) + "/" + todayDate.getDate() + "(" + (days[todayDate.getDay()])+ ")");
$calendar.children().eq(1).children().eq(0).css("background-color","#f99");
$calendar.children().eq(1).children().eq(6).css("background-color","#99f");
console.log(todayDate);

window.onload = setCalendar()
function setCalendar(){

    var edate = new Date(sdate.getFullYear(),sdate.getMonth()+1,1);
    sdate.setDate(1);

    $calendar.children().eq(0).children().eq(1).text(sdate.getFullYear() + "년 "+(sdate.getMonth()+1) + "월");
    // 월 = 0, 화 = 1, 수 = 2, 목 = 3, 금 = 4, 토 = 5, 일 = 6
    console.log("첫요일 : " + days[sdate.getDay()]);
    console.log("첫일 : " + sdate);

    let y = sdate.getDay();



    for (let x = 2; x < 8; x++){
        for (; y<7; y++){
            if (sdate <=edate){
                $calendar.children().eq(x).children().eq(y).text(sdate.getDate());
                if (sdate.getFullYear() == todayDate.getFullYear() && sdate.getMonth() == todayDate.getMonth() && sdate.getDate() == todayDate.getDate()){
                    $calendar.children().eq(x).children().eq(y).css("background-color","#999");
                }
                else{
                    if (y==0){
                        $calendar.children().eq(x).children().eq(y).css("background-color","#fbb");
                    }
                    else if (y==6){
                        $calendar.children().eq(x).children().eq(y).css("background-color","#bbf");
                    }
                    else{
                        $calendar.children().eq(x).children().eq(y).css("background-color","#fff");
                    }
                }


                sdate.setDate(sdate.getDate()+1);
            }


        }
        y = 0;
    }
}
function clearCalendar(){
    for (let x = 2; x < 8; x++){
        for (let y = 0; y<7; y++){

            $calendar.children().eq(x).children().eq(y).text("");

        }

    }
}
function premonth(){
    sdate.setMonth(sdate.getMonth()-2);
    clearCalendar()
    setCalendar();
}
function nextmonth(){
    sdate.setMonth(sdate.getMonth());
    clearCalendar()

    setCalendar();
}
