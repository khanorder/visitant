package com.zzpage.visitant.service;

import com.zzpage.visitant.map.VisitantMapper;
import com.zzpage.visitant.model.*;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class VisitantService {
	
	private static final Logger logger = LoggerFactory.getLogger(VisitantService.class);
	private final VisitantMapper visitantMapper;

	public VisitantService(VisitantMapper visitantMapper) {
		this.visitantMapper = visitantMapper;
	}

	public Integer insert(Visitant visitant) throws Exception {
		Visitant existVisitant = new Visitant();
		try {
			existVisitant = visitantMapper.getByHash(visitant);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		try {
			if (null == existVisitant || null == existVisitant.getVisitant_id() || null == existVisitant.getHash()) {
				visitantMapper.insert(visitant);
			} else {
				return existVisitant.getVisitant_id();
			}
		} catch (DuplicateKeyException e) {
			Pattern pattern = Pattern.compile("unq_hash");
			Matcher matcher = pattern.matcher(e.getMessage());
			if (matcher.find()) {
				logger.debug("Cannot inserts Duplicate 'unq_hash' key to database.");
			} else {
				logger.error(e.getMessage(), e);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null == visitant.getVisitant_id() ? 0 : visitant.getVisitant_id();
	}
	
	public Integer insertLogAction(VisitantRequest visitantRequest, Integer type) throws Exception {
		if (null == type) return null;
		String content = "";
		String hash = "";
		if (type == 1) {
			content = visitantRequest.getUrl();
			hash = visitantRequest.getUrl_hash();
		} else if (type == 5) {
			content = visitantRequest.getTitle();
			hash = visitantRequest.getTitle_hash();
		} else {
			return null;
		}
		VisitantLogAction visitantLogAction = new VisitantLogAction(content, hash, type);
		VisitantLogAction existLogAction = new VisitantLogAction();
		try {
			existLogAction = visitantMapper.getLogAction(visitantLogAction);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		try {
			if (null == existLogAction || null == existLogAction.getAction_id() || null == existLogAction.getHash()) {
				visitantMapper.insertLogAction(visitantLogAction);
			} else {
				return existLogAction.getAction_id();
			}
		} catch (DuplicateKeyException e) {
			Pattern pattern = Pattern.compile("unq_hash_type");
			Matcher matcher = pattern.matcher(e.getMessage());
			if (matcher.find()) {
				logger.debug("Cannot inserts Duplicate 'unq_hash_type' key to database.");
			} else {
				logger.error(e.getMessage(), e);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null == visitantLogAction.getAction_id() ? 0 : visitantLogAction.getAction_id();
	}
	
	public Integer insertLogVisit(VisitantLogVisit visitantLogVisit) throws Exception {
		VisitantLogVisit existVisit = new VisitantLogVisit();
		try {
			existVisit = visitantMapper.getLogVisitOneday(visitantLogVisit);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		try {
			if (null == existVisit || null == existVisit.getVisit_id() || null == existVisit.getVisitant_id()) {
				visitantMapper.insertLogVisit(visitantLogVisit);
			} else {
				return existVisit.getVisit_id();
			}
		} catch (DuplicateKeyException e) {
			Pattern pattern = Pattern.compile("unq_visitant_id_visit_date");
			Matcher matcher = pattern.matcher(e.getMessage());
			if (matcher.find()) {
				logger.debug("Cannot inserts Duplicate 'unq_visitant_id_visit_date' key to database.");
			} else {
				logger.error(e.getMessage(), e);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null == visitantLogVisit.getVisit_id() ? 0 : visitantLogVisit.getVisit_id();
	}
	
	public Integer insertLogView(VisitantLogView visitantLogView) throws Exception {
		Integer isTracked = 0;
		try {
			Long trackedTime = (long) visitantLogView.getServer_time().getTime();
			Date forCheckTime = new Date(trackedTime - 60000);
			isTracked = visitantMapper.getIsTrackedLogView(visitantLogView.getVisit_id(), visitantLogView.getUrl_action_id(), forCheckTime);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		if (isTracked == 0) {
			try {
				visitantMapper.insertLogView(visitantLogView);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		return null == visitantLogView.getView_id() ? 0 : visitantLogView.getView_id();
	}

}
