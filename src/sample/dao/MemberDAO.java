package com.devandy.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.devandy.web.vo.MemberVO;

@Mapper
public interface MemberDAO {
	List<MemberVO> selectAllMembers();

	MemberVO selectById(String topic);

	void insert(MemberVO member);

	void update(MemberVO member);

	void delete(String topic);
}