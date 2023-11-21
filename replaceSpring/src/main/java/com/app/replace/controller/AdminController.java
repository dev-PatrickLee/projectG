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

        log.info("{}......", memberVOList);
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

    @GetMapping("memberDetail")
    public String detail(){
        return "memberDetail";
    }

    @GetMapping("sidebar")
    public String test(){
        return "sidebar";
    }

    @GetMapping("strategyNote")
    public String StrategyNote(){
        return "strategyNote";
    }

    @GetMapping("purchaseHistory")
    public String purchaseHistory(){
        return "purchaseHistory";
    }
    @GetMapping("visitHistory")
    public String visitHistory(){
        return "visitHistory";
    }
    @GetMapping("otHistory")
    public String otHistory(){
        return "otHistory";
    }
    @GetMapping("ptHistory")
    public String ptHistory(){
        return "ptHistory";
    }
    @GetMapping("documentHistory")
    public String documentHistory(){
        return "documentHistory";
    }
    @GetMapping("recommendHistory")
    public String recommendHistory(){
        return "recommendHistory";
    }
    @GetMapping("lockerHistory")
    public String lockerHistory(){
        return "lockerHistory";
    }
    @GetMapping("updateHistory")
    public String updateHistory(){
        return "updateHistory";
    }
    @GetMapping("wearableHistory")
    public String wearableHistory(){
        return  "wearableHistory";
    }
}
