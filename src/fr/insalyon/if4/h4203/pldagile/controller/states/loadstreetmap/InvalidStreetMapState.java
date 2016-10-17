package fr.insalyon.if4.h4203.pldagile.controller.states.loadstreetmap;

import fr.insalyon.if4.h4203.pldagile.controller.Controller;
import fr.insalyon.if4.h4203.pldagile.controller.states.DefaultState;
import fr.insalyon.if4.h4203.pldagile.controller.states.StatesEnum;

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
	
	/**
	 * @brief User acknowledges error
	 * 
	 * This method is called by the GUI when the user presses the "OK" button.
	 */
	public void acknowledge() {
		this.controller.setState(StatesEnum.PROMPT_FOR_MAP_STATE);
	}
}
