package com.project.projectcomm.controller;

import com.project.projectcomm.dto.*;
import com.project.projectcomm.service.CommLikesService;
import com.project.projectcomm.service.CommService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@Controller
@RequestMapping("/commLikes/")
public class CommLikesController {
    private CommLikesService commLikesService;
    private CommService commService;

    public CommLikesController(CommLikesService commLikesService, CommService commService) {
        this.commLikesService = commLikesService;
        this.commService = commService;
    }
    
    @GetMapping("/{userId}/list.do")
    public String CommLikesList(@SessionAttribute UserDto loginUser,
                                @SessionAttribute(required = false) String msg,
                                @PathVariable int userId,
                                HttpSession session,
                                Model model) {
        if (msg != null) {
            session.removeAttribute("msg");
            model.addAttribute("msg", msg);
        }
        
        try {
            List<CommLikesDto> commLikesList = commLikesService.commLikesList(loginUser.getUserId());
            model.addAttribute("commLikesList", commLikesList);
            return "/comm/user/commList";
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("msg", "좋아요 목록 로드 중 문제가 발생했습니다.");
            return "redirect:/";
        }
    }
    
    @GetMapping("/view.do")
    public String view(@SessionAttribute(required = false) UserDto loginUser,
                       int commId,
                       Model model) {
        int loginUserId = (loginUser != null) ? loginUser.getUserId() : 0;
        CommLikesViewDto commLikesView = commLikesService.findCommLikes(commId, loginUserId);
        model.addAttribute("commLikesView", commLikesView);
        return "/comm/user/commLikes";
    }
    
    @RequestMapping(method = {GET, PUT}, path = "/handler.do")
    public @ResponseBody AjaxStateHandler handler(int commId,
                                                  boolean likesBtn,
                                                  @SessionAttribute UserDto loginUser) {
        AjaxStateHandler ajaxStateHandler = new AjaxStateHandler();
        CommLikesDto commLikes = commLikesService.find(commId, loginUser.getUserId());
        int handler = 0;

        if (commLikes == null) {
            commLikes = new CommLikesDto();
            commLikes.setCommId(commId);
            commLikes.setUserId(loginUser.getUserId());
            commLikes.setLikes(likesBtn);
            handler = commLikesService.register(commLikes);
        } else {
            if (commLikes.isLikes() == likesBtn) {
                handler = commLikesService.remove(commLikes.getClikesId());
            } else {
                commLikes.setLikes(likesBtn);
                handler = commLikesService.modify(commLikes);
            }
        }

        ajaxStateHandler.setState(handler);
        return ajaxStateHandler;
    }
}
