package es.deusto.ingenieria.ssdd.tracker.objetos;

import java.util.Date;

public class TrackersLista {

	private String id;
	private Date ultimoKeepAlive;
	private boolean master;
	public static final int numColumns = 3;

	public TrackersLista(String id, Date ultimoKeepAlive, boolean master) {
		this.id = id;
		this.ultimoKeepAlive = ultimoKeepAlive;
		this.master = master;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getUltimoKeepAlive() {
		return ultimoKeepAlive;
	}

	public void setUltimoKeepAlive(Date ultimoKeepAlive) {
		this.ultimoKeepAlive = ultimoKeepAlive;
	}

	public boolean isMaster() {
		return master;
	}

	public void setMaster(boolean master) {
		this.master = master;
	}

	@Override
	public String toString() {
		return "Id: " + id + "  master: " + master;
	}

}
