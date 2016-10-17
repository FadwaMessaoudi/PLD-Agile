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
	 * Initializes the state of the application as well as the model
	 */
	public Controller() {
		this.currentState = StatesEnum.getStartupState(this);
		this.map = new OMap();
	}

	/**
	 * @brief User acknowledges a message
	 * 
	 * This method is called by the GUI when the user clicks the "OK" button
	 * on a message box.
	 */
	public void acknowledge() {
		this.currentState.acknowledge();
	}

	/**
	 * @brief User wants to load a map
	 * 
	 * This method is called when the user clicks the "Load Map" button
	 * on the GUI
	 */
	public void loadStreetMap() {
		this.currentState.loadStreetMap();
	}

	/**
	 * @brief User wants to load a delivery order
	 * 
	 * This method is called when the user clicks the "Load Delivery Order"
	 * button on the GUI
	 */
	public void loadOrder() {
		this.currentState.loadOrder();
	}

	/**
	 * @brief User wants to compute a delivery round
	 * 
	 * This method is called by the GUI when the user wants to calculate
	 * a new delivery round.
	 */
	public void computeRound() {
		this.currentState.computeRound();
	}
	
	/**
	 * @brief Changes the state the controller is in
	 * 
	 * This method is called by other state classes.
	 * It will change the current state of the controller.
	 * 
	 * @param s The enum value that corresponds to the desired state.
	 */
	public void setState(StatesEnum s) {
		this.currentState = StatesEnum.getState(s, this);
	}
	
	/**
	 * @brief Returns a reference to the underlying OMap object.
	 * @return a reference to the OMap instance used by the controller as a hook to the model
	 */
	public OMap getMap() {
		return this.map;
	}
}
