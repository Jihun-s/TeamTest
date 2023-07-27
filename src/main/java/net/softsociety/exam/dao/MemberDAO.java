package net.softsociety.exam.dao;

import org.apache.ibatis.annotations.Mapper;

import lombok.extern.java.Log;
import net.softsociety.exam.domain.Member;

/**
 * 회원정보 관련 매퍼
 */
@Mapper
public interface MemberDAO {
	//회원가입
	int joinMember(Member m);
    //ID 개수 확인
    public int countMemberid(String memberid);

}