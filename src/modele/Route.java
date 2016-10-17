package modele;

import java.util.List;

public class Route {
	private Delivery deliveryDeparture;
	private Delivery deliveryArrival;
	private List<Section> sections;
	
	public Route(Delivery deliveryDeparture, Delivery deliveryArrival) {
		this.deliveryDeparture = deliveryDeparture;
		this.deliveryArrival = deliveryArrival;
	}
	
	public Route(Delivery deliveryDeparture, Delivery deliveryArrival, List<Section> sections) {
		this.deliveryDeparture = deliveryDeparture;
		this.deliveryArrival = deliveryArrival;
		this.sections=sections;
	}
	
	public boolean addSection(Section section) {
		return sections.add(section);
	}
	
	public int getRouteDuration() {
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
	
	public Delivery getDeliveryDeparture() {
		return deliveryDeparture;
	}
	
	public Delivery getDeliveryArrival() {
		return deliveryArrival;
	}

}
