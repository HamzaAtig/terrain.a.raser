package com.hat.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.util.CollectionUtils;

import com.hat.data.Direction;
import com.hat.data.Lown;
import com.hat.data.Machine;
import com.hat.data.MovePossible;
import com.hat.data.Zone;

public class MowService implements Runnable {

	private Lown lown;

	private Machine machine;

	private boolean raseIfPossible(Lown terrain, Machine machine) {

		if (machine != null) {
			Zone zoneNext = getNextZone(machine, terrain);
			if (zoneNext != null) {
				zoneNext.setVisited(true);
				machine.getVisitedZones().add(zoneNext);
				return true;
			}
		}
		return false;
	}

	private Zone getNextZone(Machine machine, Lown lown) {
		List<Direction> directions = Arrays.asList(Direction.values());
		List<MovePossible> moves = new ArrayList<MovePossible>();
		for (Direction direction : directions) {
			moves.add(new MovePossible(direction));
		}

		Random random =new Random();
		Integer index = null;
		Direction direction = null;
		Zone zoneNext = null;
		Zone currentZone = machine.getVisitedZones().get(machine.getVisitedZones().size()-1);
		do{
			index = random.nextInt(directions.size());
			MovePossible move = moves.get(index);
			if(!move.isDone()){
				move.setDone(true);
			}
			direction = move.getDirection();
			Zone nextTemp = getNextZoneFromDirection(currentZone, lown, direction);
			
			if(nextTemp != null && nextTemp.isVisited()==false){
				zoneNext =nextTemp;
			}
			
		}while( (zoneNext == null && ! AllDone(moves)) || (zoneNext != null && zoneNext.isVisited()) );
		if(zoneNext==null){
			System.out.println();
		}
		return zoneNext;

	}

	private boolean AllDone(List<MovePossible> moves) {
		for (MovePossible move : moves) {
			if(!move.isDone())
				return false;
		}
		return true;
	}

	private Zone getNextZoneFromDirection(Zone currentZone, Lown lown,
			Direction direction) {
		Zone zone = null;
		if (Direction.DOWN.equals(direction)) {
			zone = getZoneFromLown(lown, currentZone.getX(),
					currentZone.getY() - 1);
		} else if (Direction.UP.equals(direction)) {
			zone = getZoneFromLown(lown, currentZone.getX(),
					currentZone.getY() + 1);
		} else if (Direction.LEFT.equals(direction)) {
			zone = getZoneFromLown(lown,
					currentZone.getX() - 1, currentZone.getY());
		} else if (Direction.RIGHT.equals(direction)) {
			zone = getZoneFromLown(lown,
					currentZone.getX() + 1, currentZone.getY());
		}

		return zone;
	}

	private Zone getZoneFromLown(Lown lown, Integer x, Integer y) {
		Zone zone = null;
		if (lown != null && !CollectionUtils.isEmpty(lown.getZonesMap())
				&& y >= 0 && x >= 0 && lown.getHeight() > y
				&& lown.getWidh() > x) {
			zone = lown.getZonesMap().get(x).get(y);
		}
		return zone;
	}

	@Override
	public void run() {
		boolean isPossible = raseIfPossible(lown, machine);
		while (isPossible) {
			isPossible = raseIfPossible(lown, machine);
		}

	}

	public Lown getTerrain() {
		return lown;
	}

	public void setTerrain(Lown terrain) {
		this.lown = terrain;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

}
