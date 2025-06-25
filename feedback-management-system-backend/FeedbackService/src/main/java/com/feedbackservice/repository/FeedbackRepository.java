package com.feedbackservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.feedbackservice.model.Feedback;

@Repository
public interface FeedbackRepository extends MongoRepository<Feedback, String>{

	List<Feedback> findByEmpid(long empid);
	
	

}
