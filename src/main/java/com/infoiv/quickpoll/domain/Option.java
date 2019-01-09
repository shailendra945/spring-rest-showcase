package com.infoiv.quickpoll.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="option_deatils")
public class Option {
	@Id
	@GeneratedValue
	@Column(name="option_id")
	private Long id;
	
	@Column(name="option_value")
	private String value;
	
	public Option() {
		super();
	}

	public Option(String value) {
		super();
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Option [id=" + id + ", value=" + value + "]";
	}
	
	

	
	
	
}
