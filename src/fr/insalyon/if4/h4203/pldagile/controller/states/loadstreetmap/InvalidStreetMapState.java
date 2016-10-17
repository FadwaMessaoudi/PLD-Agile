package fr.insalyon.if4.h4203.pldagile.controller.states.loadstreetmap;

import fr.insalyon.if4.h4203.pldagile.controller.Controller;
import fr.insalyon.if4.h4203.pldagile.controller.states.DefaultState;
import fr.insalyon.if4.h4203.pldagile.controller.states.StatesEnum;

/**
 * @brief Warining the user that his street map file is not valid
 * 
 * This state displays the message warning the user that he did not provide a valid file.
 * This a waiting state that will automatically revert to the beginning of the phase.
 * 
 * @author Nathan Shiraini
 *
 */
public class InvalidStreetMapState extends DefaultState {

	/// @brief Reference to the application controller
	private final Controller controller;
	
	/// @brief Message that will be displayed to the user
	private static final String DISPLAY_MESSAGE = "Error\nInvalid street map file\n\nPlease select another file.";
	
	/**
	 * @brief Constructor for this state class
	 * 
	 * This constructor sends a warning to the user, that the XML file is invalid.
	 * 
	 * @param c A reference to the controller of the application
	 */
	public InvalidStreetMapState(Controller c) {
		this.controller = c;
		this.controller.getWindow().displayMessage(DISPLAY_MESSAGE);
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
