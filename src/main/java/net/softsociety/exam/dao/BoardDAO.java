package net.softsociety.exam.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;

/**
 * 게시판 관련 매퍼
 */
@Mapper
public interface BoardDAO {

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
	   //리플저장
	   int insertReply(Reply reply);
}
