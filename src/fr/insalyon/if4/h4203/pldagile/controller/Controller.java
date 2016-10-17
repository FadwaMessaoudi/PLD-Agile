package fr.insalyon.if4.h4203.pldagile.controller;
import fr.insalyon.if4.h4203.pldagile.controller.states.State;
import fr.insalyon.if4.h4203.pldagile.controller.states.StatesEnum;
import fr.insalyon.if4.h4203.pldagile.modele.OMap;
import fr.insalyon.if4.h4203.pldagile.view.Window;

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
	
	/// @brief The only access to the model from the controller
	private final OMap map;
	
	/// @brief The only access to the GUI from the controller
	private final Window window;
	
	/**
	 * @brief Default constructor for the controller
	 * 
	 * Initializes the state of the application as well as the model
	 */
	public Controller() {
		this.currentState = StatesEnum.getStartupState(this);
		this.map = new OMap();
		this.window = new Window(this.map, 0, this);
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
	 * @return A reference to the OMap instance used by the controller as a hook to the model
	 */
	public OMap getMap() {
		return this.map;
	}
	
	/**
	 * @brief Returns a reference to the underlying Window object.
	 * @return A reference to the Window instance used by the controller as a hook to the GUI
	 */
	public Window getWindow() {
		return this.window;
	}
}
