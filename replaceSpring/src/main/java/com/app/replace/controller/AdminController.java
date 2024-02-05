package com.app.replace.controller;

import com.app.replace.dao.MemberDAO;
import com.app.replace.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.*;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminController {
    private final MemberDAO memberDAO;

    @GetMapping("login")
    public String login(){
        log.info("{}......................","entered");
        return "login";
    }
    @GetMapping("joinPage")
    public String join(){
        return "join";
    }

    @GetMapping("memberList")
    public String list(Model model){
        List<MemberVO> memberVOList = memberDAO.selectAll();

        memberVOList.forEach((data) -> {
            String birthday = data.getMemberBirthday();
            Calendar startCalendar = new GregorianCalendar(Integer.parseInt(birthday.split("-")[0]), Integer.parseInt(birthday.split("-")[1]),Integer.parseInt(birthday.split("-")[2]));
            Date startDT = startCalendar.getTime();

            LocalDate now = LocalDate.now();

            Calendar endCalendar = new GregorianCalendar(now.getYear(),now.getMonthValue(), now.getDayOfMonth());
            Date endDT = endCalendar.getTime();

            long differenceInMillis = endDT.getTime() - startDT.getTime();

            long years = (differenceInMillis / (365 * 24 * 60 * 60 * 1000L));

            data.setMemberAge(""+years);

            data.setMemberEnrollDate(data.getMemberEnrollDate().split(" ")[0]);

        });

        model.addAttribute("list", memberVOList);

        log.info("result member info : {}......", memberVOList);
        return "memberList";
    }
    @GetMapping("enroll")
    public RedirectView update(@RequestParam Map<String,Object> map){

        log.info("{}....................", (String)map.toString());

        MemberVO memberVO = new MemberVO();

        memberVO.setMemberName((String)map.get("name"));
        memberVO.setMemberGender((String)map.get("enroll-gender-check"));
        memberVO.setMemberPassword("");
        memberVO.setMemberPhone((String)map.get("phone"));
        memberVO.setMemberBirthday((String)map.get("birthday"));
        memberVO.setMemberZipcode((String)map.get("zipcode"));
        memberVO.setMemberAddress((String)map.get("address"));
        memberVO.setMemberAddressDetail((String)map.get("address-detail"));
        memberVO.setMemberEnrollType((String)map.get("type"));
        memberVO.setMemberVisitPath((String)map.get("visit-path"));
        memberVO.setMemberSelfAgreement((String)map.get("enroll-self-workout-check"));
        memberVO.setMemberSmsAgreement(map.get("sms") == null ? "off" : "on");
        memberVO.setMemberTmAgreement(map.get("tm") == null ? "off" : "on");
        memberVO.setMemberGoal((String)map.get("goal"));
        memberVO.setMemberEmail((String)map.get("email"));
        memberVO.setMemberWorkoutHour((String)map.get("workout-hour"));
        memberVO.setMemberInterest((String)map.get("interest"));
        memberVO.setMemberMemo((String)map.get("memo"));

        memberDAO.insert(memberVO);

        return new RedirectView( "/admin/memberList");
    }

    @GetMapping("lockerManagement")
    public String lockerManagement(){
        return "lockerManagement";
    }
    @GetMapping("dailyScheduleManagement")//일별 스케줄 관리
    public String scheduleManagement(){
        return "dailyScheduleManagement";
    }
    @GetMapping("memberDetail")
    public String detail(){
        return "memberDetail";
    }

    @GetMapping("sidebar")
    public String test(){
        return "sidebar";
    }

    @GetMapping("strategyNote")//전략 노트
    public String StrategyNote(){
        return "strategyNote";
    }

    @GetMapping("trainerScheduleManagement")//강사별 스케줄 관리
    public String trainerScheduleManagement(){
        return "trainerScheduleManagement";
    }


    @GetMapping("otReport")//ot보고서
    public String otReport(){
        return "otReport";
    }

    @GetMapping("ptReport")//pt보고서
    public String ptReport(){
        return "ptReport";
    }

    @GetMapping("mySalary")//나의 급여
    public String mySalary(){
        return "mySalary";
    }
    @GetMapping("salaryClose")//급여 마감
    public String salaryClose(){
        return "salaryClose";
    }
    @GetMapping("salaryManagement")//급여관리
    public String salaryManagement(){
        return "salaryManagement";
    }
    @GetMapping("salaryPolicyManagement")//급여정책관리
    public String salaryPolicyManagement(){
        return "salaryPolicyManagement";
    }
    @GetMapping("salaryResult")//급여실적
    public String salaryResult(){
        return "salaryResult";
    }
    @GetMapping("incomeResult")//손익산출자료
    public String incomeResult(){
        return "incomeResult";
    }
    @GetMapping("staffManagement")//직원관리
    public String staffManagement(){
        return "staffManagement";
    }
    @GetMapping("salesStatistics")
    public String salesStatistics(){
        return "salesStatistics";
    }
    @GetMapping("memberStatistics")
    public String memberStatistics(){
        return "memberStatistics";
    }
    @GetMapping("ptAttendanceStatistics")
    public String ptAttendanceStatistics(){
        return "ptAttendanceStatistics";
    }
    @GetMapping("visitHistoryPage")
    public String visitHistoryPage(){
        return "visitHistory";
    }
    @GetMapping("visitStatistics")
    public String visitStatistics(){
        return "visitStatistics";
    }





    @GetMapping("documentEnrollModal")
    public String documentEnrollModal(){
        return "modal/documentEnrollModal";
    }
    @GetMapping("lockerManagementModal")
    public String lockerManagementModal(){
        return "modal/lockerManagementModal";
    }
    @GetMapping("memberEnrollModal")
    public String memberEnrollModal(){
        return "modal/memberEnrollModal";
    }


    @GetMapping("purchaseHistory")
    public String purchaseHistory(){
        return "loadPage/purchaseHistory";
    }
    @GetMapping("visitHistory")
    public String visitHistory(){
        return "loadPage/visitHistory";
    }
    @GetMapping("otHistory")
    public String otHistory(){
        return "loadPage/otHistory";
    }
    @GetMapping("ptHistory")
    public String ptHistory(){
        return "loadPage/ptHistory";
    }
    @GetMapping("documentHistory")
    public String documentHistory(){
        return "loadPage/documentHistory";
    }
    @GetMapping("recommendHistory")
    public String recommendHistory(){
        return "loadPage/recommendHistory";
    }
    @GetMapping("lockerHistory")
    public String lockerHistory(){
        return "loadPage/lockerHistory";
    }
    @GetMapping("updateHistory")
    public String updateHistory(){
        return "loadPage/updateHistory";
    }
    @GetMapping("wearableHistory")
    public String wearableHistory(){
        return  "loadPage/wearableHistory";
    }

}
