package com.zzpage.visitant.model;

import java.util.Date;

public class VisitantLogVisit {
	
	private Integer visit_id;
	private Integer visitant_id;
	private Date visit_date;
	
	public VisitantLogVisit() {
	}

	public VisitantLogVisit(Integer visitant_id, Date visit_date) {
		this.visit_id = 0;
		this.visitant_id = visitant_id;
		this.visit_date = visit_date;
	}

	public Integer getVisit_id() {
		return visit_id;
	}

	public Integer getVisitant_id() {
		return visitant_id;
	}

	public Date getVisit_date() {
		return visit_date;
	}

	@Override
	public String toString() {
		return "VisitantLogVisit [\n\tvisit_id=" + visit_id + ", \n\tvisitant_id=" + visitant_id + ", \n\tvisit_date="
				+ visit_date + "\n]";
	}

}
