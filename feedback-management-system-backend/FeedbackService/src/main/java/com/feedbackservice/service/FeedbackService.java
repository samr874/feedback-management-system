package com.feedbackservice.service;

import java.io.ObjectInputFilter.Status;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.feedbackservice.model.Feedback;
import com.feedbackservice.repository.FeedbackRepository;

@Service
public class FeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepo;

	public Feedback createFeedback(Feedback feedback) {
		return feedbackRepo.save(feedback);

	}

	public List<Feedback> history(long empid) {
		return feedbackRepo.findByEmpid(empid);

	}

	public long feedbackCount() {
		return feedbackRepo.count();

	}

	// Delete feedbacks
	public ResponseEntity<?> deleteRecord(String id) {
		feedbackRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);

	}

	// Edit
	public ResponseEntity<Feedback> editFeedback(String id, Feedback modifiedFeedback) {
		feedbackRepo.findById(id).map((feedback) -> {

			feedback.setStrength(modifiedFeedback.getStrength());
			feedback.setAreasToImprove(modifiedFeedback.getAreasToImprove());
			feedback.setSentiment(modifiedFeedback.getSentiment());
			return feedbackRepo.save(feedback);

		}).orElseGet(() -> feedbackRepo.save(modifiedFeedback));
		
		return new ResponseEntity<Feedback>(HttpStatus.ACCEPTED);
		

	}

}
