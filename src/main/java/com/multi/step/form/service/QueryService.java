package com.multi.step.form.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.multi.step.form.entities.Query;
import com.multi.step.form.repository.QueryRepository;

@Service
public class QueryService {

	@Autowired
	private QueryRepository queryRepository;
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #query.getUserId()==authentication.name")
	public Query saveQuery(Query query) {
		return queryRepository.save(query);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #userId==authentication.name")
	public List<Query> getAllQueryByUserId(String userId){
		return queryRepository.findAllQueryByUserId(userId);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #userId==authentication.name")
	public Query getQueryByAction(String action, String userId) {
		return queryRepository.findQueryByAction(action);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #userId==authentication.name")
	public Query getQuerByReqId(String id, String userId) {
		return queryRepository.findQueryById(id);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #userId==authentication.name")
	public void changeAction(String reqId,Date queryTime, String userId) {
		
		Date currentTime = new Date();
		
		long timeDifference = currentTime.getTime() - queryTime.getTime();
		if(timeDifference/(60 * 1000)>=30) {
			Query query = this.getQuerByReqId(reqId, userId);
			query.setAction("In-Progress");
			this.saveQuery(query);
		}
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #userId==authentication.name")
	@SuppressWarnings("deprecation")
	public String getDate(String userId) {
		Date date = new Date();
		
		int cdate = date.getDate();
        int month = date.getMonth() + 1;
        int year = date.getYear() + 1900;
		
		String cmonth = "";
		
		switch(month) {
			case 1 : 	cmonth = "Jan";
						break;
						
			case 2 :	cmonth = "Feb";
						break;
						
			case 3 :	cmonth = "Mar";
						break;
						
			case 4 :	cmonth = "Apr";
						break;
						
			case 5 :	cmonth = "May";
						break;
						
			case 6 :	cmonth = "June";
						break;
						
			case 7 :	cmonth = "July";
						break;
						
			case 8 :	cmonth = "Aug";
						break;
						
			case 9 :	cmonth = "Sept";
						break;
						
			case 10 :	cmonth = "Oct";
						break;
						
			case 11 :	cmonth = "Nov";
						break;
						
			case 12 :	cmonth = "Dec";
						break;
		}
		
		String queryDate = cdate + " " + cmonth + " " + year;
		
		return queryDate;
	}
}
