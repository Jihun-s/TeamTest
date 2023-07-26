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
	
	/** 
	 * 판매 정보 게시판
	 * */
	@GetMapping("list")
	public String list(Model model) {
		// 게시판 목록 불러오기
		ArrayList<Board> boardList = service.selectAllBoard();
		
		model.addAttribute("boardList", boardList);
		return "boardView/list";
	}
	
	/** 
	 * 판매글 등록
	 * */
	@GetMapping("write")
	public String write() {
		
		return "boardView/write";
	}
	
	/** 
	 * 판매글 등록
	 * */
	@PostMapping("write")
	public String write(Board board) {
		log.debug("넘어온 게시글:{}", board);
		
		// 판매글 등록
		int n = service.insertBoard(board);
		
		return "redirect:/boardView/list";
	}
	
	
}
