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

    //게시판 전체 조회
    ArrayList<Board> selectAllBoard();
    //글 작성
    int insertBoard(Board board);
    //게시글 읽기
    Board read(int boardnum);
    //댓글 작성
    int insertReply(Reply reply);
    //댓글 목록 불러오기
    ArrayList<Reply> replyList(int boardnum);
    //글 삭제
    int delete(int boardnum);
    //구매하기
    int modifyInfo(Board b);
}
