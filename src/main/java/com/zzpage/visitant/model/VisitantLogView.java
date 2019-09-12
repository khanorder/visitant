package com.zzpage.visitant.model;

import java.util.Date;

public class VisitantLogView {
	
	private Integer view_id;
	private Integer visit_id;
	private Integer title_action_id;
	private Integer url_action_id;
	private Date server_time;
	private Date local_time;
	
	public VisitantLogView() {
	}

	public VisitantLogView(Integer visit_id, Integer title_action_id, 
			Integer url_action_id, Date server_time, Date local_time) {
		this.view_id = 0;
		this.visit_id = visit_id;
		this.title_action_id = title_action_id;
		this.url_action_id = url_action_id;
		this.server_time = server_time;
		this.local_time = local_time;
	}

	public Integer getView_id() {
		return view_id;
	}

	public Integer getVisit_id() {
		return visit_id;
	}

	public Integer getTitle_action_id() {
		return title_action_id;
	}

	public Integer getUrl_action_id() {
		return url_action_id;
	}

	public Date getServer_time() {
		return server_time;
	}

	public Date getLocal_time() {
		return local_time;
	}

	@Override
	public String toString() {
		return "VisitantLogView [\n\tview_id=" + view_id + ", \n\tvisit_id=" + visit_id + ", \n\ttitle_action_id="
				+ title_action_id + ", \n\turl_action_id=" + url_action_id + ", \n\tserver_time=" + server_time
				+ ", \n\tlocal_time=" + local_time + "\n]";
	}

}
