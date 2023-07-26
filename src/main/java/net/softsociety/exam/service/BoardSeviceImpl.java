package net.softsociety.exam.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.softsociety.exam.dao.BoardDAO;
import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;


@Transactional
@Service
public class BoardSeviceImpl implements BoardService {

	@Autowired
	BoardDAO dao;
	
	/** 
	 * 게시판 전체 조회
	 * */
	@Override
	public ArrayList<Board> selectAllBoard() {
		// TODO Auto-generated method stub
		ArrayList<Board> boardList = dao.selectAllBoard();
		return boardList;
	}

	/** 
	 * 판매글 등록
	 * */
	@Override
	public int insertBoard(Board board) {
		// TODO Auto-generated method stub
		int result = dao.insertBoard(board);
		return result;
	}

	   //게시판 글읽기
	   @Override
	   public Board read(int boardnum) {
	      return dao.read(boardnum);
	   }
	   
	   //게시판 글삭제
	   @Override
	   public int delete(int boardnum) {
	      return dao.delete(boardnum);
	   }


	   //리플목록 출력
	   @Override
	   public ArrayList<Reply> replyList() {
	      return dao.replyList();
	   }
	   //리플저장

	   @Override
	   public int insertReply(Reply reply) {
	      return dao.insertReply(reply);
	   }
	   
}
