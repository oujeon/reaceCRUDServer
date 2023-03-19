package com.devandy.web.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {

	@JsonProperty(value = "topic")
	private String topic;

	@JsonProperty(value = "seq")
	private int seq;

	@JsonProperty(value = "info")
	private String info;

}