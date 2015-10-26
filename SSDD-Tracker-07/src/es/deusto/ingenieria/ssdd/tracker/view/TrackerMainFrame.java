package es.deusto.ingenieria.ssdd.tracker.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TrackerMainFrame extends JFrame {

	private static final long serialVersionUID = -5839974224728234589L;

	private Map<String, JPanel> panels;

	public TrackerMainFrame(Map<String, JPanel> panels) {
		this.panels = panels;
		setSize(600, 300);
		setLocationRelativeTo(null);
		setTitle("Tracker ");

		JTabbedPane tabbedPane = new JTabbedPane();
		if (panels != null && panels.size() > 0) {
			paintPanels(tabbedPane);
			if (tabbedPane.getComponents().length > 0) {
				add(tabbedPane);
			}
		}

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
	}

	public void paintPanels(JTabbedPane tabbedPane) {
		for (String titulo : panels.keySet()) {
			tabbedPane.add(titulo, panels.get(titulo));
		}
	}

}
