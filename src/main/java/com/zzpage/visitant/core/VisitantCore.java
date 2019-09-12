package com.zzpage.visitant.core;

import com.zzpage.visitant.model.Visitant;
import com.zzpage.visitant.model.VisitantRequest;
import com.zzpage.visitant.model.VisitantRequestUserAgent;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class VisitantCore {

	private static final Logger logger = LoggerFactory.getLogger(VisitantCore.class);
	
	public static VisitantRequest initVisitantRequest(VisitantRequest visitantRequest, String remoteAddr) {
		VisitantRequest newVisitantRequest = new VisitantRequest();
		if (
			null == visitantRequest || null == visitantRequest.getUrl() || StringUtils.isBlank(visitantRequest.getUrl())
			|| null == visitantRequest.getTitle() || StringUtils.isBlank(visitantRequest.getTitle())
		) {
			return newVisitantRequest;
		}
		String remoteAddrHash = DigestUtils.sha1Hex(remoteAddr);
		String urlHash = DigestUtils.sha1Hex(visitantRequest.getUrl());
		String titleHash = DigestUtils.sha1Hex(visitantRequest.getTitle());
		/*String[] decodedParameterArray = new String[] {};
		try {
			if (null != visitantRequest.getParameter() && !StringUtils.isBlank(visitantRequest.getParameter())) {
				decodedParameterArray = URLDecoder.decode(visitantRequest.getParameter().replaceFirst("^\\?", ""), "UTF-8").split("\\&");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return newVisitantRequest;
		}
		String forVerifyParameter = "";
		if (decodedParameterArray.length > 0) {
			for (String decodedParameter : decodedParameterArray) {
				String[] decParamKeyAndVal = decodedParameter.split("=");
				String verifyedEncKey = "";
				String verifyedEncValue = "";
				if (decParamKeyAndVal.length > 0 && null != decParamKeyAndVal[0] && !StringUtils.isBlank(decParamKeyAndVal[0])) {
					try {
						verifyedEncKey = URLEncoder.encode(decParamKeyAndVal[0], "UTF-8");
					} catch (Exception e) {
						logger.error(e.getMessage(), e);
						return newVisitantRequest;
					}
				}
				if (decParamKeyAndVal.length > 1 && null != decParamKeyAndVal[1]) {
					try {
						verifyedEncValue = URLEncoder.encode(decParamKeyAndVal[1], "UTF-8");
					} catch (Exception e) {
						logger.error(e.getMessage(), e);
						return newVisitantRequest;
					}
				}
				if (!StringUtils.isBlank(verifyedEncKey)) {
					try {
						forVerifyParameter+= (StringUtils.isBlank(forVerifyParameter) ? "" : "&") + verifyedEncKey + "=" + (StringUtils.isBlank(verifyedEncValue) ? "" : verifyedEncValue);
					} catch (Exception e) {
						logger.error(e.getMessage(), e);
					}
				}
				decParamKeyAndVal = null;
				verifyedEncKey = null;
				verifyedEncValue = null;
				decodedParameter = null;
			}
			forVerifyParameter = (StringUtils.isBlank(forVerifyParameter)) ? "" : "?" + forVerifyParameter;
		}
		String forVerifyUrl = visitantRequest.getProtocol() + "://" + visitantRequest.getHost() + ("80".equals(visitantRequest.getPort()) || "".equals(visitantRequest.getPort()) ? "" : ":" + visitantRequest.getPort()) + visitantRequest.getPath() + forVerifyParameter;
		if (!forVerifyUrl.equals(visitantRequest.getUrl().replaceFirst("[\\?\\=]$", ""))) {
			Throwable urlException = new UnsutalbleUrlVisitantException("original: " + visitantRequest.getUrl() + "\nverifyed: " + forVerifyUrl + "\nparameters: " + Arrays.asList(decodedParameterArray).toString());
			logger.error(urlException.getMessage(), urlException);
		}
		decodedParameterArray = null;
		forVerifyParameter = null;
		forVerifyUrl = null;*/
		newVisitantRequest = new VisitantRequest(
			visitantRequest.getHash(), visitantRequest.getUserAgent(), visitantRequest.getLanguage(), visitantRequest.getTimezone(), 
			visitantRequest.getTimezoneOffset(), visitantRequest.getPlatform(), visitantRequest.getScreenResolution(), 
			visitantRequest.getAvailableScreenResolution(), visitantRequest.getWebglVendorAndRenderer(), visitantRequest.getTitle(), 
			titleHash, visitantRequest.getUrl(), urlHash, visitantRequest.getProtocol(), visitantRequest.getHost(), 
			visitantRequest.getPort(), visitantRequest.getPath(), visitantRequest.getParameter(), visitantRequest.getLocal_time(), remoteAddrHash
		);
		return newVisitantRequest;
	}
	
	public static Visitant setVisitant(VisitantRequest visitantRequest) {
		Visitant visitant = new Visitant();
		if (null != visitantRequest.getHash() || !StringUtils.isBlank(visitantRequest.getHash())) {
			String ua = "";
			String browserName = "";
			String browserVersion = "";
			String engineName = "";
			String engineVersion = "";
			String osName = "";
			String osVersion = "";
			String deviceVendor = "";
			String deviceModel = "";
			int deviceType = 0;
			Integer screenResolutionX = 0;
			Integer screenResolutionY = 0;
			try {
				VisitantRequestUserAgent userAgent = visitantRequest.getUserAgent();
				ua = null != userAgent.getUa() ? userAgent.getUa() : "";
				if (null != userAgent.getBrowser()) {
					Map<String, String> browser = userAgent.getBrowser();
					browserName = (!browser.containsKey("name") || StringUtils.isBlank(browser.get("name"))) ? "" : browser.get("name");
					browserVersion = (!browser.containsKey("version") || StringUtils.isBlank(browser.get("version"))) ? "" : browser.get("version");
				}
				if (null != userAgent.getEngine()) {
					Map<String, String> engine = userAgent.getEngine();
					engineName = (!engine.containsKey("name") || StringUtils.isBlank(engine.get("name"))) ? "" : engine.get("name");
					engineVersion = (!engine.containsKey("version") || StringUtils.isBlank(engine.get("version"))) ? "" : engine.get("version");
				}
				if (null != userAgent.getOs()) {
					Map<String, String> os = userAgent.getOs();
					osName = (!os.containsKey("name") || StringUtils.isBlank(os.get("name"))) ? "" : os.get("name");
					osVersion = (!os.containsKey("version") || StringUtils.isBlank(os.get("version"))) ? "" : os.get("version");
				}
				if (null != userAgent.getDevice()) {
					Map<String, String> device = userAgent.getDevice();
					deviceVendor = (!device.containsKey("vendor") || StringUtils.isBlank(device.get("vendor"))) ? "" : device.get("vendor");
					deviceModel = (!device.containsKey("model") || StringUtils.isBlank(device.get("model"))) ? "" : device.get("model");
					if ((!device.containsKey("type") || StringUtils.isBlank(device.get("type")))) {
						deviceType = 0;
					} else {
						deviceType = "mobile".equals(device.get("type")) ? 1 : 0;
					}
				}
				if (null != visitantRequest.getScreenResolution()) {
					List<Integer> screen_resolution = visitantRequest.getScreenResolution();
					if (screen_resolution.size() > 0) screenResolutionX = screen_resolution.get(0);
					if (screen_resolution.size() > 1) screenResolutionY = screen_resolution.get(1);
				}
				visitant = new Visitant(
					visitantRequest.getHash(), ua, browserName, browserVersion, engineName, 
					engineVersion, osName, osVersion, deviceVendor, deviceModel, deviceType, 
					visitantRequest.getLanguage(), visitantRequest.getTimezone(), 
					visitantRequest.getTimezoneOffset(), visitantRequest.getPlatform(), 
					screenResolutionX, screenResolutionY, visitantRequest.getWebglVendorAndRenderer(), 
					visitantRequest.getRemote_addr_hash()
				);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		return visitant;
	}

}
