package net.softsociety.exam.service;

import java.util.ArrayList;

import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;

public interface BoardService {
	//게시판 글읽기
	Board read(int boardnum);
	//리플목록 출력
	ArrayList<Reply> replyList();


}
