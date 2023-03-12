package com.project.projectcomm.controller;

import com.project.projectcomm.dto.AjaxStateHandler;
import com.project.projectcomm.dto.ReplyDto;
import com.project.projectcomm.dto.UserDto;
import com.project.projectcomm.service.ReplyLikesService;
import com.project.projectcomm.service.ReplyReportService;
import com.project.projectcomm.service.ReplyService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reply")
public class ReplyController {
    private ReplyService replyService;
    private ReplyLikesService replyLikesService;
    private ReplyReportService replyReportService;
    private Logger log = LoggerFactory.getLogger(this.getClass());

    public ReplyController(ReplyService replyService, ReplyLikesService replyLikesService, ReplyReportService replyReportService) {
        this.replyService = replyService;
        this.replyLikesService = replyLikesService;
        this.replyReportService = replyReportService;
    }

    @GetMapping("/{commId}/list.do")
    public String list(@PathVariable int commId,
                       int replyId,
                       Model model,
                       HttpSession session,
                       @SessionAttribute(required = false) String msg) {
        if (msg != null) {
            session.removeAttribute("msg");
            model.addAttribute("msg", msg);
        }

        try {
            List<ReplyDto> replyList = replyService.commReplyList(commId);
            log.info("replyList : " + replyList);
            model.addAttribute("replyList", replyList);
            int replyLikesCnt = replyLikesService.countReplyLikes(replyId);
            model.addAttribute("replyLikesCnt", replyLikesCnt);
            System.out.println("replyLikesCnt : "+replyLikesCnt);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return "/comm/reply/list";
    }

    @DeleteMapping("/remove.do")
    public @ResponseBody AjaxStateHandler remove(int replyId,
                                                 @SessionAttribute UserDto loginUser,
                                                 HttpSession session,
                                                 @SessionAttribute(required = false) String msg,
                                                 Model model) {
        if (msg != null) {
            session.removeAttribute("msg");
            model.addAttribute("msg", msg);
        }

        AjaxStateHandler ajaxStateHandler = new AjaxStateHandler();

        try {
            ReplyDto reply = replyService.findReply(replyId);
            int remove = replyService.removeOne(replyId);
            ajaxStateHandler.setState(remove);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return ajaxStateHandler;
    }

    @PostMapping("/register.do")
    public @ResponseBody int register(ReplyDto reply,
                                      @SessionAttribute UserDto loginUser) {
        int register = 0;
        log.info("reply : " + reply);

        try {
            register = replyService.register(reply);
            log.info("register : " + register);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return register;
    }

    @GetMapping("/modify.do")
    public String modify(int replyId,
                         @SessionAttribute UserDto loginUser,
                         Model model,
                         HttpSession session,
                         @SessionAttribute(required = false) String msg) {
        if (msg != null) {
            session.removeAttribute("msg");
            model.addAttribute("msg", msg);
        }

        try {
            ReplyDto reply = replyService.findReply(replyId);
            model.addAttribute("reply", reply);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return "/comm/reply/modify";
    }

    @PutMapping("/modify.do")
    public @ResponseBody AjaxStateHandler modify(ReplyDto reply,
                                                 @SessionAttribute UserDto loginUser) {
        AjaxStateHandler ajaxStateHandler = new AjaxStateHandler();

        try {
            int modify = replyService.modifyOne(reply);
            ajaxStateHandler.setState(modify);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return ajaxStateHandler;
    }
}
