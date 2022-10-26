package com.example.board.controller;

import com.example.board.entity.Board;
import com.example.board.entity.Member;
import com.example.board.form.LogInVO;
import com.example.board.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.board.form.SignInVo;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class MemberController {

    MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member/signin")
    public String newMemberPage() {
        return "member/signIn";
    }

    @PostMapping("/member/signin")
    public String signInMember(@ModelAttribute SignInVo signInVo) {
        // 유저 아이디 존재 여부
        String userId = signInVo.getUserId();
        if (memberService.findByUserId(userId) != null) {
            System.out.println("이미 존재하는 아이디 입니다!");
            return "redirect:/member/signin";
        }

        // 유저 생성
        Member member = new Member();
        member.setUserId(signInVo.getUserId());
        member.setUserName(signInVo.getUserName());
        member.setUserPwd(signInVo.getPwd());
        memberService.signInMember(member);
        return "redirect:/";
    }

    @GetMapping("/")
    public String IndexPage(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("member");
        model.addAttribute("user", member);
        return "index";
    }

    @GetMapping("/member/login")
    public String loginPage(@CookieValue(name = "userId", required = false) Long userId, Model model
            , HttpServletRequest request) {
        /* Cookie
        if (userId != null) {
            Member member = memberService.findByIdx(userId);
            if (member != null) {
                model.addAttribute("user", member);
                return "index";
            }
        }
        */
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("member");
        if (member != null) {

            return "redirect:/";
        }
        return "member/logIn";
    }

    @PostMapping("/member/login")
    public String logInMember(@Valid @ModelAttribute LogInVO logInVO, HttpServletResponse response, HttpServletRequest request) {
        Member member = memberService.logInMember(logInVO.getId(), logInVO.getPwd());

        if (member == null) {
            System.out.println("password error");
            return "/member/logIn";
        }
        /* cookie
        Cookie cookie = new Cookie("userId", String.valueOf(member.getIdx()));
        response.addCookie(cookie);
        */
        HttpSession session = request.getSession();
        session.setAttribute("member", member);

        System.out.println(member);
        return "redirect:/";
    }

    @GetMapping("/member/profile/{userIdx}")
    public String getProfilePage(@PathVariable("userIdx") Long idx, Model model) {
//        Member member = memberService.findByIdx(idx);
//        model.addAttribute("user", member);
        List<Board> posts = memberService.findByIdx(idx).getBoardList();
        model.addAttribute("posts", posts);
        return "/member/profile";
    }
}
