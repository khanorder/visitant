package com.zzpage.visitant.model;

import java.util.Map;

public class VisitantRequestUserAgent {
	
	private String ua;
	private Map<String, String> browser;
	private Map<String, String> engine;
	private Map<String, String> os;
	private Map<String, String> device;
	private Map<String, String> cpu;
	
	public VisitantRequestUserAgent() {
	}

	public VisitantRequestUserAgent(String ua, Map<String, String> browser, Map<String, String> engine, Map<String, String> os,
			Map<String, String> device, Map<String, String> cpu) {
		this.ua = ua;
		this.browser = browser;
		this.engine = engine;
		this.os = os;
		this.device = device;
		this.cpu = cpu;
	}

	public String getUa() {
		return ua;
	}

	public Map<String, String> getBrowser() {
		return browser;
	}

	public Map<String, String> getEngine() {
		return engine;
	}

	public Map<String, String> getOs() {
		return os;
	}

	public Map<String, String> getDevice() {
		return device;
	}
	
	public Map<String, String> getCpu() {
		return cpu;
	}

	@Override
	public String toString() {
		return "VisitantUserAgent [\n\tua=" + ua + ", \n\tbrowser=" + browser + ", \n\tengine=" + engine + ", \n\tos="
				+ os + ", \n\tdevice=" + device + ", \n\tcpu=" + cpu + "\n]";
	}

}
