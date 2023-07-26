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


}
