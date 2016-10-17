package fr.insalyon.if4.h4203.pldagile.controller.states.loadstreetmap;

import fr.insalyon.if4.h4203.pldagile.controller.Controller;
import fr.insalyon.if4.h4203.pldagile.controller.states.DefaultState;
import fr.insalyon.if4.h4203.pldagile.controller.states.StatesEnum;

/**
 * @brief Loading a street map file
 * 
 * This state is active when the application is loading a street map file.
 * This state should be the startup state of the application.
 * 
 * @author Thibaut FERNANDEZ
 *
 */
public class LoadStreetMapState extends DefaultState {

	/// @brief Reference to the application controller
	private final Controller controller;
	
	public LoadStreetMapState(Controller c) {
		this.controller = c;
		
	}
	
	public void loadStreetMap() {
		this.controller.setState(StatesEnum.PROMPT_FOR_MAP_STATE);
	}
	
	public void loadOrder() {
		this.controller.setState(StatesEnum.PROMPT_FOR_ORDER_STATE);
	}
}
