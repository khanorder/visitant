package com.zzpage.visitant.model;

public class Visitant {
	
	private Integer visitant_id;
	private String hash;
	private String user_agent;
	private String browser;
	private String browser_version;
	private String engine;
	private String engine_version;
	private String os;
	private String os_version;
	private String device_vendor;
	private String device_model;
	private Integer device_type;
	private String language;
	private String timezone;
	private Integer timezone_offset;
	private String platform;
	private Integer screen_resolution_x;
	private Integer screen_resolution_y;
	private String webgl_vendor_and_renderer;
	private String remote_addr_hash;
	
	public Visitant() {
	}

	public Visitant(String hash, String user_agent, String browser, String browser_version,
			String engine, String engine_version, String os, String os_version, String device_vendor,
			String device_model, Integer device_type, String language, String timezone, Integer timezone_offset,
			String platform, Integer screen_resolution_x, Integer screen_resolution_y, String webgl_vendor_and_renderer,
			String remote_addr_hash) {
		this.visitant_id = 0;
		this.hash = hash;
		this.user_agent = user_agent;
		this.browser = browser;
		this.browser_version = browser_version;
		this.engine = engine;
		this.engine_version = engine_version;
		this.os = os;
		this.os_version = os_version;
		this.device_vendor = device_vendor;
		this.device_model = device_model;
		this.device_type = device_type;
		this.language = language;
		this.timezone = timezone;
		this.timezone_offset = timezone_offset;
		this.platform = platform;
		this.screen_resolution_x = screen_resolution_x;
		this.screen_resolution_y = screen_resolution_y;
		this.webgl_vendor_and_renderer = webgl_vendor_and_renderer;
		this.remote_addr_hash = remote_addr_hash;
	}

	public Integer getVisitant_id() {
		return visitant_id;
	}

	public String getHash() {
		return hash;
	}

	public String getUser_agent() {
		return user_agent;
	}

	public String getBrowser() {
		return browser;
	}

	public String getBrowser_version() {
		return browser_version;
	}

	public String getEngine() {
		return engine;
	}

	public String getEngine_version() {
		return engine_version;
	}

	public String getOs() {
		return os;
	}

	public String getOs_version() {
		return os_version;
	}

	public String getDevice_vendor() {
		return device_vendor;
	}

	public String getDevice_model() {
		return device_model;
	}

	public Integer getDevice_type() {
		return device_type;
	}

	public String getLanguage() {
		return language;
	}

	public String getTimezone() {
		return timezone;
	}

	public Integer getTimezone_offset() {
		return timezone_offset;
	}

	public String getPlatform() {
		return platform;
	}

	public Integer getScreen_resolution_x() {
		return screen_resolution_x;
	}

	public Integer getScreen_resolution_y() {
		return screen_resolution_y;
	}

	public String getWebgl_vendor_and_renderer() {
		return webgl_vendor_and_renderer;
	}
	
	public String getRemote_addr_hash() {
		return remote_addr_hash;
	}

	@Override
	public String toString() {
		return "Visitant [\n\tvisitant_id=" + visitant_id + ", \n\thash=" + hash + ", \n\tuser_agent=" + user_agent
				+ ", \n\tbrowser=" + browser + ", \n\tbrowser_version=" + browser_version + ", \n\tengine=" + engine
				+ ", \n\tengine_version=" + engine_version + ", \n\tos=" + os + ", \n\tos_version=" + os_version
				+ ", \n\tdevice_vendor=" + device_vendor + ", \n\tdevice_model=" + device_model + ", \n\tdevice_type="
				+ device_type + ", \n\tlanguage=" + language + ", \n\ttimezone=" + timezone + ", \n\ttimezone_offset="
				+ timezone_offset + ", \n\tplatform=" + platform + ", \n\tscreen_resolution_x=" + screen_resolution_x
				+ ", \n\tscreen_resolution_y=" + screen_resolution_y + ", \n\twebgl_vendor_and_renderer="
				+ webgl_vendor_and_renderer + ", \n\tremote_addr_hash=" + remote_addr_hash + "\n]";
	}

}
