package com.senyint.common.util;

import java.util.HashMap;

import org.dom4j.Element;

/**
 * Object escapsulates request parameters
 * 
 * @author milei
 * 
 */
public class Command extends HashMap {
	/** 命令名 */
	private String name;
	private Element data;

	public Command(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getParameter(String paramName) {
		return get(paramName);
	}

	public void putParameter(String paraName, Object paramValue) {
		put(paraName, paramValue);
	}

	public Element getData() {
		return data;
	}

	public void setData(Element data) {
		this.data = data;
	}

}
