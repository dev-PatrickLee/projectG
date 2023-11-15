package com.app.replace;

import com.app.replace.dao.MemberDAO;
import com.app.replace.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Slf4j
@SpringBootTest
class ReplaceApplicationTests {

    @Autowired
    public MemberDAO memberDAO;

    @Test
    void insertTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberName("홍길동");
        memberVO.setMemberGender("남");
        memberVO.setMemberPassword("pw1234");
        memberVO.setMemberPhone("01012345678");
        memberVO.setMemberBirthday("2023-11-09");
        memberVO.setMemberZipcode("123456");
        memberVO.setMemberAddress("서울특별시");
        memberVO.setMemberAddressDetail("");
        memberVO.setMemberEnrollType("무료체험 등록");
        memberVO.setMemberVisitPath("소개");
        memberVO.setMemberSelfAgreement("예");
        memberVO.setMemberSmsAgreement("off");
        memberVO.setMemberTmAgreement("off");
        memberVO.setMemberGoal("다이어트");
        memberVO.setMemberEmail("email@email.com");
        memberVO.setMemberWorkoutHour("1");
        memberVO.setMemberInterest("복싱");
        memberVO.setMemberMemo("test memo");

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

        });


//        memberDAO.insert(memberVO);
//        log.info("{}......", memberDAO.selectAll().toString());
    }
}
