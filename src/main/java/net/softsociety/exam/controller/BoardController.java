package net.softsociety.exam.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;
import net.softsociety.exam.service.BoardService;

/**
 * 상품게시판 관련 콘트롤러
 */
@Slf4j
@RequestMapping("board")
@Controller
public class BoardController {
	@Autowired
	BoardService service;
	
	//게시글 하나 읽기
	@GetMapping("selectOne")
	public String selectOne( 
		   			Model m
					,@RequestParam(name="boardnum", defaultValue="0")int boardnum)
    {
    	//ArrayList<Reply> r= service.selectReply(boardnum);
		log.debug("여기로 오는지:{}", boardnum);
    	Board b = service.selectOne(boardnum);
    	//보드번호 없으면 글목록으로 리턴
    	if(b ==null) {
			return "redirect:/list";
		}
    	
    	m.addAttribute("board", b);
		//m.addAttribute("reply", r);
		
		return "boardView/selectOne?boardnum=" + b.getBoardnum();
    }
	
	//게시글 삭제
	@GetMapping("deleteOne")
	public String deleteOne(@AuthenticationPrincipal UserDetails user
							, Board b) {
		b.setMemberid(user.getUsername());
		service.deleteOne(b);
		return "boardView/list";
	}
	//댓글쓰기
	@PostMapping("insertReply")
	public String insertReply(@AuthenticationPrincipal UserDetails user ,Reply r) {
		
		 r.setMemberid(user.getUsername());
		 int num = service.insertReply(r);
		 
		 return "redirect:/board/selectOne?boardnum="+r.getBoardnum();
	}
	//상품 구매
	@PostMapping("purchase")
	public String purchase(@RequestParam("boardnum")int boardnum) {		
		
		return "boardView/list";
	}
	//게시글목록으로 이동
	@GetMapping("list")
	public String list(Model m, Board b) {
	ArrayList<Board> list = service.getBoardList(b);
	
	m.addAttribute("list", list);
	return "boardView/list";
	}
					
		
		
	
	}

