package com.hat.data;

public class MovePossible {

	private Direction direction;

	private boolean done = false;
	
	public MovePossible() {
		super();
		
	}

	public MovePossible(Direction direction) {
		super();
		this.direction = direction;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

}
