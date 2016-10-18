package modele;

import java.util.List;

public class Route {
	/**
	 * @brief Departure delivery of the route
	 */
	private Delivery deliveryDeparture;
	
	/**
	 * @brief Arrival delivery of the route
	 */
	private Delivery deliveryArrival;
	
	/**
	 * @brief List of sections composing the route
	 */
	private List<Section> sections;
	
	/**
	 * @brief Constructor of a route without the list of sections
	 * @param deliveryDeparture Departure delivery of the route
	 * @param deliveryArrival Arrival delivery of the route
	 */
	public Route(Delivery deliveryDeparture, Delivery deliveryArrival) {
		this.deliveryDeparture = deliveryDeparture;
		this.deliveryArrival = deliveryArrival;
	}
	
	/**
	 * @brief Constructor of a route with the list of sections
	 * @param deliveryDeparture Departure delivery of the route
	 * @param deliveryArrival Arrival delivery of the route
	 * @param sections List of sections
	 */
	public Route(Delivery deliveryDeparture, Delivery deliveryArrival, List<Section> sections) {
		this.deliveryDeparture = deliveryDeparture;
		this.deliveryArrival = deliveryArrival;
		this.sections=sections;
	}
	
	/**
	 * @brief Add a section to the list of sections
	 * @param section Section to add
	 * @return A boolean to know if everything went well
	 */
	public boolean addSection(Section section) {
		return sections.add(section);
	}
	
	/**
	 * @brief Get the duration of the route plus the duration of the arrival delivery
	 * @return The duration of the route
	 */
	public int getRouteDuration() {
		int routeDuration = 0;
		
		for(Section section : sections) {
			routeDuration += section.getPassageDuration();
		}
		
		routeDuration += deliveryArrival.getDeliveryDuration();
		
		return routeDuration;
	}
	
	/**
	 * @brief Get the departure delivery of the route
	 * @return The departure delivery of the route
	 */
	public Delivery getDeliveryDeparture() {
		return deliveryDeparture;
	}
	
	/**
	 * @brief Get the arrival delivery of the route
	 * @return The departure delivery of the route
	 */
	public Delivery getDeliveryArrival() {
		return deliveryArrival;
	}

}
