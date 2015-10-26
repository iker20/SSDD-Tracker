package es.deusto.ingenieria.ssdd.tracker.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observer;

import es.deusto.ingenieria.ssdd.tracker.model.TrackerRedundancyManager;
import es.deusto.ingenieria.ssdd.tracker.objetos.TrackersLista;

public class TrackerDetailsController {

	private TrackerRedundancyManager redundancyManager;

	public TrackerDetailsController(TrackerRedundancyManager redundancyManager) {
		this.redundancyManager = redundancyManager;
	}

	public void desconectar() {
		redundancyManager.desconectar();
	}

	public void addObserver(Observer o) {
		redundancyManager.addObserver(o);
	}

	public void deleteObserver(Observer o) {
		redundancyManager.addObserver(o);
	}

	public List<TrackersLista> getTrackersLista() {

		// TODO Auto-generated method stub

		Date ahora = new Date();
		List<TrackersLista> tracker = new ArrayList<TrackersLista>();
		TrackersLista tracker1 = new TrackersLista("1", ahora, false);
		TrackersLista tracker2 = new TrackersLista("2", ahora, true);
		tracker.add(tracker1);
		tracker.add(tracker2);

		return tracker;
	}
}
