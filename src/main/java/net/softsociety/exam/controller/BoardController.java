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
		
		for(Board b : boardList) {
			log.debug("게시글:{}");
		}
		
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
	public String write(@AuthenticationPrincipal UserDetails user, Board board) {
		log.debug("넘어온 게시글:{}", board);
		
		// memberid 넣기
		board.setMemberid(user.getUsername());
		
		// 판매글 등록
		int n = service.insertBoard(board);
		
		return "redirect:/board/list";
	}
	
	   //글읽기
	   @GetMapping("read")
	   public String read(
	         @RequestParam(name="boardnum", defaultValue="0") int boardnum
	         , Model model) {
	      Board board = service.read(boardnum);
	      if(board==null) {
	         log.debug("post가 null입니다");
	         return "redirect:/";
	      } else {
	         ArrayList<Reply> replyList = service.replyList();
	         log.debug("{}", replyList);
	         model.addAttribute("replyList", replyList);
	         model.addAttribute("board", board);
	         return "/boardView/read";
	      }
	   }
	   //글삭제
	   @PostMapping("deleteboard")
	   public String delete(int boardnum) {
	      int n = service.delete(boardnum);
	      if(n==0) {
	         log.debug("삭제 실패");
	         return "redirect:/";
	      }
	      return "redirect:/board/list";
	   }
	   
	   //리플저장
	   @PostMapping("insertReply")
	   public String insertReply(@AuthenticationPrincipal UserDetails user
	                     ,Reply reply) {
	      reply.setMemberid(user.getUsername());
	      log.debug("리플:{}",reply);
	      int n = service.insertReply(reply);
	      if(n==0) {
	         log.debug("댓글 저장 실패");
	      }
	      return "redirect:/board/read?boardnum="+reply.getBoardnum();
	   }
}
