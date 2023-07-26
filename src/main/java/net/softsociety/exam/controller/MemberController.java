package net.softsociety.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.exam.dao.MemberDAO;
import net.softsociety.exam.domain.Member;
import net.softsociety.exam.service.MemberService;

/**
 * 회원 정보 관련 콘트롤러
 */

@Slf4j
@RequestMapping("member")
@Controller
public class MemberController {
	
	@Autowired
	MemberService service;
	@Autowired
	MemberDAO dao;
	
	//회원가입 폼으로 이동
	@GetMapping("join")
	public String join1() {
		return "memberView/join";
	}
	//회원가입 처리
	@PostMapping("join")
	public String join111(Member m) {
		log.debug("가입정보:{}", m);
		service.joinMember(m);
		return "redirect:/";
	}
	
	//로그인 폼으로 이동
	@GetMapping("login")
	public String login() {
		
		return "memberView/loginForm";
	}
	
	/**
	 * ID 검색
	 */
	@ResponseBody
	@PostMapping("idcheck")
	public int idcheck(String memberid) {
		int cnt = 0;
		log.debug("아이디 컨트롤까지 오나요? {}", memberid);
		cnt = dao.countMemberid(memberid);
		return cnt;
	}
}
