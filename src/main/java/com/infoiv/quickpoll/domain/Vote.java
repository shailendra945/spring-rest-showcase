package com.infoiv.quickpoll.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="vote_detais")
public class Vote {
	@Id
	@GeneratedValue
	@Column(name="vote_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="option_id")
	private Option option;
	
	

	public Vote() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

	@Override
	public String toString() {
		return "Vote [id=" + id + ", option=" + option + "]";
	}
	
	
	

}
