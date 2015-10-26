package es.deusto.ingenieria.ssdd.tracker.main;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import es.deusto.ingenieria.ssdd.tracker.controller.ConfiguracionDetailsController;
import es.deusto.ingenieria.ssdd.tracker.controller.PeerDetailsController;
import es.deusto.ingenieria.ssdd.tracker.controller.TrackerDetailsController;
import es.deusto.ingenieria.ssdd.tracker.view.ConfiguracionDetailsPanel;
import es.deusto.ingenieria.ssdd.tracker.view.TrackerMainFrame;
import es.deusto.ingenieria.ssdd.tracker.view.PeerListDetailsPanel;
import es.deusto.ingenieria.ssdd.tracker.view.TrackerDetailsPanel;
import es.deusto.ingenieria.ssdd.tracker.model.TrackerRedundancyManager;

public class MainProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrackerRedundancyManager redundancyManager = new TrackerRedundancyManager();

		TrackerDetailsController trackerListController = new TrackerDetailsController(redundancyManager);
		TrackerDetailsPanel trackerListView = new TrackerDetailsPanel(trackerListController);

		ConfiguracionDetailsController configurationController = new ConfiguracionDetailsController(redundancyManager);
		ConfiguracionDetailsPanel configurationView = new ConfiguracionDetailsPanel(configurationController);

		PeerDetailsController peerListController = new PeerDetailsController(redundancyManager);
		PeerListDetailsPanel peerListView = new PeerListDetailsPanel(peerListController);

		Map<String, JPanel> panels = new HashMap<String, JPanel>();
		panels.put(" Configuraccion    ", configurationView);
		panels.put("Trackers  ", trackerListView);
		panels.put("Peers ", peerListView);

		TrackerMainFrame mainWindow = new TrackerMainFrame(panels);
		mainWindow.setVisible(true);

	}

}
