package com.project.projectcomm.controller;

import com.project.projectcomm.dto.UserDto;
import com.project.projectcomm.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private Logger log = LoggerFactory.getLogger(this.getClass());

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup.do")
    public String signup(@SessionAttribute(required = false) String msg,
                         HttpSession session,
                         Model model) {
        if (msg != null) {
            session.removeAttribute("msg");
            model.addAttribute("msg", msg);
        }
        model.addAttribute("msg", msg);
        return "/user/signup";
    }

    @PostMapping("/signup.do")
    public String signup(UserDto user,
                         HttpSession session) {
        try {
            userService.register(user);
            session.setAttribute("msg", "회원가입을 성곡적으로 마쳤습니다.");
            return "redirect:/user/login.do";
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("msg", "회원가입 중 문제가 발생했습니다.");
            return "redirect:/user/signup.do";
        }
    }

    @GetMapping("/login.do")
    public String login(@SessionAttribute(required = false) String msg,
                        HttpSession session,
                        Model model) {
        if (msg != null) {
            session.removeAttribute("msg");
            model.addAttribute("msg", msg);
        }
        return "/user/login";
    }

    @PostMapping("/login.do")
    public String login(HttpSession session,
                        String userEmail,
                        String userPw,
                        @SessionAttribute(required = false) String getUrl,
                        @SessionAttribute(required = false) boolean postUrl,
                        @SessionAttribute(required = false) String previousUrl) {
        session.removeAttribute("getUrl");
        session.removeAttribute("postUrl");
        session.removeAttribute("previousUrl");

        try {
            UserDto user = userService.login(userEmail, userPw);
            if (user == null) {
                session.setAttribute("msg", "이메일 또는 비밀번호를 잘못 입력했습니다.");
                return "redirect:/user/login.do";
            }
            session.setAttribute("loginUser", user);

            if (!postUrl) {
                if (getUrl != null) return "redirect:" + getUrl;
            } else {
                session.setAttribute("msg", "다시 한 번 더 입력해주세요.");
            }

            if (previousUrl != null && !previousUrl.contains("login.do") && !previousUrl.contains("signup.do")) {
                return "redirect:" + previousUrl;
            }
            return "redirect:/";
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("msg", "로그인 중 문제가 발생했습니다.");
            return "redirect:/user/login.do";
        }
    }

    @GetMapping("/findPw.do")
    public String findPw(@SessionAttribute(required = false) String msg,
                         HttpSession session,
                         Model model) {
        if (msg != null) {
            session.removeAttribute("msg");
            model.addAttribute("msg", msg);
        }
        return "/user/findPw";
    }

    @PostMapping("/findPw.do")
    public String findPw(String userName,
                         String userEmail,
                         HttpSession session) {
        UserDto user = null;
        try {
            user = userService.findPw(userEmail, userName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (user == null) {
            session.setAttribute("msg", "존재하지 않는 이메일 또는 이름입니다.");
            return "redirect:/user/findPw.do";
        } else {
            session.setAttribute("msg", "해당 이메일로 링크를 발송했습니다.");
            return "redirect:/user/login.do";
        }
    }

    @GetMapping("/{userId}/resetPw.do")
    public String resetPw(Model model,
                          @PathVariable(required = true, name = "userId") int userId,
                          @SessionAttribute(required = false) String msg,
                          HttpSession session) {
        if (msg != null) {
            session.removeAttribute("msg");
            model.addAttribute("msg", msg);
        }
        model.addAttribute("userId", userId);
        return "/user/resetPw";
    }

    @PostMapping("/resetPw.do")
    public String resetPw(@SessionAttribute UserDto loginUser,
                          String userPw,
                          int userId,
                          HttpSession session) {
        int reset = 0;
        try {
            UserDto user = userService.findOne(userId);
            user.setUserPw(userPw);
            reset = userService.modifyOne(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (reset > 0) {
            session.setAttribute("msg", "비밀번호를 성공적으로 재설정했습니다.");
            return "redirect:/user/" + loginUser.getUserId() + "/modify.do";
        } else {
            session.setAttribute("msg", "비밀번호 재설정 중 문제가 발생했습니다.");
            return "redirect:/user/" + loginUser.getUserId() + "/resetPw.do";
        }
    }

    @GetMapping("/{userId}/remove.do")
    public String remove(@SessionAttribute UserDto loginUser,
                         HttpSession session) {
        int remove = 0;
        try {
            remove = userService.removeOne(loginUser.getUserId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (remove > 0) {
            session.removeAttribute("loginUser");
            session.setAttribute("msg", "사용자 " + loginUser.getUserName() + " 님의 계정이 탈퇴되었습니다.");
            return "redirect:/";
        } else {
            session.setAttribute("msg", "탈퇴 중 문제가 발생했습니다.");
            return "redirect:/user/" + loginUser.getUserId() + "/modify.do";
        }
    }

    @GetMapping("/{userId}/modify.do")
    public String modify(@SessionAttribute UserDto loginUser,
                         Model model,
                         @PathVariable int userId,
                         @SessionAttribute(required = false) String msg,
                         HttpSession session) {
        if (msg != null) {
            session.removeAttribute("msg");
            model.addAttribute("msg", msg);
        }
        model.addAttribute("user", loginUser);
        model.addAttribute("userId", userId);
        return "/user/modify";
    }

    @PostMapping("/{userId}/modify.do")
    public String modify(@SessionAttribute UserDto loginUser,
                         UserDto modifiedUser,
                         HttpSession session) {
        int modify = 0;
        try {
            modifiedUser.setUserPw(loginUser.getUserPw());
            modify = userService.modifyOne(modifiedUser);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (modify > 0) {
            session.removeAttribute("loginUser");
            UserDto user = userService.findOne(loginUser.getUserId());
            session.setAttribute("loginUser", user);
            session.setAttribute("msg", "사용자 정보가 성공적으로 수정되었습니다.");
        } else {
            session.setAttribute("msg", "사용자 정보 수정 중 문제가 발생했습니다.");
        }
        return "redirect:/user/" + loginUser.getUserId() + "/modify.do";
    }

    @GetMapping("/logout.do")
    public String logout(@SessionAttribute UserDto loginUser,
                         HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }

    @PostMapping("/check.do")
    public @ResponseBody Map<String, Boolean> check(
            @RequestParam UserDto userData
    ) {
        try {
            return userService.checkIfExists(userData);
        } catch (Exception e) {
            return null;
        }
    }

}
