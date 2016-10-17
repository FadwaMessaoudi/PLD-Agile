package fr.insalyon.if4.h4203.pldagile.controller.states.loadstreetmap;

import fr.insalyon.if4.h4203.pldagile.controller.Controller;
import fr.insalyon.if4.h4203.pldagile.controller.states.DefaultState;
import fr.insalyon.if4.h4203.pldagile.controller.states.StatesEnum;

/**
 * @brief Displaying a street map
 * 
 * This state is active after a street map has been loaded.
 * 
 * @author Thibaut FERNANDEZ
 *
 */
public class LoadStreetMapState extends DefaultState {

	/// @brief Reference to the application controller
	private final Controller controller;
	
	/**
	 * @brief Constructor for this state class
	 * 
	 * This constructor the entry action for this state,
	 * which is showing the map on the interface.
	 * 
	 * @todo Waiting for GUI
	 * 
	 * @param c A reference to the controller of the application
	 */
	public LoadStreetMapState(Controller c) {
		this.controller = c;
		// TODO Waiting for GUI
	}
	
	/**
	 * @brief Command to switch back to loading the street map
	 * 
	 * This method simply reverts the state of the controller to PromptForMapState
	 */
	public void loadStreetMap() {
		this.controller.setState(StatesEnum.PROMPT_FOR_MAP_STATE);
	}
	
	/**
	 * @brief Command to move forward to loading an order
	 * 
	 * This method simply changes the state of the controller to PromptForOrderState
	 */
	public void loadOrder() {
		this.controller.setState(StatesEnum.PROMPT_FOR_ORDER_STATE);
	}
}
