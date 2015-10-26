package es.deusto.ingenieria.ssdd.tracker.model;

import java.util.List;
import java.util.Observer;

public class TrackerRedundancyManager {

	private List<Observer> observers;

	public void addObserver(Observer o) {

	}

	public void deleteObserver(Observer o) {
		this.observers.remove(o);
	}

	private void notifyObservers(Object param) {
		for (Observer o : this.observers) {
			if (o != null) {
				o.update(null, param);
			}
		}
	}

	public void desconectar() {
		this.notifyObservers(null);
	}
}
