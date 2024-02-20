package com.map;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Question_ {
	
	@Id
	@Column(name = "question_id")
	private int id;
	
	private String question;
	
    
	///@OneToMany(mappedBy = "question",cascade = CascadeType.ALL)
	@OneToMany(mappedBy = "question",fetch = FetchType.EAGER)
	private List<Answer_> answers;


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getQuestion() {
	return question;
}


public void setQuestion(String question) {
	this.question = question;
}




public List<Answer_> getAnswers() {
	return answers;
}


public void setAnswers(List<Answer_> answers) {
	this.answers = answers;
}


public Question_(int id, String question, List<Answer_> answers) {
	super();
	this.id = id;
	this.question = question;
	this.answers = answers;
}


public Question_() {
	super();
	// TODO Auto-generated constructor stub
}
	
	
	
	
	

	
}
