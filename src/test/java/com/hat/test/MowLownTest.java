package com.hat.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.hat.data.Machine;
import com.hat.service.MowLown;
import com.hat.service.MowService;
import com.hat.util.DataGenerator;

public class MowLownTest {

	public final static Logger logger = Logger.getLogger(MowLownTest.class);

	private ClassPathXmlApplicationContext context;

	private MowLown mowLown;

	private DataGenerator dataGenerator;
	
	private Integer machineNumber ;

	@Before
	public void before() throws Exception {

		context = new ClassPathXmlApplicationContext(new ClassPathResource(
				"spring-config.xml").getPath());

		mowLown = context.getBean(MowLown.class);

		dataGenerator = context.getBean(DataGenerator.class);
		
		machineNumber = context.getBean(Integer.class);
		

	}

	@Test
	public void MowTest() {

		List<Machine> machines = dataGenerator.createMachines(machineNumber);
		mowLown.setTerrain(dataGenerator.createLown(mowLown.getWidh(),
				mowLown.getHeight()));
		dataGenerator.initiateMachinesDepartPoint(machines,
				mowLown.getTerrain(), mowLown.getWidh(), mowLown.getHeight());
		List<MowService> raserServices = new ArrayList<MowService>();
		List<Thread> threads = startRazer(machines, mowLown, raserServices);

		waitWhileMachinStillRunning(threads);

		for (MowService item : raserServices) {
			logger.info(item.getMachine().getId() + " raze "
					+ item.getMachine().getVisitedZones().size() + " items.");
			logger.info(item.getMachine());
		}
	}

	@After
	public void after() throws Exception {
		context.close();
	}

	public void waitWhileMachinStillRunning(List<Thread> threads) {
		int running = 0;
		do {
			running = 0;
			for (Thread thread : threads) {
				if (thread.isAlive()) {
					running++;
				}
			}
		} while (running > 0);
	}

	public List<Thread> startRazer(List<Machine> machines, MowLown main,
			List<MowService> raserServices) {
		List<Thread> threads = new ArrayList<Thread>();
		for (Machine machine : machines) {
			MowService raser = new MowService();
			raser.setMachine(machine);
			raser.setTerrain(main.getTerrain());
			Thread thread = new Thread(raser);
			thread.start();
			raserServices.add(raser);
			threads.add(thread);
		}
		return threads;
	}
}
