package net.softsociety.exam.service;

import java.util.ArrayList;

import net.softsociety.exam.domain.Board;
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


}
