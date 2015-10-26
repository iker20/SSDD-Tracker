package es.deusto.ingenieria.ssdd.tracker.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import es.deusto.ingenieria.ssdd.tracker.controller.ConfiguracionDetailsController;

public class ConfiguracionDetailsPanel extends JPanel implements Observer, ActionListener {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private ConfiguracionDetailsController controller;

	public ConfiguracionDetailsPanel(ConfiguracionDetailsController configuraccionController) {
		super(new BorderLayout());
		controller = configuraccionController;
		controller.addObserver(this);
		setUpPanel();
	}

	private Label labelDireccionIP;
	private Label labelPuertoTracker;
	private Label labelPuertoPeer;
	private Label labelId;

	private JTextField txtDireccionIP;
	private JTextField txtPuertoTracker;
	private JTextField txtPuertoPeer;
	private JTextField txtId;

	private JButton btnStart;
	private JButton btnStop;

	private void setUpPanel() {

		labelDireccionIP = new Label("Dirección IP");
		labelDireccionIP.setFont(new Font("Serif", Font.BOLD, 14));
		labelPuertoTracker = new Label("Puerto Trackers");
		labelPuertoTracker.setFont(new Font("Serif", Font.BOLD, 14));
		labelPuertoPeer = new Label("Puerto Peers");
		labelPuertoPeer.setFont(new Font("Serif", Font.BOLD, 14));
		labelId = new Label("Id");
		labelId.setFont(new Font("Serif", Font.BOLD, 14));

		Box boxDireccionIP = Box.createVerticalBox();
		boxDireccionIP.add(Box.createVerticalGlue());
		txtDireccionIP = new JTextField();
		txtDireccionIP.setColumns(20);
		txtDireccionIP.setMaximumSize(new Dimension(Integer.MAX_VALUE, txtDireccionIP.getPreferredSize().height));
		txtDireccionIP.setText("0.0.0.0");
		boxDireccionIP.add(txtDireccionIP);
		boxDireccionIP.add(Box.createVerticalGlue());

		Box boxPuertoTracker = Box.createVerticalBox();
		boxPuertoTracker.add(Box.createVerticalGlue());
		txtPuertoTracker = new JTextField();
		txtPuertoTracker.setColumns(20);
		txtPuertoTracker.setMaximumSize(new Dimension(Integer.MAX_VALUE, txtPuertoTracker.getPreferredSize().height));
		txtPuertoTracker.setText("2300");
		boxPuertoTracker.add(txtPuertoTracker);
		boxPuertoTracker.add(Box.createVerticalGlue());

		Box boxPuertoPeer = Box.createVerticalBox();
		boxPuertoPeer.add(Box.createVerticalGlue());
		txtPuertoPeer = new JTextField();
		txtPuertoPeer.setColumns(20);
		txtPuertoPeer.setMaximumSize(new Dimension(Integer.MAX_VALUE, txtPuertoPeer.getPreferredSize().height));
		txtPuertoPeer.setText("2090");
		boxPuertoPeer.add(txtPuertoPeer);
		boxPuertoPeer.add(Box.createVerticalGlue());

		Box boxId = Box.createVerticalBox();
		boxId.add(Box.createVerticalGlue());
		txtId = new JTextField();
		txtId.setColumns(20);
		txtId.setMaximumSize(new Dimension(Integer.MAX_VALUE, txtId.getPreferredSize().height));
		txtId.setText("1");
		boxId.add(txtId);
		boxId.add(Box.createVerticalGlue());

		JPanel panelDireccionIP = new JPanel(new GridLayout(1, 0));
		panelDireccionIP.add(labelDireccionIP);
		panelDireccionIP.add(boxDireccionIP);

		JPanel panelPuertoTracker = new JPanel(new GridLayout(1, 0));
		panelPuertoTracker.add(labelPuertoTracker);
		panelPuertoTracker.add(boxPuertoTracker);

		JPanel panelPuertoPeer = new JPanel(new GridLayout(1, 0));
		panelPuertoPeer.add(labelPuertoPeer);
		panelPuertoPeer.add(boxPuertoPeer);

		JPanel panelId = new JPanel(new GridLayout(1, 0));
		panelId.add(labelId);
		panelId.add(boxId);

		JPanel panelData = new JPanel(new GridLayout(4, 0));
		panelData.add(panelDireccionIP);
		panelData.add(panelPuertoTracker);
		panelData.add(panelPuertoPeer);
		panelData.add(panelId);

		btnStart = new JButton("Start");
		btnStart.setBackground(Color.YELLOW);
		btnStart.addActionListener(this);
		btnStop = new JButton("Stop");
		btnStop.setBackground(Color.GREEN);
		btnStop.addActionListener(this);
		btnStop.setVisible(false);

		JPanel buttonPane = new JPanel(new FlowLayout());
		buttonPane.add(btnStart);
		buttonPane.add(btnStop);

		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		add(panelData, BorderLayout.CENTER);
		add(buttonPane, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnStart)) {
			String direccionIP = txtDireccionIP.getText();
			String puertoTracker = txtPuertoTracker.getText();
			String puertoPeer = txtPuertoPeer.getText();
			String mensaje = "";
			if (direccionIP != null && !direccionIP.equals("") && puertoTracker != null && !puertoTracker.equals("")
					&& puertoPeer != null && !puertoPeer.equals("")) {
				if (controller.checkIpAddress(txtDireccionIP.getText())) {
					btnStart.setVisible(false);
					btnStop.setVisible(true);
				} else {
					mensaje = "Esta IP ( " + txtDireccionIP.getText() + " ) no es una IP valida ";
				}
			} else {
				mensaje = "Tienes que rellenar todos los campos";
			}

			if (mensaje != "") {
				JOptionPane.showMessageDialog(null, mensaje);
			}

		} else if (e.getSource().equals(btnStop)) {
			btnStart.setVisible(true);
			btnStop.setVisible(false);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
	}

}
