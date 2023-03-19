package com.devandy.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devandy.web.vo.MemberVO;

@Service
public interface MemberService {

	List<MemberVO> selectAllMembers();

	void insertMember(MemberVO member);

	void updateMember(String topic, MemberVO member);

	void deleteMember(String topic);

}
