package com.app.replace.controller;

import com.app.replace.dao.MemberDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/member/*")
public class MemberController {

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

        return "memberList";
    }

    @GetMapping("memberDetail")
    public String detail(){
        return "memberDetail";
    }

    @GetMapping("sidebar")
    public String test(){
        return "sidebar";

    }
}
