package com.project.projectcomm.controller;

import com.project.projectcomm.dto.CommDto;
import com.project.projectcomm.dto.CommLikesDto;
import com.project.projectcomm.dto.UserDto;
import com.project.projectcomm.service.CommLikesService;
import com.project.projectcomm.service.CommService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            return "/commLikes/list";
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("msg", "좋아요 목록 로드 중 문제가 발생했습니다.");
            return "redirect:/";
        }
    }
    
    @GetMapping("/{userId}/show.do")
    public String show(@SessionAttribute UserDto loginUser,
                       @PathVariable int userId,
                       @RequestParam int commId,
                       Model model) {
        try {
            CommDto comm = commService.findComm(commId);
            CommLikesDto commLikesDto = commLikesService.findCommLikes(loginUser, commId);
            Map<String, CommLikesDto> commLikes = new HashMap<>();
            commLikes.put(String.valueOf(commId), commLikesDto);
            model.addAttribute("comm", comm);
            model.addAttribute("commLikes", commLikes);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "찜 안보임");
        }
        
        return "/commLikes/register";
    }
    
    @PostMapping("/register.do")
    public @ResponseBody int register(@SessionAttribute UserDto loginUser,
                                      HttpSession session,
                                      CommLikesDto commLikes,
                                      Model model) {
        int register = 0;
        try {
            register = commLikesService.register(commLikes);
            return register;
        } catch (Exception e) {
            session.setAttribute("msg", "찜 등록 중 문제가 발생했습니다.");
            return 0;
        }
    }
    
    @DeleteMapping("/remove.do")
    public @ResponseBody int remove(@SessionAttribute UserDto loginUser,
                                    @RequestParam(name = "clikesId") int clikesId,
                                    HttpSession session) {
        try {
            int remove = commLikesService.removeOne(clikesId);
            return remove;
        } catch (Exception e) {
            session.setAttribute("msg", "찜 삭제 중 문제가 발생했습니다.");
            return 0;
        }
    }
    
    @PostMapping("/removeOne.do")
    public String removeOne(@SessionAttribute UserDto loginUser,
                            @RequestParam List<Integer> clikesIds,
                            HttpSession session) {
        int remove = 0;
        try {
            for (int i = 0; i < clikesIds.size(); i++) {
                int id = Integer.parseInt(String.valueOf(clikesIds.get(i)));
                remove = commLikesService.removeOne(id);
            }
        } catch (Exception e) {
            session.setAttribute("msg", "찜 삭제 중 문제가 발생했습니다.");
        }
        
        if (remove > 0) {
            return "redirect:/commLikes/list.do";
        } else {
            session.setAttribute("msg", "삭제 실패");
            return "redirect:/commLikes/list.do";
        }
    }
}
