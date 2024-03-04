package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import com.google.common.collect.Table; 
import com.google.common.collect.TreeBasedTable;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;
	private Table<String, Integer, Integer> Tachograf = TreeBasedTable.create();

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
	}

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}

	@Override
	public void overrideSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);
	}

	public void setTach(String time, Integer js, Integer rs) {
		Tachograf.put(time, js, rs);
	}

	public boolean getTach(String time, Integer js, Integer rs) {
		System.out.println(time);
		System.out.println(js);
		System.out.println(rs);
		System.out.println(Tachograf.containsRow(time));
		return Tachograf.containsRow(time);
	}

}
