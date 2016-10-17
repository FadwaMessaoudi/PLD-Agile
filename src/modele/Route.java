package modele;

import java.util.List;

public class Route {
	private Delivery deliveryDeparture;
	private Delivery deliveryArrival;
	private List<Section> sections;
	
	Route(Delivery deliveryDeparture, Delivery deliveryArrival) {
		this.deliveryDeparture = deliveryDeparture;
		this.deliveryArrival = deliveryArrival;
	}
	
	Route(Delivery deliveryDeparture, Delivery deliveryArrival, List<Section> sections) {
		this.deliveryDeparture = deliveryDeparture;
		this.deliveryArrival = deliveryArrival;
		this.sections=sections;
	}
	
	boolean addSection(Section section) {
		return sections.add(section);
	}
	
	int getRouteDuration() {
		int routeDuration = 0;
		
		for(Section section : sections) {
			routeDuration += section.getPassageDuration();
		}
		
		routeDuration =+ deliveryArrival.getDeliveryDuration();
		
		// TODO
		// duration of the delivery count in the TSP (param durations)
		// routeDuration += deliveryArrival.getDeliveryDuration();
		
		return routeDuration;
	}
	
	Delivery getDeliveryDeparture() {
		return deliveryDeparture;
	}
	
	Delivery getDeliveryArrival() {
		return deliveryArrival;
	}

}
