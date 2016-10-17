package modele;

import java.util.List;

public class DeliveryRound {
	/**
	 * @brief Departure time from the warehouse
	 */
	private int warehouseDepartureTime;
	
	/**
	 * @brief The journey to deliver all the deliveries
	 * 
	 * The list of routes composing the journey
	 */
	private List<Route> journey;
	
	/**
	 * @brief Constructor of a delivery round
	 * @param warehouseDepartureTime Departure time from the warehouse
	 * @param journey The list of routes composing the journey to deliver all the deliveries
	 */
	public DeliveryRound(int warehouseDepartureTime, List<Route> journey) {
		this.warehouseDepartureTime = warehouseDepartureTime;
		this.journey = journey;
	}
	
	/**
	 * @brief Get the duration of the delivery round
	 * @return The duration of the delivery round
	 */
	public int getDeliveryRoundDuration() {
		int deliveryRoundDuration = 0;
		
		// TODO
		for(Route route : journey) {
			deliveryRoundDuration += route.getRouteDuration();
		}
		
		return deliveryRoundDuration;
	}
	
}
