package com.zzpage.visitant.controller;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzpage.visitant.core.HTMLCharacterEscapes;
import com.zzpage.visitant.core.VisitantCore;
import com.zzpage.visitant.model.Visitant;
import com.zzpage.visitant.model.VisitantLogView;
import com.zzpage.visitant.model.VisitantLogVisit;
import com.zzpage.visitant.model.VisitantRequest;
import com.zzpage.visitant.service.VisitantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class VisitantLogging {

	private static final Logger logger = LoggerFactory.getLogger(VisitantLogging.class);
	private final VisitantService visitantService;

	public VisitantLogging(VisitantService visitantService) {
		this.visitantService = visitantService;
	}

	@RequestMapping(value = "/visitant.do")
	public String visitant(HttpServletRequest request) throws Exception {
		return "visitant";
	}

	@RequestMapping(value = "/log.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String log(HttpServletRequest request) throws Exception {
		Map<String, Object> resultJson = new HashMap<String, Object>();
		resultJson.put("result", false);
		ObjectMapper requestMapper = new ObjectMapper();
		VisitantRequest visitantRequest = new VisitantRequest();
		try {
			visitantRequest = requestMapper.readValue(request.getParameter("visitant"), VisitantRequest.class);
			visitantRequest = VisitantCore.initVisitantRequest(visitantRequest, request.getRemoteAddr());
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return encodeJson(resultJson);
		}
		String fullHost = visitantRequest.getHost() + ("80".equals(visitantRequest.getPort()) || "".equals(visitantRequest.getPort()) ? "" : ":" + visitantRequest.getPort());
		Visitant visitant = VisitantCore.setVisitant(visitantRequest);
		if (null == visitant.getHash()) return encodeJson(resultJson);
		Integer visitantId = visitantService.insert(visitant);
		Integer urlLogActionId = visitantService.insertLogAction(visitantRequest, 1);
		Integer titleLogActionId = visitantService.insertLogAction(visitantRequest, 5);
		Date trackedDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String trackedDateStr = dateFormat.format(trackedDate);
		Date trackedMidnightDate = null;
		try {
			trackedMidnightDate = dateFormat.parse(trackedDateStr);
		} catch (ParseException e) {
			logger.debug(e.getMessage());
			return encodeJson(resultJson);
		}
		VisitantLogVisit visitantLogVisit = new VisitantLogVisit(visitantId, trackedMidnightDate);
		Integer logVisitId = visitantService.insertLogVisit(visitantLogVisit);
		VisitantLogView visitantLogView = new VisitantLogView(
				logVisitId, titleLogActionId, urlLogActionId,
				trackedDate, visitantRequest.getLocal_time()
		);
		Integer result = visitantService.insertLogView(visitantLogView);
		if (result > 0) {
			resultJson.put("result", true);
			logger.debug("succeed log.");
		} else {
			logger.debug("didn't logged.");
		}
		String json = "{}";
		json = encodeJson(resultJson);
		return json;
	}

	private String encodeJson (Object obj) throws Exception {
		String json = "{}";
		JsonFactory json_factory = new JsonFactory();
		json_factory.setCharacterEscapes(new HTMLCharacterEscapes());
		ObjectMapper mapper = new ObjectMapper(json_factory);
		try {
			json = mapper.writeValueAsString(obj);
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return json;
	}

}
