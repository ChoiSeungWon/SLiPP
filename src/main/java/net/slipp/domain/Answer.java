package net.slipp.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Answer extends AbstractEntity {
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_question"))
	@JsonProperty
	private Question question;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_writer"))
	@JsonProperty
	private User user;
	
	@Lob
	@JsonProperty
	private String contents;
	
	public Answer(){
		
	}
	
	public Answer(User writer, String contents,Question question){
		this.user = writer;
		this.contents = contents;
		this.question = question;
	}


	@Override
	public String toString() {
		return "Answer ["+ super.toString() +", user=" + user + ", contents=" + contents + "]";
	}
	

	
	public boolean isSameWriter(User loginUser) {
		// TODO Auto-generated method stub
		return loginUser.equals(this.user);
	}
	
}
