package com.multi.step.form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.multi.step.form.entities.Reply;
import com.multi.step.form.repository.ReplyRepository;

@Service
public class ReplyService {

	@Autowired
	private ReplyRepository replyRepository;
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #userId==authentication.name")
	public Reply saveReply(Reply reply, String userId) {
		return replyRepository.save(reply);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #userId==authentication.name")
	public Reply getSpecificReply(String id, String userId) {
		return replyRepository.getReplyByRequestId(id);
	}
}
