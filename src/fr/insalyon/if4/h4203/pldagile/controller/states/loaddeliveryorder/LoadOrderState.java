package fr.insalyon.if4.h4203.pldagile.controller.states.loaddeliveryorder;

import fr.insalyon.if4.h4203.pldagile.controller.Controller;
import fr.insalyon.if4.h4203.pldagile.controller.states.DefaultState;
import fr.insalyon.if4.h4203.pldagile.controller.states.StatesEnum;
import fr.insalyon.if4.h4203.pldagile.modele.OMap;

/**
 * @brief Displaying a street map
 * 
 * This state is active after a delivery order has been loaded.
 * It corresponds to a waiting state while the user decides what to do.
 * 
 * @author Thibaut FERNANDEZ
 *
 */
public class LoadOrderState extends DefaultState {

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
	public LoadOrderState(Controller c) {
		this.controller = c;
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
	 * @brief Command to switch back to loading the delivery order
	 * 
	 * This method simply reverts the state of the controller to PromptForOrderState
	 */
	public void loadOrder() {
		this.controller.setState(StatesEnum.PROMPT_FOR_ORDER_STATE);
	}
	
	/**
	 * @brief Command to move forward to computing the delivery round
	 * 
	 * This method starts the calculation of the delivery round and switches the state of the controller to RoundComputedState
	 * 
	 * @toimplement
	 * @todo Link to the computing algorithms
	 */
	public void computeRound() {
		// TODO
		this.controller.setState(StatesEnum.ROUND_COMPUTED_STATE);
	}
}
