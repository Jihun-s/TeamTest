package net.softsociety.exam.service;

import java.util.ArrayList;

import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Member;
import net.softsociety.exam.domain.Reply;

public interface BoardService {

	/** 
	 * 게시판 전체 조회
	 * */
	ArrayList<Board> selectAllBoard();

	/** 
	 * 판매글 등록
	 * */
	int insertBoard(Board board);

	//게시판 글읽기
	   Board read(int boardnum);
	   //게시판 글삭제
	   int delete(int boardnum);
	   
	   //리플목록 출력
	   ArrayList<Reply> replyList();
	   //리플 저장
	   int insertReply(Reply reply);
	//게시글 구매
	boolean purchaseBoard(Board b);
	//판매글 검색
	ArrayList<Board> search(String category, String searchText);

	

}