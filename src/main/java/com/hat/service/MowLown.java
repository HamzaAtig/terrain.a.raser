package com.hat.service;

import com.hat.data.Lown;

public class MowLown {

	
	private Integer widh ;
	private Integer height ;
	
	private Lown terrain;
	
	public MowLown() {
		super();
	}

	public MowLown(Integer widh, Integer height) {
		super();
		this.widh = widh;
		this.height = height;
	}


	public synchronized Lown getTerrain() {
		return terrain;
	}

	public void setTerrain(Lown terrain) {
		this.terrain = terrain;
	}


	public Integer getWidh() {
		return widh;
	}


	public void setWidh(Integer widh) {
		this.widh = widh;
	}


	public Integer getHeight() {
		return height;
	}


	public void setHeight(Integer height) {
		this.height = height;
	}

}
