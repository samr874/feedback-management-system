package com.feedbackservice.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;



import com.feedbackservice.FeedbackSentiment;

@Document

public class Feedback {
	@Id
	private String id;
	@Indexed
	private long empid;
	private List<String> strength;
	private List<String> areasToImprove;
	private FeedbackSentiment sentiment;
	private LocalDateTime createdAt;
	public Feedback() {
		super();
	}
	public Feedback(long empid, List<String> strength, List<String> areasToImprove, FeedbackSentiment sentiment,
			LocalDateTime createdAt) {
		super();
		this.empid = empid;
		this.strength = strength;
		this.areasToImprove = areasToImprove;
		this.sentiment = sentiment;
		this.createdAt = createdAt;
	}
	
	public long getEmpid() {
		return empid;
	}
	public void setEmpid(long empid) {
		this.empid = empid;
	}
	public List<String> getStrength() {
		return strength;
	}
	public void setStrength(List<String> strength) {
		this.strength = strength;
	}
	public List<String> getAreasToImprove() {
		return areasToImprove;
	}
	public void setAreasToImprove(List<String> areasToImprove) {
		this.areasToImprove = areasToImprove;
	}
	public FeedbackSentiment getSentiment() {
		return sentiment;
	}
	public void setSentiment(FeedbackSentiment sentiment) {
		this.sentiment = sentiment;
	}
	@Override
	public String toString() {
		return "Feedback [id=" + id + ", empid=" + empid + ", strength=" + strength + ", areasToImprove="
				+ areasToImprove + ", sentiment=" + sentiment + ", createdAt=" + createdAt + "]";
	}
	
	
	

}
