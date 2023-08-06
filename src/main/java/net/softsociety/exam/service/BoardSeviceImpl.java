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

    //판매글 등록
    @Override
    public int insertBoard(Board board) {
        return dao.insertBoard(board);
    }

    //글 읽기
    @Override
    public Board read(int boardnum) {
        return dao.read(boardnum);
    }

    @Override
    public int insertReply(Reply reply) {
        return dao.insertReply(reply);
    }

    @Override
    public ArrayList<Reply> replyList(int boardnum) {
        return dao.replyList(boardnum);
    }

    @Override
    public int delete(int boardnum) {
        return dao.delete(boardnum);
    }

    @Override
    public int modifyInfo(Board b) {
        return dao.modifyInfo(b);
    }
	   
}
