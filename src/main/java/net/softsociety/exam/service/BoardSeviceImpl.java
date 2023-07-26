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
		return null;
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


}
