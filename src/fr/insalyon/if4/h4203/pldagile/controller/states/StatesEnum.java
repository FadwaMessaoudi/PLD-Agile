
package fr.insalyon.if4.h4203.pldagile.controller.states;

import fr.insalyon.if4.h4203.pldagile.controller.Controller;
import fr.insalyon.if4.h4203.pldagile.controller.states.loaddeliveryorder.InvalidOrderState;
import fr.insalyon.if4.h4203.pldagile.controller.states.loaddeliveryorder.LoadOrderState;
import fr.insalyon.if4.h4203.pldagile.controller.states.loaddeliveryorder.PromptForOrderState;
import fr.insalyon.if4.h4203.pldagile.controller.states.loadstreetmap.InvalidStreetMapState;
import fr.insalyon.if4.h4203.pldagile.controller.states.loadstreetmap.LoadStreetMapState;
import fr.insalyon.if4.h4203.pldagile.controller.states.loadstreetmap.PromptForMapState;
import fr.insalyon.if4.h4203.pldagile.controller.states.roundmanagement.RoundComputedState;

/**
 * @brief List of existing states
 * 
 * This enumeration is a convenient way to list and get any state in a standardized way.
 * 
 * @todo Must be updated everytime a state class is created.
 * 
 * @author Thibaut FERNANDEZ
 *
 */
public enum StatesEnum {

	// Default State
	DEFAULT,
	
	// Load Delivery Order states
	INVALID_ORDER_STATE,
	LOAD_ORDER_STATE,
	PROMPT_FOR_ORDER_STATE,
	
	// Load Street Map states
	INVALID_STREET_MAP_STATE,
	LOAD_STREET_MAP_STATE,
	PROMPT_FOR_MAP_STATE,
	
	// Round Management states
	ROUND_COMPUTED_STATE;
	
	// TODO Needs to be update everytime a state is created
	
	/**
	 * @brief Identifies the startup state of the application
	 * 
	 * This constant contains the enum value that corresponds to the state the application should assume at startup.
	 */
	public static final StatesEnum STARTUP_STATE = LOAD_STREET_MAP_STATE;
	
	/**
	 * @brief Creates a State object
	 * 
	 * This method creates a new State object using the reference to the COntroller object passed as a parameter.
	 * 
	 * @param state The state to create, as a value of this enumeration
	 * @param controller A reference to the Controller object
	 * @return A new State instance, corresponding to the enum value that was passed as a parameter.
	 */
	public static State getState(StatesEnum state, Controller controller) {
		switch(state) {
		case INVALID_ORDER_STATE:
			return new InvalidOrderState(controller);
		case LOAD_ORDER_STATE:
			return new LoadOrderState(controller);
		case PROMPT_FOR_ORDER_STATE:
			return new PromptForOrderState(controller);
		case INVALID_STREET_MAP_STATE:
			return new InvalidStreetMapState(controller);
		case LOAD_STREET_MAP_STATE:
			return new LoadStreetMapState(controller);
		case PROMPT_FOR_MAP_STATE:
			return new PromptForMapState(controller);
		case ROUND_COMPUTED_STATE:
			return new RoundComputedState(controller);
		case DEFAULT: // falls through
		default:
			return new DefaultState(controller);
		}
	}
	
	/**
	 * @brief Creates a default state
	 * 
	 * This method creates and returns a new instance of the default state.
	 * 
	 * @note This method shouldn't be used, as the default state does nothing.
	 * 
	 * @param controller A reference to the Controller object
	 * @return A new instance of the default state
	 */
	public static State getDefaultState(Controller controller) {
		return getState(DEFAULT, controller);
	}

	
	/**
	 * @brief Creates a startup state
	 * 
	 * This method creates and returns a new instance of the startup state.
	 * This method should be used in the constructor of the controller object.
	 * 
	 * This method is a shortcut for <tt>getState(STARTUP_STATE, controller)</tt>.
	 * 
	 * @param controller A reference to the Controller object
	 * @return 
	 * @return A new instance of the startup state
	 */
	public static State getStartupState(Controller controller) {
		return getState(STARTUP_STATE, controller);
	}
	
}
