package net.softsociety.exam.service;

import java.util.ArrayList;

import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;

public interface BoardService {
	//선택글 읽기
	public Board selectOne(int boardnum);
	//선택된 글에 달린 댓글 불러오기
	public ArrayList<Reply> selectReply(int boardnum);
	//선택글 삭제
	public int deleteOne(Board b);
	//댓글 쓰기
	public int insertReply(Reply r);
	//글목록 불러오기
	public ArrayList<Board> getBoardList(Board b);

	


}
