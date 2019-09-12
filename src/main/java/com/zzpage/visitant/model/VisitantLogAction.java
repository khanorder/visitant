package com.zzpage.visitant.model;

public class VisitantLogAction {
	
	private Integer action_id;
	private String content;
	private String hash;
	private Integer type;
	
	public VisitantLogAction() {
	}

	public VisitantLogAction(String content, String hash, Integer type) {
		this.action_id = 0;
		this.content = content;
		this.hash = hash;
		this.type = type;
	}

	public Integer getAction_id() {
		return action_id;
	}

	public String getContent() {
		return content;
	}
	
	public String getHash() {
		return hash;
	}

	public Integer getType() {
		return type;
	}

	@Override
	public String toString() {
		return "VisitantLogAction [\n\taction_id=" + action_id + ", \n\tcontent=" + content + ", \n\thash=" + hash + ", \n\ttype="
				+ type + "\n]";
	}

}
