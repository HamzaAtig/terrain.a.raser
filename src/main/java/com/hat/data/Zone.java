package com.hat.data;

public class Zone {

	private Integer x;
	private Integer y;
	private boolean visited = false;

	public Zone() {
		super();
	}
	
	public Zone(Integer x, Integer y, boolean visited) {
		super();
		this.x = x;
		this.y = y;
		this.visited = visited;
	}

	@Override
	public String toString() {
		return "Zone [x=" + x + ", y=" + y + ", visited=" + visited + "]";
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

}
