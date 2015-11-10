package com.hat.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.hat.data.Machine;
import com.hat.data.Lown;
import com.hat.data.Zone;

@Component
public class DataGenerator {

	public List<Machine> createMachines(Integer n) {
		if (n > 0) {
			List<Machine> machines = new ArrayList<Machine>();
			for (int i = 0; i < n; i++) {
				Machine machine = new Machine();
				machine.setId("machineId" + i);
				machines.add(machine);
			}
			return machines;
		} else {
			return null;
		}
	}

	public Lown createLown(Integer x, Integer y) {
		if (x > 0 && y > 0) {
			Lown lown = new Lown();
			lown.setWidh(x);
			lown.setHeight(y);
			Map<Integer, Map<Integer, Zone>> zonesMap = new HashMap<Integer, Map<Integer, Zone>>();
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					Map<Integer, Zone> map = zonesMap.get(i);
					if (map == null) {
						map = new HashMap<Integer, Zone>();
					}
					map.put(j, new Zone(i, j, false));
					zonesMap.put(i, map);
				}
			}
			lown.setZonesMap(zonesMap);
			return lown;
		} else {
			return null;
		}
	}

	public void initiateMachinesDepartPoint(List<Machine> machines, Lown lown, Integer widh, Integer height) {
		Random random = new Random();
		Integer x;
		Integer y;
		for (Machine machine : machines) {
			Zone zone = null;
			do  {
				x = random.nextInt(widh);
				y = random.nextInt(height);
				zone = lown.getZonesMap().get(x).get(y);
			}while(zone.isVisited());
			
			zone.setVisited(true);
			machine.getVisitedZones().add(zone);
		}
	}

}
