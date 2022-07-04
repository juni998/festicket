package festicket.demo.controller.login;


import festicket.demo.domain.member.MemberDto;
import festicket.demo.service.impl.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final MemberServiceImpl memberService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("memberDto", new MemberDto());
        return "login/register";
    }

    @PostMapping("/register")
    public String register(@Valid MemberDto memberDto) {

        memberService.save(memberDto);
        log.info("memberForm : " + memberDto);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("memberDto", new MemberDto());
        return "login/login";
    }

    //GET방식 로그아웃
    @GetMapping("/logout")
    //로그아웃 핸들러 사용
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        //시크릿 컨텍스트 내 인증객체 불러오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        //인증객체가 존재하지 않을때
        if (authentication != null) {
            //로그아웃 처리하는 핸들러
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/";

    }

}
