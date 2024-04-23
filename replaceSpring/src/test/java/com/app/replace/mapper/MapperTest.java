package com.app.replace.mapper;

import com.app.replace.dao.*;
import com.app.replace.dto.MemberDTO;
import com.app.replace.vo.GymVO;
import com.app.replace.vo.MemberVO;
import com.app.replace.vo.ScheduleVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;

@SpringBootTest
@Slf4j
public class MapperTest {
    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private GymDAO gymDAO;


    @Autowired
    private ScheduleDAO scheduleDAO;


    @Test
    public void test1(){

        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setMemberName("홍길동");
        memberDTO.setMemberEmail("email@email.com");
        memberDTO.setMemberPassword("pw1234");
        memberDTO.setMemberPhone("01012345678");
        memberDTO.setMemberZipcode("000000");
        memberDTO.setMemberAddress("서울특별시");
        memberDTO.setGymId(22);

        memberDTO.setMemberGender("남");
        memberDTO.setMemberBirthday("1999-01-01");
        memberDTO.setMemberVisitPath("방문");

        log.info(memberDTO.toString());
        customerDAO.insert(memberDTO);
    }

    @Test
    public void test2(){
        GymVO gymVO = new GymVO();

        gymVO.setGymName("헬스jang");
        gymVO.setGymPhone("01012349876");
        gymVO.setGymZipcode("04928");
        gymVO.setGymAddress("부산시");
        gymVO.setGymAddressDetail("해운대");

        gymDAO.insert(gymVO);
    }

    @Test
    public void test3(){
        List<ScheduleVO> scheduleVOList = scheduleDAO.selectAll();
        log.info("schedule list : {}",scheduleVOList);
    }


}
