package es.deusto.ingenieria.ssdd.tracker.objetos;

import java.util.concurrent.ConcurrentHashMap;

public class Tracker {

	private String id;
	private String direccionIP;
	private int puertoTracker;
	private int puertoPeers;
	private ConcurrentHashMap<String, TrackersLista> trackersActivos;
	private boolean master;

	public Tracker() {
	}

	public Tracker(String id, String direccionIP, int puertoTracker, int puertoPeers) {
		this.id = id;
		this.direccionIP = direccionIP;
		this.puertoTracker = puertoTracker;
		this.puertoPeers = puertoPeers;

	}

	public Tracker(String id, ConcurrentHashMap<String, TrackersLista> trackersActivos) {
		this.id = id;
		this.trackersActivos = trackersActivos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDireccionIP() {
		return direccionIP;
	}

	public void setDireccionIP(String direccionIP) {
		this.direccionIP = direccionIP;
	}

	public int getPuertoTracker() {
		return puertoTracker;
	}

	public void setPuertoTracker(int port) {
		this.puertoTracker = port;
	}

	public int getPuertoPeers() {
		return puertoPeers;
	}

	public void setPuertoPeers(int puertoPeers) {
		this.puertoPeers = puertoPeers;
	}

	public ConcurrentHashMap<String, TrackersLista> getTrackersActivos() {
		if (trackersActivos == null) {
			trackersActivos = new ConcurrentHashMap<String, TrackersLista>();
		}
		return trackersActivos;
	}

	public void setTrackersActivos(ConcurrentHashMap<String, TrackersLista> trackersActivos) {
		this.trackersActivos = trackersActivos;
	}

	public boolean isMaster() {
		return master;
	}

	public void setMaster(boolean master) {
		this.master = master;
	}

}
