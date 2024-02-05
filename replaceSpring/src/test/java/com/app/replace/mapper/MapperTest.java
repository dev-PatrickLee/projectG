package com.app.replace.mapper;

import com.app.replace.dao.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class MapperTest {
    @Autowired
    public MemberDAO memberDAO;

    @Test
    void contextLoads() {

        log.info("{}.......", memberDAO.selectAll().toString());
    }


}