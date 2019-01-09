package com.infoiv.quickpoll.domain;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="poll_details")
public class Poll {
	
	@Id
	@GeneratedValue
	@Column(name="poll_id")
	private Long id;
	@Column(name="question")
	private String question;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="poll_id")
	private Set<Option> options;
	
	

	public Poll() {
		super();
	}

	public Poll(String question) {
		super();
		this.question = question;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Set<Option> getOptions() {
		return options;
	}

	public void setOptions(Set<Option> options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return "Poll [id=" + id + ", question=" + question + "]";
	}

	
	
}
