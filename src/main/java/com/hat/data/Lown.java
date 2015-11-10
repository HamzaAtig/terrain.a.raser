package com.hat.data;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Lown {

	private Map<Integer,Map<Integer, Zone>> zonesMap;
	
	private Integer widh;
	
	private Integer height ;


	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWidh() {
		return widh;
	}

	public void setWidh(Integer widh) {
		this.widh = widh;
	}

	synchronized public Map<Integer,Map<Integer, Zone>> getZonesMap() {
		return zonesMap;
	}

	public void setZonesMap(Map<Integer,Map<Integer, Zone>> zonesMap) {
		this.zonesMap = zonesMap;
	}
}
