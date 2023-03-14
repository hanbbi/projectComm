package com.project.projectcomm.controller;

import com.project.projectcomm.dto.CommDto;
import com.project.projectcomm.dto.CommLikesDto;
import com.project.projectcomm.dto.FriendDto;
import com.project.projectcomm.dto.UserDto;
import com.project.projectcomm.service.CommLikesService;
import com.project.projectcomm.service.CommService;
import com.project.projectcomm.service.FriendService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    CommService commService;
    CommLikesService commLikesService;
    FriendService friendService;

    @Value("${img.upload.path}")
    private String imgPath;
    private Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public MainController(CommService commService, CommLikesService commLikesService, FriendService friendService) {
        this.commService = commService;
        this.commLikesService = commLikesService;
        this.friendService = friendService;
    }

    @GetMapping("/")
    public String main(Model model,
                       HttpSession session,
                       @SessionAttribute(required = false) String msg,
                       @SessionAttribute(required = false) UserDto loginUser) {
        if (msg != null) {
            session.removeAttribute("msg");
            model.addAttribute("msg", msg);
        }

        try {
            List<CommDto> commList = commService.listAll();
            model.addAttribute("commList", commList);

            if (loginUser != null) {
                Map<String, FriendDto> friend = friendService.friendCheck(commList, loginUser);
                model.addAttribute("friend", friend);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return "comm/user/list";
    }
}
