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

}
