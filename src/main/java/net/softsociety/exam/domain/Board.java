package net.softsociety.exam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 게시글 정보
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	int boardnum;	    //글번호
	String memberid;	//작성자 아이디
	String title;		//제목
	String contents;	//상품소개글 내용
	String inputdate;		//작성일
	String category;	//상품분류(computer/camera/car)
	String soldout;		//판매완료여부 (판매중:'N', 판매완료:'Y')
	String buyerid	;		
}
