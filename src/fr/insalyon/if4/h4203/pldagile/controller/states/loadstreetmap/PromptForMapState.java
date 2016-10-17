package fr.insalyon.if4.h4203.pldagile.controller.states.loadstreetmap;

import fr.insalyon.if4.h4203.pldagile.controller.Controller;
import fr.insalyon.if4.h4203.pldagile.controller.states.DefaultState;

public class PromptForMapState extends DefaultState {

	/// @brief Reference to the application controller
	private final Controller controller;

	/**
	 * @brief Constructor for this state class
	 * 
	 * This constructor performs the following actions, which are entry actions for this state:
	 * 
	 * @li Ask for the location of an xml file
	 * @li Attempt to parse the file and convert it to an OMap
	 * @li If parsing fails, change the state to InvalidStreetMapState
	 * @li If parsing suceeds, change the state to LoadStreetMapState
	 * 
	 */
	public PromptForMapState(Controller c) {
		this.controller = c;
		
	}
	
	public void load(String uri) {
		
	}
}
