package com.app.replace.controller;

import com.app.replace.dao.*;
import com.app.replace.dto.MemberDTO;
import com.app.replace.dto.StaffDTO;
import com.app.replace.vo.DocumentVO;
import com.app.replace.vo.MemberVO;
import com.app.replace.vo.ProductVO;
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
import java.time.ZoneId;
import java.util.*;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminController {
    private final MemberDAO memberDAO;
    private final DocumentDAO documentDAO;
    private final CustomerDAO customerDAO;
    private final StaffDAO staffDAO;
    private final ScheduleDAO scheduleDAO;
    private final ProductDAO productDAO;

    long gymId = 22;
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
        List<MemberDTO> memberVOList = memberDAO.selectAll();

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
            log.info("member : {}", data.toString());

        });

        model.addAttribute("list", memberVOList);
        model.addAttribute("memberCount", memberDAO.memberCount());

        return "memberList";
    }
    @GetMapping("enroll")
    public RedirectView enroll(@RequestParam Map<String,Object> map){

        log.info("{}....................", (String)map.toString());

        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setMemberName((String)map.get("name"));
        memberDTO.setMemberGender((String)map.get("enroll-gender-check"));
        memberDTO.setMemberPassword("");
        memberDTO.setMemberPhone((String)map.get("phone"));
        memberDTO.setMemberBirthday((String)map.get("birthday"));
        memberDTO.setMemberZipcode((String)map.get("zipcode"));
        memberDTO.setMemberAddress((String)map.get("address"));
        memberDTO.setMemberAddressDetail((String)map.get("address-detail"));
        memberDTO.setMemberEnrollType((String)map.get("type"));
        memberDTO.setMemberVisitPath((String)map.get("visit-path"));
        memberDTO.setMemberSelfAgreement((String)map.get("enroll-self-workout-check"));
        memberDTO.setMemberSmsAgreement(map.get("sms") == null ? "false" : "true");
        memberDTO.setMemberTmAgreement(map.get("tm") == null ? "false" : "true");
        memberDTO.setMemberGoal((String)map.get("goal"));
        memberDTO.setMemberEmail((String)map.get("email"));
        memberDTO.setMemberWorkoutHour((String)map.get("workout-hour"));
        memberDTO.setMemberInterest((String)map.get("interest"));
        memberDTO.setMemberMemo((String)map.get("memo"));
        memberDTO.setGymId(gymId);

        customerDAO.insert(memberDTO);
        log.info("enrolled : {}", memberDTO.toString());

        return new RedirectView( "/admin/memberList");
    }
    @GetMapping("update")
    public RedirectView update(@RequestParam Map<String,Object> map){
        log.info("update{}",map.toString());
        MemberDTO memberDTO = memberDAO.selectById(Long.parseLong((String)map.get("memberId")));
        memberDTO.setMemberName((String)map.get("name"));
        memberDTO.setMemberGender(((String)map.get("gender")).equals("M")?"남":"여");
        memberDTO.setMemberPhone((String)map.get("phone"));
        memberDTO.setMemberTmAgreement((String)map.get("tm"));
        memberDTO.setMemberSmsAgreement((String)map.get("sms"));
        memberDTO.setMemberBirthday((String)map.get("birthday"));
        memberDTO.setMemberVisitPath((String)map.get("visitPath"));
        memberDTO.setMemberSelfAgreement((String)map.get("selfActivity"));
        memberDTO.setMemberGoal((String)map.get("goal"));
        memberDTO.setMemberMemo((String)map.get("memo"));
        customerDAO.updateById(memberDTO);

        return new RedirectView( "/admin/memberDetail?id="+memberDTO.getId());
    }

    @GetMapping("lockerManagement")
    public String lockerManagement(){
        return "lockerManagement";
    }

    @GetMapping("memberDetail")
    public String detail(@RequestParam("id") String id, Model model){
        MemberDTO member = memberDAO.selectById(Long.parseLong(id));
        if(Long.parseLong(id)!=0){
            member.setMemberEnrollDate(member.getMemberEnrollDate().split(" ")[0]);
            member.setMemberBirthday(member.getMemberBirthday().split(" ")[0]);
            member.setMemberGender(member.getMemberGender().equals("남")?"true" : "false");
        }
        log.info("enter ID {}", member.toString());
        model.addAttribute("member", member);

        return "memberDetail";
    }

    @GetMapping("main")
    public String mainPage(Model model){
        model.addAttribute("member", null);
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
    public String trainerScheduleManagement(Model model){
        LocalDate date = LocalDate.now(ZoneId.of("Asia/Seoul"));
        model.addAttribute("datas",scheduleDAO.selectAllTrainerSchedule(date.toString()));
        model.addAttribute("dateFilter",date);
        return "trainerScheduleManagement";
    }
    @GetMapping("trainerScheduleManagementFilter")
    public String trainerScheduleManagement(@RequestParam Map<String,Object> map, Model model){
        String date = (String)map.get("dateFilter");
        model.addAttribute("datas",scheduleDAO.selectAllTrainerSchedule(date));
        model.addAttribute("dateFilter",date);
        return "trainerScheduleManagement";
    }

    @GetMapping("dailyScheduleManagement")//일별 스케줄 관리
    public String scheduleManagement(){
        return "dailyScheduleManagement";
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
    public String staffManagement(Model model){
        int i = 0;
        List<StaffDTO> staffList = staffDAO.selectAll();
        staffList.forEach(data->{
            data.setMemberEnrollDate(data.getMemberEnrollDate().split(" ")[0]);
            data.setStaffStartDate(data.getStaffStartDate().split(" ")[0]);
            data.setStaffEndDate(data.getStaffEndDate().split(" ")[0]);
            log.info("staff #"+ (staffList.indexOf(data)+1)+": {}",data.toString());
        });
        model.addAttribute("list",staffList);


        return "staffManagement";
    }
    @GetMapping("enrollStaff")
    public RedirectView enrollStaff(@RequestParam Map<String,Object> map){
        log.info("staff insert : {}",map.toString());
        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setGymId(gymId);
        staffDTO.setMemberName((String)map.get("name"));
        staffDTO.setMemberPhone((String)map.get("phone"));
        staffDTO.setMemberEmail((String)map.get("email"));
        staffDTO.setMemberPassword((String)map.get("password"));
        staffDTO.setMemberEnrollDate((String)map.get("enrollDate"));
        staffDTO.setMemberZipcode((String)map.get("zipcode"));
        staffDTO.setMemberAddress((String)map.get("address"));
        staffDTO.setMemberAddressDetail((String)map.get("address-detail"));

        staffDTO.setStaffTeam((String)map.get("teamSelection"));
        staffDTO.setStaffCaptain((String)map.get("isCaptain"));
        staffDTO.setStaffPosition((String)map.get("positionSelection"));
        staffDTO.setStaffRank((String)map.get("rankSelection"));
        staffDTO.setStaffBankInfo((String)map.get("bank"));
        staffDTO.setStaffBankAccountOwner((String)map.get("bankAccountOwner"));
        staffDTO.setStaffBankAccountNumber((String)map.get("bankAccountNumber"));
        staffDTO.setStaffExtraInfo((String)map.get("extraInfo"));
        staffDTO.setStaffStartDate((String)map.get("hiredDate"));
        staffDTO.setStaffEndDate((String)map.get("retiredDate"));
        staffDTO.setStaffAssigned((String)map.get("isCharge"));
        staffDTO.setStaffAssignedTm((String)map.get("isTmCharge"));
        staffDTO.setStaffStrategyNote((String)map.get("isStrategyNote"));
        staffDTO.setStaffGxInstructor((String)map.get("isGxTrainer"));
        staffDTO.setStaffProfileUnveil((String)map.get("isProfileUnveil"));
        staffDTO.setStaffPurchaseAlterAuthority((String)map.get("isPurchaseUpdater"));
        staffDTO.setStaffIsReaderOnly((String)map.get("isOnlyReader"));
        staffDTO.setStaffMedicalHistory((String)map.get("medicalHistory"));
        staffDTO.setStaffIntro((String)map.get("selfIntro"));


        staffDAO.insert(staffDTO);
        log.info(staffDTO.toString());

        return new RedirectView( "/admin/staffManagement");
    }
    @GetMapping("productManagement")
    public String productManagement(Model model){
        model.addAttribute("datas", productDAO.selectAll());
        return "productManagement";
    }
    @GetMapping("enrollProduct")
    public RedirectView productEnroll(@RequestParam Map<String,Object> map){

        ProductVO productVO = new ProductVO();
        productVO.setProductName((String)map.get("productName"));
        productVO.setProductPrice(Integer.parseInt((String)map.get("productPrice")));
        productVO.setProductExpireDates(Integer.parseInt((String)map.get("productExpireDates")));
        productVO.setGymId(gymId);

        productDAO.insert(productVO);

        return new RedirectView("/admin/productManagement");
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
    public String documentEnrollModal(Model model){
        return "modal/documentEnrollModal";
    }
    @GetMapping("documentEnroll")
    public RedirectView documentEnroll(@RequestParam Map<String,Object> map){
        log.info("document input : {}", map.toString());
        DocumentVO documentVO = new DocumentVO();
        documentVO.setMemberId(Long.parseLong((String)map.get("memberId")));
        documentVO.setDocumentDate((String)map.get("documentDate"));
        documentVO.setDocumentGoal((String)map.get("documentGoal"));
        documentVO.setDocumentBodyInfo((String)map.get("documentBodyInfo"));
        documentVO.setDocumentPainInfo((String)map.get("documentPainInfo"));
        documentVO.setDocumentWeight(Integer.parseInt((String)map.get("documentWeight")));
        documentVO.setDocumentMuscle(Integer.parseInt((String)map.get("documentMuscle")));
        documentVO.setDocumentFatKg(Integer.parseInt((String)map.get("documentFatKg")));
        documentVO.setDocumentFatPercent(Integer.parseInt((String)map.get("documentFatPercent")));
        documentVO.setDocumentBodyScore(Integer.parseInt((String)map.get("documentBodyScore")));

        documentDAO.insert(documentVO);


        return new RedirectView( "/admin/memberDetail?id="+(String)map.get("memberId"));
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
    public String documentHistory(@RequestParam("memberId") String memberId, Model model){
        log.info("enroll history entered with id : {}", memberId);
        log.info("current member document info : {}", documentDAO.selectAll(Long.parseLong(memberId)));
        List<DocumentVO> documentVOList =  documentDAO.selectAll(Long.parseLong(memberId));
        documentVOList.forEach((documentVO -> {
            documentVO.setDocumentDate(documentVO.getDocumentDate().split(" ")[0]);
        }));
        model.addAttribute("documentList", documentVOList);
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
