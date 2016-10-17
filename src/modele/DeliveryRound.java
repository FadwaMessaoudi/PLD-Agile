package modele;

import java.util.List;

public class DeliveryRound {
	private int warehouseDepartureTime;
	private List<Route> journey;
	
	public DeliveryRound(int warehouseDepartureTime, List<Route> journey) {
		this.warehouseDepartureTime = warehouseDepartureTime;
		this.journey = journey;
	}
	
	public int getDeliveryRoundDuration() {
		int deliveryRoundDuration = 0;
		
		// TODO
		for(Route route : journey) {
			deliveryRoundDuration += route.getRouteDuration();
		}
		
		return deliveryRoundDuration;
	}
	
}
