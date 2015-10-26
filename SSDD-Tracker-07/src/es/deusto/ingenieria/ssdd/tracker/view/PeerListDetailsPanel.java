package es.deusto.ingenieria.ssdd.tracker.view;

import java.awt.Dimension;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import es.deusto.ingenieria.ssdd.tracker.controller.PeerDetailsController;
import es.deusto.ingenieria.ssdd.tracker.objetos.*;

public class PeerListDetailsPanel extends JPanel implements Observer {

	private static final long serialVersionUID = -3290055577494365102L;
	private PeerDetailsController controller;
	private JTable table;
	private MyButtonModel model;
	private Object[][] filas;

	public PeerListDetailsPanel(PeerDetailsController peerDetailsController) {
		controller = peerDetailsController;
		controller.addObserver(this);
		createTable();
	}

	public void createTable() {
		String[] columnNombres = { "Peer ID", "IP", "Puerto", "Torrents" };

		model = new MyButtonModel();
		model.setColumnIdentifiers(columnNombres);
		model.setDataVector(filas, columnNombres);
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(125);
		table.getColumnModel().getColumn(1).setPreferredWidth(125);
		table.getColumnModel().getColumn(2).setPreferredWidth(125);
		table.getColumnModel().getColumn(3).setPreferredWidth(125);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(500, 250));
		this.add(scrollPane);
		updateTable();
	}

	private synchronized void updateTable() {

		generateTrackersData();
		for (int i = 0; i < filas.length; i++) {
			model.addRow(filas[i]);
		}
	}

	public void generateTrackersData() {
		List<Peer> listaPeers = controller.getPeerList();
		filas = new Object[listaPeers.size()][];
		Object[] rowData;
		Peer peer;
		for (int i = 0; i < listaPeers.size(); i++) {
			peer = listaPeers.get(i);
			if (peer != null) {
				rowData = new Object[4];
				rowData[0] = peer.getId();
				rowData[1] = peer.getDireccionIP();
				rowData[2] = peer.getPuerto();
				rowData[3] = peer.getTorrent();
				filas[i] = rowData;
			}
		}

	}

	class MyButtonModel extends DefaultTableModel {

		private static final long serialVersionUID = 1L;

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}
}
