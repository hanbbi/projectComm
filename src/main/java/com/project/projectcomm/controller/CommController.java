package com.project.projectcomm.controller;

import com.project.projectcomm.dto.*;
import com.project.projectcomm.service.*;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Controller
@RequestMapping("/comm")
public class CommController {
    private CommService commService;
    private ReplyService replyService;
    private CateService cateService;
    private CateConnService cateConnService;
    private CommLikesService commLikesService;
    private CommReportService commReportService;
    private FriendService friendService;

    @Value("${img.upload.path}")
    private String imgPath;
    private Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public CommController(CommService commService, ReplyService replyService, CateService cateService, CateConnService cateConnService, CommLikesService commLikesService, CommReportService commReportService, FriendService friendService) {
        this.commService = commService;
        this.replyService = replyService;
        this.cateService = cateService;
        this.cateConnService = cateConnService;
        this.commLikesService = commLikesService;
        this.commReportService = commReportService;
        this.friendService = friendService;
    }

    @GetMapping("/list.do")
    public String list(Model model,
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

        return "/comm/user/list";
    }

    @PostMapping("/list.do")
    public String list() {
        return "redirect:/comm/list.do";
    }

    @GetMapping("/{cateId}/list.do")
    public String listByCate(Model model,
                             HttpSession session,
                             @SessionAttribute(required = false) String msg,
                             @SessionAttribute(required = false) UserDto loginUser,
                             @PathVariable String cateId) {
        if (msg != null) {
            session.removeAttribute("msg");
            model.addAttribute("msg", msg);
        }

        Map<String, Object> map = new HashMap<>();
        List<String> cateIdList = new ArrayList<>();
        cateIdList.add(cateId);
        map.put("cateIdList", cateIdList);

        try {
            System.out.println("map : " + map);
            List<CommDto> commList = commService.cateList(map);
            System.out.println("commList : " + commList);

            if (loginUser != null && commList != null) {
                Map<String, FriendDto> friend = friendService.friendCheck(commList, loginUser);
                model.addAttribute("friend", friend);
            }

            model.addAttribute("commList", commList);
            model.addAttribute("realCateId", cateId);

            CateDto cate = cateService.selectCate(cateId);
            model.addAttribute("cate", cate);

            return "/comm/user/cate_list";
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("msg", "커뮤니티 글 로드 중 문제가 발생했습니다.");
            return "redirect:/";
        }
    }

    @PostMapping("/{cateId}/list.do")
    public String listByCate(@PathVariable String cateId) {
        return "redirect:/comm/" + cateId + "/list.do";
    }

