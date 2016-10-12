package fr.insalyon.if4.h4203.pldagile.controller.states;

/**
 * @brief State interface
 * 
 * This interface contains the list of methods used by the controller
 * that will be implemented in the various states.
 * 
 * Refer to the implementations for more information about the methods.
 * 
 * @author Thibaut FERNANDEZ
 *
 */
public interface State {

	/// @brief Command to load an XML file
	public void load(String uri);

	/// @brief User acknowledges a message
	public void acknowledge();

	/// @brief User wants to load a map
	public void loadStreetMap();

	/// @brief User wants to load a delivery order
	public void loadOrder();

	///@brief User wants to compute a delivery round
	public void computeRound();
}
