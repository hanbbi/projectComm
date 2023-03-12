package com.project.projectcomm.controller;

import com.project.projectcomm.dto.CateDto;
import com.project.projectcomm.dto.UserDto;
import com.project.projectcomm.service.CateService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/cate")
public class CateController {
    CateService cateService;

    public CateController(CateService cateService) {
        this.cateService = cateService;
    }

    @GetMapping("/register.do")
    public String register() {
        return "/cate/register";
    }

    @PostMapping("/register.do")
    public String register(@SessionAttribute UserDto loginUser,
                           HttpSession session,
                           CateDto cate) {
        int register = 0;
        try {
            if (loginUser != null) {
                register = cateService.register(cate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (register > 0) {
            session.setAttribute("msg", "카테고리 등록에 성공했습니다.");
            return "redirect:/";
        } else {
            session.setAttribute("msg", "카테고리 등록 중 문제가 발생했습니다.");
            return "redirect:/cate/register.do";
        }
    }
}
