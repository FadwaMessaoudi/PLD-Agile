package modele;

import java.util.List;

public class DeliveryOrder {
	/**
	 * @brief The departure time from the warehouse
	 */
	private int warehouseDepartureTime;
	
	/**
	 * @brief Address of the warehouse
	 * 
	 * Intersection where the warehouse is located
	 */
	private Intersection warehouseAddress;
	
	/**
	 * @brief List of deliveries composing the delivery order
	 */
	private List<Delivery> deliveries;
	
	/**
	 * @brief Constructor for a delivery order
	 * @param warehouseDepartureTime The departure time from the warehouse
	 * @param warehouseAddress The intersection where the warehouse is located
	 */
	public DeliveryOrder(int warehouseDepartureTime, Intersection warehouseAddress) {
		this.warehouseDepartureTime = warehouseDepartureTime;
		this.warehouseAddress = warehouseAddress;
	}
	
	/**
	 * @brief Add a delivery to the list of deliveries
	 * @param delivery The delivery to add
	 * @return A boolean to know if everything went well
	 */
	public boolean addDelivery(Delivery delivery) {
		return deliveries.add(delivery);
	}
	
	/**
	 * @brief Get the durations of all the deliveries, including the warehouse
	 * @return The durations of all the deliveries with the warehouse in the first place
	 */
	public int[] getDeliveriesDurations() {
		int[] deliveriesDurations = new int[deliveries.size() + 1];
		
		deliveriesDurations[0] = 0;
		
		for (int i = 1; i<deliveries.size() + 1; i++) {
			deliveriesDurations[i] = deliveries.get(i).getDeliveryDuration();
		}
		
		return deliveriesDurations;
	}
	
	/**
	 * @brief Get the departure time from the warehouse
	 * @return The departure time from the warehouse
	 */
	public int getWarehouseDepartureTime() {
		return warehouseDepartureTime;
	}
	
	/**
	 * @brief Get the address of the warehouse
	 * @return The intersection whre the warehouse is located
	 */
	public Intersection getWarehouseAddress() {
		return warehouseAddress;
	}
	
	/**
	 * @brief Get all the deliveries
	 * @return The list of deliveries
	 */
	public List<Delivery> getDeliveries() {
		return deliveries;
	}
}
