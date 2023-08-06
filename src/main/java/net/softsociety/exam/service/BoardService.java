package net.softsociety.exam.service;

import java.util.ArrayList;

import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Member;
import net.softsociety.exam.domain.Reply;

public interface BoardService {

    int insertBoard(Board board);

    Board read(int boardnum);

    int insertReply(Reply reply);

    ArrayList<Reply> replyList(int boardnum);

    int delete(int boardnum);

    int modifyInfo(Board b);

}
