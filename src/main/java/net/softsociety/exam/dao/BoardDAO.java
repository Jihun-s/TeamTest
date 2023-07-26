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

	Board selectOne(int boardnum);

	ArrayList<Reply> selectReply(int boardnum);

	int deleteone(Board b);

	int insertReply(Reply r);

	ArrayList<Board> getBoardList(Board b);

}
