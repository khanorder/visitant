package com.zzpage.visitant.model;

import java.util.Date;
import java.util.List;

public class VisitantRequest {
	
	private String hash;
	private VisitantRequestUserAgent userAgent;
	private String language;
	private String timezone;
	private Integer timezoneOffset;
	private String platform;
	private List<Integer> screenResolution;
	private List<Integer> availableScreenResolution;
	private String webglVendorAndRenderer;
	private String title;
	private String title_hash;
	private String url;
	private String url_hash;
	private String protocol;
	private String host;
	private String port;
	private String path;
	private String parameter;
	private Date local_time;
	private String remote_addr_hash;
	
	public VisitantRequest() {
	}

	public VisitantRequest(String hash, VisitantRequestUserAgent userAgent, String language, String timezone,
			Integer timezoneOffset, String platform, List<Integer> screenResolution,
			List<Integer> availableScreenResolution, String webglVendorAndRenderer, String title, String title_hash,
			String url, String url_hash, String protocol, String host, String port, String path, String parameter,
			Date local_time, String remote_addr_hash) {
		this.hash = hash;
		this.userAgent = userAgent;
		this.language = language;
		this.timezone = timezone;
		this.timezoneOffset = timezoneOffset;
		this.platform = platform;
		this.screenResolution = screenResolution;
		this.availableScreenResolution = availableScreenResolution;
		this.webglVendorAndRenderer = webglVendorAndRenderer;
		this.title = title;
		this.title_hash = title_hash;
		this.url = url;
		this.url_hash = url_hash;
		this.protocol = protocol;
		this.host = host;
		this.port = port;
		this.path = path;
		this.parameter = parameter;
		this.local_time = local_time;
		this.remote_addr_hash = remote_addr_hash;
	}

	public String getHash() {
		return hash;
	}

	public VisitantRequestUserAgent getUserAgent() {
		return userAgent;
	}

	public String getLanguage() {
		return language;
	}

	public String getTimezone() {
		return timezone;
	}

	public Integer getTimezoneOffset() {
		return timezoneOffset;
	}

	public String getPlatform() {
		return platform;
	}

	public List<Integer> getScreenResolution() {
		return screenResolution;
	}

	public List<Integer> getAvailableScreenResolution() {
		return availableScreenResolution;
	}

	public String getWebglVendorAndRenderer() {
		return webglVendorAndRenderer;
	}

	public String getTitle() {
		return title;
	}

	public String getTitle_hash() {
		return title_hash;
	}

	public String getUrl() {
		return url;
	}

	public String getUrl_hash() {
		return url_hash;
	}

	public String getProtocol() {
		return protocol;
	}
	
	public String getHost() {
		return host;
	}

	public String getPort() {
		return port;
	}

	public String getPath() {
		return path;
	}

	public String getParameter() {
		return parameter;
	}

	public Date getLocal_time() {
		return local_time;
	}
	
	public String getRemote_addr_hash() {
		return remote_addr_hash;
	}

	@Override
	public String toString() {
		return "VisitantRequest [\n\thash=" + hash + ", \n\tuserAgent=" + userAgent + ", \n\tlanguage=" + language
				+ ", \n\ttimezone=" + timezone + ", \n\ttimezoneOffset=" + timezoneOffset + ", \n\tplatform=" + platform
				+ ", \n\tscreenResolution=" + screenResolution + ", \n\tavailableScreenResolution="
				+ availableScreenResolution + ", \n\twebglVendorAndRenderer=" + webglVendorAndRenderer + ", \n\ttitle="
				+ title + ", \n\ttitle_hash=" + title_hash + ", \n\turl=" + url + ", \n\turl_hash=" + url_hash
				+ ", \n\tprotocol=" + protocol + ", \n\thost=" + host + ", \n\tport=" + port + ", \n\tpath=" + path
				+ ", \n\tparameter=" + parameter + ", \n\tlocal_time=" + local_time + ", \n\tremote_addr_hash="
				+ remote_addr_hash + "\n]";
	}

}