    @GetMapping("/{commId}/detail.do")
    public String detail(@PathVariable int commId,
                         Model model,
                         HttpSession session,
                         @SessionAttribute(required = false) String msg,
                         @SessionAttribute(required = false) UserDto loginUser) {
        if (msg != null) {
            session.removeAttribute("msg");
            model.addAttribute("msg", msg);
        }

        try {
            CommDto comm = commService.findComm(commId);
            List<ReplyDto> replyList = replyService.commReplyList(commId);
            int replyCnt = replyService.countCommReply(commId);

            if (loginUser != null) {
                CommLikesDto commLikes = commLikesService.find(commId, loginUser.getUserId());
                comm.getCommLikesView().setCommLikes(commLikes);

                FriendDto friendDto = friendService.findFriend(loginUser, comm.getUserId());
                Map<String, FriendDto> friend = new HashMap<>();
                friend.put("" + commId, friendDto);
                model.addAttribute("friend", friend);
            }

            model.addAttribute("comm", comm);
            model.addAttribute("replyList", replyList);
            model.addAttribute("replyCnt", replyCnt);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return "/comm/user/detail";
    }

    @GetMapping("/register.do")
    public String register(@SessionAttribute UserDto loginUser,
                           HttpSession session,
                           @SessionAttribute(required = false) String msg,
                           Model model) {

        if (msg != null) {
            session.removeAttribute("msg");
            model.addAttribute("msg", msg);
        }

        if (loginUser.getUserStatus() == 0) {
            try {
                List<CateDto> cateList = cateService.listAll();
                model.addAttribute("cateList", cateList);
                return "/comm/user/register";
            } catch (Exception e) {
                e.printStackTrace();
                session.setAttribute("msg", "데이터를 가져오는 중 문제가 생겼습니다.");
                return "redirect:/";
            }
        } else {
            session.setAttribute("msg", "커뮤니티 글을 등록할 수 없습니다.");
            return "redirect:/";
        }
    }

    @PostMapping("/register.do")
    public String register(@SessionAttribute UserDto loginUser,
                           @RequestParam(name = "imgFile", required = false) List<MultipartFile> imgFileList,
                           @RequestParam(name = "cateId", required = false) HashSet<String> cateIdList,
                           HttpSession session,
                           CommDto comm) {

        int register = 0;
        if (loginUser.getUserId() == comm.getUserId()) {
            try {
                register = commService.register(imgFileList, comm, loginUser, cateIdList, imgPath);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }

        if (register > 0) {
            session.setAttribute("msg", "커뮤니티 글 등록에 성공했습니다.");
            return "redirect:/comm/list.do";
        } else {
            session.setAttribute("msg", "커뮤니티 글 등록 중 문제가 발생했습니다.");
            return "redirect:/comm/register.do";
        }
    }

    @GetMapping("/{commId}/modify.do")
    public String modify(@SessionAttribute UserDto loginUser,
                         @PathVariable int commId,
                         Model model,
                         HttpSession session,
                         @SessionAttribute(required = false) String msg) {
        if (msg != null) {
            session.removeAttribute("msg");
            model.addAttribute("msg", msg);
        }

        try {
            List<CateDto> cateList = cateService.listAll();
            model.addAttribute("cateList", cateList);
            CommDto comm = commService.findComm(commId);
            model.addAttribute("comm", comm);
            List<CateConnDto> cateConnList = cateConnService.commConnList(commId);
            model.addAttribute("cateConnList", cateConnList);
            CateConnDto cateConn = cateConnService.findCateConn(commId);
            model.addAttribute("cateConn", cateConn);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return "/comm/user/modify";
    }

    @PostMapping("/modify.do")
    public String modify(@SessionAttribute UserDto loginUser,
                         CommDto comm,
                         @RequestParam(name = "imgFile", required = false) List<MultipartFile> imgFileList,
                         @RequestParam(name = "imgToDelete", required = false) List<String> imgToDeleteList,
                         @RequestParam(name = "cateId") HashSet<String> cateIdList,
                         HttpSession session) {
        int modify = 0;
        if (loginUser.getUserId() == comm.getUserId()) {
            try {
                modify = commService.modifyOne(imgFileList, comm, loginUser, cateIdList, imgPath, imgToDeleteList);
                System.out.println("modify: " + modify);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }

        if (modify > 0) {
            session.setAttribute("msg", "커뮤니티 글 수정에 성공했습니다.");
            return "redirect:/comm/" + comm.getCommId() + "/detail.do";
        } else {
            session.setAttribute("msg", "커뮤니티 글 수정 중 문제가 발생했습니다.");
            return "redirect:/comm/" + comm.getCommId() + "/modify.do";
        }
    }

    @GetMapping("/{commId}/remove.do")
    public String remove(@PathVariable int commId,
                         HttpSession session,
                         Model model,
                         @SessionAttribute(required = false) String msg) {
        if (msg != null) {
            session.removeAttribute("msg");
            model.addAttribute("msg", msg);
        }

        int remove = 0;
        try {
            cateConnService.removeOne(commId);
            remove = commService.removeOne(commId);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        if (remove > 0) {
            session.setAttribute("msg", "커뮤니티 글 삭제에 성공했습니다.");
            return "redirect:/comm/list.do";
        } else {
            session.setAttribute("msg", "커뮤니티 글 삭제 중 문제가 발생했습니다.");
            return "redirect:/comm/" + commId + "/detail.do";
        }
    }
}
