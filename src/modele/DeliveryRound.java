package modele;

import java.util.List;

public class DeliveryRound {
	private int warehouseDepartureTime;
	private List<Route> journey;
	
	DeliveryRound(int warehouseDepartureTime, List<Route> journey) {
		this.warehouseDepartureTime = warehouseDepartureTime;
		this.journey = journey;
	}
	
	int getDeliveryRoundDuration() {
		int deliveryRoundDuration = 0;
		
		for(Route route : journey) {
			deliveryRoundDuration += route.getRouteDuration();
		}
		
		return deliveryRoundDuration;
	}

}
