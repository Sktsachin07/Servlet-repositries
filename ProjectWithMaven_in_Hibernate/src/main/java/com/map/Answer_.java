package com.map;

import javax.persistence.Column;


import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Answer_ {
	
	
	@Id
	@Column(name = "answer_id")
	private int id;
	
	
	private String answer;
	
	@ManyToOne
	private Question_ question;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Answer_(int id, String answer) {
		super();
		this.id = id;
		this.answer = answer;
	}
	public Answer_() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question_ getQuestion() {
		return question;
	}
	public void setQuestion(Question_ question) {
		this.question = question;
	}
	public Answer_(int id, String answer, Question_ question) {
		super();
		this.id = id;
		this.answer = answer;
		this.question = question;
	}
	@Override
	public String toString() {
		return "Answer_ [id=" + id + ", answer=" + answer + ", question=" + question + "]";
	}
	
	

	
	
}
