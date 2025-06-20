package com.multi.step.form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.step.form.entities.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, String> {
	
	public Reply getReplyByRequestId(String id);
}
