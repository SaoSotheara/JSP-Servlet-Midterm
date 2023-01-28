package com.itstep.htmltip.model;

public class Tip {
	private Integer id;
	private String title;
	private String description;
	private String exampleHtmlEscape;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getExampleHtmlEscape() {
		return exampleHtmlEscape;
	}
	public void setExampleHtmlEscape(String exampleHtmlEscape) {
		this.exampleHtmlEscape = exampleHtmlEscape;
	}
}
