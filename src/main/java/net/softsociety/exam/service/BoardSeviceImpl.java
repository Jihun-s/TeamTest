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
	
	//댓글불러오기
	@Override
	public ArrayList<Reply> selectReply(int boardnum) {
		ArrayList<Reply> reply = dao.selectReply(boardnum);
		return reply;
	}
	//선택글 읽기
	@Override
	public Board selectOne(int boardnum) {
		Board b = dao.selectOne(boardnum);
		return b;
	}
	//선택글 삭제
	@Override
	public int deleteOne(Board b) {
		int n = dao.deleteone(b);
		return n;
	}
	//댓글 입력
	@Override
	public int insertReply(Reply r) {
		int n = dao.insertReply(r);
		return n;
	}
	//글목록 불러오기
	@Override
	public ArrayList<Board> getBoardList(Board b) {
		ArrayList<Board> list = dao.getBoardList(b);
		return list;
	}


}
