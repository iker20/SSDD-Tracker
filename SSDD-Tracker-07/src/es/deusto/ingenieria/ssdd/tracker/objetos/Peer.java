package es.deusto.ingenieria.ssdd.tracker.objetos;

public class Peer {

	private String id;
	private String direccionIP;
	private int puerto;
	private String torrent;

	public Peer(String id, String direccionIP, int puerto, String torrent) {
		this.id = id;
		this.direccionIP = direccionIP;
		this.puerto = puerto;
		this.torrent = torrent;

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

	public void setDireccionIP(String ipAddress) {
		this.direccionIP = ipAddress;
	}

	public int getPuerto() {
		return puerto;
	}

	public void setPuerto(int port) {
		this.puerto = port;
	}

	public String getTorrent() {
		return torrent;
	}

}
