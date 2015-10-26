package es.deusto.ingenieria.ssdd.tracker.controller;

import java.util.Observer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.deusto.ingenieria.ssdd.tracker.model.*;

public class ConfiguracionDetailsController {
	private TrackerRedundancyManager redundancyManager;

	private Pattern pattern;
	private Matcher matcher;

	private static final String IPADDRESS_PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

	public ConfiguracionDetailsController(TrackerRedundancyManager redundancyManager) {
		this.redundancyManager = redundancyManager;
		pattern = Pattern.compile(IPADDRESS_PATTERN);
	}

	public void desconectar() {
		redundancyManager.desconectar();
	}

	public void addObserver(Observer o) {
		redundancyManager.addObserver(o);
	}

	public void deleteObserver(Observer o) {
		redundancyManager.deleteObserver(o);
	}

	public boolean checkIpAddress(String ip) {
		matcher = pattern.matcher(ip);
		return matcher.matches();
	}
}
