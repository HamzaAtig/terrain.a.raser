package com.hat.data;

import java.util.ArrayList;
import java.util.List;

public class Machine {

	private String id;

	private List<Zone> visitedZones = new ArrayList<Zone>();
	

	public Machine() {
		super();
	}
	public Machine(String id, List<Zone> visitedZones) {
		super();
		this.id = id;
		this.visitedZones = visitedZones;
	}

	@Override
	public String toString() {
		return "Machine [id=" + id + ", visitedZones=" + visitedZones + "]";
	}

	public List<Zone> getVisitedZones() {
		return visitedZones;
	}

	public void setVisitedZones(List<Zone> visitedZones) {
		this.visitedZones = visitedZones;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
