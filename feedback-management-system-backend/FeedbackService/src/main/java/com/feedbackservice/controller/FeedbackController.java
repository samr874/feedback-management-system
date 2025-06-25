package com.feedbackservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.feedbackservice.model.Feedback;
import com.feedbackservice.service.FeedbackService;

@RestController
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping("/createfeedback")
	public Feedback createFeedback(@RequestBody Feedback feedback)
	{
		return feedbackService.createFeedback(feedback);
		
	}
	
	@GetMapping("/gethistory/{empid}")
	public List<Feedback> history(@PathVariable long empid)
	{
		return feedbackService.history(empid);
		
		
	}
	
	@GetMapping("/viewcount")
	public Long viewCount()
	{
		return feedbackService.feedbackCount();
		
	}

	@DeleteMapping("/deletefeedback/{id}")
	public ResponseEntity<?> deleteFeedback(@PathVariable String id)
	{
		return feedbackService.deleteRecord(id);
		
		
	}
	
	@PatchMapping("/editfeedback/{id}")
	public ResponseEntity<Feedback> editFeedback(@PathVariable String id, @RequestBody Feedback feedback)
	{
		return feedbackService.editFeedback(id, feedback);
		
	}
}
