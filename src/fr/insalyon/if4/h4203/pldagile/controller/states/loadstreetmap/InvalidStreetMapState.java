package fr.insalyon.if4.h4203.pldagile.controller.states.loadstreetmap;

import fr.insalyon.if4.h4203.pldagile.controller.Controller;
import fr.insalyon.if4.h4203.pldagile.controller.states.DefaultState;

public class InvalidStreetMapState extends DefaultState {

	/// @brief Reference to the application controller
	private final Controller controller;
	
	/**
	 * @brief Constructor for this state class
	 * 
	 * This constructor sends a warning to the user, that the XML file is invalid.
	 * 
	 * @todo Waiting for GUI
	 * 
	 * @param c A reference to the controller of the application
	 */
	public InvalidStreetMapState(Controller c) {
		this.controller = c;
		// TODO waiting for GUI
		this.acknowledge();
	}
	
	public void acknowledge() {
		
	}
}
