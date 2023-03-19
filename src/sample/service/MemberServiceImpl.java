package com.devandy.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devandy.web.dao.MemberDAO;
import com.devandy.web.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDao;

	public List<MemberVO> selectAllMembers() {
		return memberDao.selectAllMembers();
	}

	@Override
	public void insertMember(MemberVO member) {
		memberDao.insert(member);
	}

	@Override
	public void updateMember(String topic, MemberVO updateMember) {
		//
		System.out.println("======================================================");
		//
		MemberVO member = memberDao.selectById(topic);

		System.out.println("info : " + member.getInfo());
		System.out.println("seq : " + member.getSeq());

		if (member != null) {
			member.setSeq(updateMember.getSeq());
			member.setInfo(updateMember.getInfo());

			memberDao.update(member);
		} else {
			throw new IllegalStateException("회원이 존재하지 않습니다.");
		}
	}

	@Override
	public void deleteMember(String topic) {
		if (memberDao.selectById(topic) != null) {
			memberDao.delete(topic);
		} else {
			throw new IllegalStateException("회원이 존재하지 않습니다.");
		}
	}

}
