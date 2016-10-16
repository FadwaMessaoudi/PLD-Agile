package modele;

public class Delivery {
	private int deliveryDuration;
	private Intersection address;
	
	Delivery(Intersection address, int deliveryDuration) {
		this.address = address;
		this.deliveryDuration = deliveryDuration;
	}
	
	int getDeliveryDuration() {
		return deliveryDuration;
	}
	
	Intersection getAddress() {
		return address;
	}
}
