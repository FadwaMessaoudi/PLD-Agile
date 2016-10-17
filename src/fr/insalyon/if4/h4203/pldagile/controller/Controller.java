package fr.insalyon.if4.h4203.pldagile.controller;
import fr.insalyon.if4.h4203.pldagile.controller.states.State;
import fr.insalyon.if4.h4203.pldagile.controller.states.StatesEnum;
import fr.insalyon.if4.h4203.modele.OMap;

/**
 * @brief State-machine Controller
 * 
 * This is the controller for our implementation
 * of the State/Controller design pattern.
 * 
 * The purpose of this class is to manage the workflow
 * and the window progression of the application.
 * 
 * @author Thibaut FERNANDEZ
 *
 */
public class Controller {

	/**
	 * @brief The state in which the application is currently
	 * 
	 * This is an implementation of the State interface.
	 * Such implementations can be fund in the States package and its subpackages.
	 */
	private State currentState;
	
	/**
	 * The only acces to the model from the controller
	 */
	private OMap map;
	
	/**
	 * @brief Default constructor for the controller
	 * 
	 * @toimplement
	 */
	public Controller() {
		currentState = StatesEnum.getStartupState(this);
	}

	/**
	 * @brief Command to load an XML file
	 * 
	 * This method is called buy the GUI when the user has entered a file URI.
	 * 
	 * @param uri The file URI the user has entered, transmitted by the GUI
	 */
	public void load(String uri) {
		currentState.load(uri);
	}

	/**
	 * @brief User acknowledges a message
	 * 
	 * This method is called by the GUI when the user clicks the "OK" button
	 * on a message box.
	 */
	public void acknowledge() {
		currentState.acknowledge();
	}

	/**
	 * @brief User wants to load a map
	 * 
	 * This method is called when the user clicks the "Load Map" button
	 * on the GUI
	 */
	public void loadStreetMap() {
		currentState.loadStreetMap();
	}

	/**
	 * @brief User wants to load a delivery order
	 * 
	 * This method is called when the user clicks the "Load Delivery Order"
	 * button on the GUI
	 */
	public void loadOrder() {
		currentState.loadOrder();
	}

	/**
	 * @brief User wants to compute a delivery round
	 * 
	 * This method is called by the GUI when the user wants to calculate
	 * a new delivery round.
	 */
	public void computeRound() {
		currentState.computeRound();
	}
}
