package com.map2;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Answer {

@Id	
@Column(name = "ans_id")
private int id;
private String answer;

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
public Answer(int id, String answer) {
	super();
	this.id = id;
	this.answer = answer;
}
public Answer() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Answer [id=" + id + ", answer=" + answer + "]";
}







}
