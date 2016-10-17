package modele;

import java.util.List;

public class DeliveryOrder {
	private int warehouseDepartureTime;
	private Intersection warehouseAddress;
	private List<Delivery> deliveries;
	
	DeliveryOrder(int warehouseDepartureTime, Intersection warehouseAddress) {
		this.warehouseDepartureTime = warehouseDepartureTime;
		this.warehouseAddress = warehouseAddress;
	}
	
	boolean addDelivery(Delivery delivery) {
		return deliveries.add(delivery);
	}
	
	int[] getDeliveriesDurations() {
		int[] deliveriesDurations = new int[deliveries.size() + 1];
		
		deliveriesDurations[0] = 0;
		
		for (int i = 1; i<deliveries.size() + 1; i++) {
			deliveriesDurations[i] = deliveries.get(i).getDeliveryDuration();
		}
		
		return deliveriesDurations;
	}
	
	int getWarehouseDepartureTime() {
		return warehouseDepartureTime;
	}
	
	Intersection getWarehouseAddress() {
		return warehouseAddress;
	}
	
	List<Delivery> getDeliveries() {
		return deliveries;
	}
}
