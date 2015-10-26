package es.deusto.ingenieria.ssdd.tracker.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import es.deusto.ingenieria.ssdd.tracker.model.*;
import es.deusto.ingenieria.ssdd.tracker.objetos.Peer;

public class PeerDetailsController {

	private TrackerRedundancyManager redundancyManager;

	public PeerDetailsController(TrackerRedundancyManager redundancyManager) {
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

	public List<Peer> getPeerList() {

		// TODO Auto-generated method stub

		List<Peer> peers = new ArrayList<Peer>();
		Peer peer1 = new Peer("1", "0.0.0.0", 2, "gdhgfhf");
		Peer peer2 = new Peer("2", "0.2.0.0", 54, "djuukhgkjh");
		peers.add(peer1);
		peers.add(peer2);

		return peers;
	}

}
