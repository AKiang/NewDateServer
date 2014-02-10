package com.soryin.vo;

import java.io.Serializable;

/**
 * @author donghai
 *
 */
public class UserSettingVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String language;
	private String fontSize;
	private String dateFormat;
	private String associatedInfo;
	private String hotspor;
	private String tag;
	public String getAssociatedInfo() {
		return associatedInfo;
	}
	public String getDateFormat() {
		return dateFormat;
	}
	public String getFontSize() {
		return fontSize;
	}
	public String getHotspor() {
		return hotspor;
	}
	public String getLanguage() {
		return language;
	}
	public String getTag() {
		return tag;
	}
	public void setAssociatedInfo(String associatedInfo) {
		this.associatedInfo = associatedInfo;
	}
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}
	public void setHotspor(String hotspor) {
		this.hotspor = hotspor;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
}
