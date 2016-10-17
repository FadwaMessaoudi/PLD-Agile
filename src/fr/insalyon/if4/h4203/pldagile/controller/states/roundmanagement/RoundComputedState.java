package fr.insalyon.if4.h4203.pldagile.controller.states.roundmanagement;

import fr.insalyon.if4.h4203.pldagile.controller.Controller;
import fr.insalyon.if4.h4203.pldagile.controller.states.DefaultState;

/**
 * @brief Active state when a delivery round has been computed
 * 
 * This state is active when a delivery round has been computed and is displayed.
 * 
 * @note This is currently only a waiting state. Commands will be added in further versions.
 * 
 * @author Nathan Shiraini
 *
 */
public class RoundComputedState extends DefaultState {
	
	/// @brief Reference to the application controller
	private final Controller controller;
	
	/**
	 * @brief Constructor for this state class
	 * 
	 * This constructor performs the entry action for this state,
	 * which is showing the map on the interface.
	 * 
	 * The GUI is designed to refresh on its own upon updating the OMap instance.
	 * 
	 * @param c A reference to the controller of the application
	 */
	public RoundComputedState(Controller c) {
		this.controller = c;
	}
	
	/**
	 * @brief Command to switch back to loading the street map
	 * 
	 * This method simply reverts the state of the controller to PromptForMapState
	 */
	public void loadStreetMap() {
		
	}
	
	/**
	 * @brief Command to move forward to loading an order
	 * 
	 * This method simply changes the state of the controller to PromptForOrderState
	 */
	public void loadOrder(){
		
	}
}
