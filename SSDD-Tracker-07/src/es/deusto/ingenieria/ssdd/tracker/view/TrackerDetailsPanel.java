package es.deusto.ingenieria.ssdd.tracker.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import es.deusto.ingenieria.ssdd.tracker.controller.TrackerDetailsController;
import es.deusto.ingenieria.ssdd.tracker.objetos.TrackersLista;

public class TrackerDetailsPanel extends JPanel implements Observer, ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3494245647851905237L;
	private TrackerDetailsController controller;
	private JTable table;
	private MyBooleanModel model;
	private Object[][] filas;
	private String[] columnNombres = { "Tracker ID", "Ultimo KeepAlive", "Master" };

	public TrackerDetailsPanel(TrackerDetailsController trackerDetailsController) {
		controller = trackerDetailsController;
		controller.addObserver(this);
		createTable();
	}

	@Override
	public void update(Observable o, Object arg) {
		updateTable();
	}

	private synchronized void updateTable() {
		generateTrackersData();
		for (int i = 0; i < filas.length; i++) {
			model.addRow(filas[i]);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public void createTable() {

		model = new MyBooleanModel();
		model.setColumnIdentifiers(columnNombres);
		model.setDataVector(filas, columnNombres);
		table = new JTable(model);
		configureSizesOfTable(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(500, 225));
		this.add(scrollPane);
		updateTable();
	}

	public void configureSizesOfTable(JTable table) {
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(97);
	}

	public void generateTrackersData() {
		List<TrackersLista> listTrackerActivos = controller.getTrackersLista();
		filas = new Object[listTrackerActivos.size()][];
		Object[] datos;
		TrackersLista tracker;
		for (int i = 0; i < listTrackerActivos.size(); i++) {
			tracker = listTrackerActivos.get(i);
			if (tracker != null) {
				datos = new Object[TrackersLista.numColumns];
				datos[0] = tracker.getId();
				datos[1] = tracker.getUltimoKeepAlive();
				datos[2] = tracker.isMaster();
				filas[i] = datos;
			}
		}
	}

	class MyBooleanModel extends DefaultTableModel {

		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			return false;
		}

		public Class<?> getColumnClass(int column) {
			switch (column) {
			case 0:
				return String.class;
			case 1:
				return String.class;
			case 2:
				return String.class;
			default:
				return String.class;
			}
		}
	}
}