/**
 * 
 */
package fr.insalyon.if4.h4203.pldagile.controller.states;

import fr.insalyon.if4.h4203.pldagile.controller.Controller;

/**
 * @brief Default state for the controller
 * 
 * This class is a default state, defining the default actions
 * for the states' methods. By default, these methods do nothing.
 * 
 * @author Thibaut FERNANDEZ
 *
 */
public class DefaultState implements State {

	/**
	 * @brief Constructor for this class
	 * 
	 * Default implementation that does nothing
	 * 
	 * @param c A reference to the Controller object
	 */
	public DefaultState(Controller c) {}

	/**
	 * @brief Constructor for this class
	 * 
	 * Do not use the default constructor when instantiating.
	 * 
	 * Default implementation that does nothing
	 * 
	 * @param c A reference to the Controller object
	 */
	public DefaultState() {}
	
	/**
	 * @brief Command to load an XML file
	 * 
	 * Default implementation that does nothing
	 * 
	 * @param uri The file URI the user has entered, transmitted by the GUI
	 */
	@Override
	public void load(String uri) {}

	/**
	 * @brief User acknowledges a message
	 * 
	 * Default implementation that does nothing
	 */
	@Override
	public void acknowledge() {}

	/**
	 * @brief User wants to load a map
	 * 
	 * Default implementation that does nothing
	 */
	@Override
	public void loadStreetMap() {}

	/**
	 * @brief User wants to load a delivery order
	 * 
	 * Default implementation that does nothing
	 */
	@Override
	public void loadOrder() {}

	/**
	 * @brief User wants to compute a delivery round
	 * 
	 * Default implementation that does nothing
	 */
	@Override
	public void computeRound() {}

}
