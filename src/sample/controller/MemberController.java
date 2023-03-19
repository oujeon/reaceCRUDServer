package com.devandy.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.devandy.web.service.MemberService;
import com.devandy.web.vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	@GetMapping("/help/read")
	public @ResponseBody List<MemberVO> selectListMembers() {
		List<MemberVO> allMembers = memberService.selectAllMembers();
		return allMembers;
	}

	@PostMapping("/help/create")
	public List<MemberVO> insertMember(@RequestBody MemberVO member) {
		memberService.insertMember(member);
		return memberService.selectAllMembers();
	}

	@PutMapping("/help/update/{topic}")
	public List<MemberVO> updateMember(@PathVariable String topic, @RequestBody MemberVO member) {

		memberService.updateMember(topic, member);

		return memberService.selectAllMembers();
	}

	@DeleteMapping("/help/delete/{topic}")
	public List<MemberVO> deleteMember(@PathVariable String topic) {
		memberService.deleteMember(topic);
		return memberService.selectAllMembers();
	}
}