package fr.insalyon.if4.h4203.pldagile.controller.states.loaddeliveryorder;

import fr.insalyon.if4.h4203.pldagile.controller.Controller;
import fr.insalyon.if4.h4203.pldagile.controller.states.DefaultState;
import fr.insalyon.if4.h4203.pldagile.controller.states.StatesEnum;
import fr.insalyon.if4.h4203.pldagile.xml.ExceptionXML;
import fr.insalyon.if4.h4203.pldagile.xml.Deserializer;

/**
 * @brief Loading a delivery order file
 * 
 * This state is active when the application is loading a delivery order file.
 * This corresponds to the second phase of the application.
 * 
 * @author Thibaut FERNANDEZ
 *
 */
public class PromptForOrderState extends DefaultState {

	/// @brief Reference to the application controller
	private final Controller controller;
	
	/**
	 * @brief Constructor for this state class
	 * 
	 * This constructor performs the following actions, which are entry actions for this state:
	 * 
	 * @li Ask for the location of an xml file
	 * @li Attempt to parse the file and convert it to an OMap
	 * @li If parsing fails, change the state to InvalidOrderState
	 * @li If parsing suceeds, change the state to LoadOrderState
	 * 
	 * @param c A reference to the controller of the application
	 * 
	 */
	public PromptForOrderState(Controller c) {
		this.controller = c;
		try {
			Deserializer.loadDeliveryOrder(this.controller.getMap());
		} catch (ExceptionXML e) {
			this.controller.setState(StatesEnum.INVALID_STREET_MAP_STATE);
			return;
		}
		this.controller.setState(StatesEnum.LOAD_STREET_MAP_STATE);
	}
}
