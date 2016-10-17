package modele;

public class Delivery {
	private int deliveryDuration;
	private Intersection address;
	
	public Delivery(Intersection address, int deliveryDuration) {
		this.address = address;
		this.deliveryDuration = deliveryDuration;
	}
	
	public int getDeliveryDuration() {
		return deliveryDuration;
	}
	
	public Intersection getAddress() {
		return address;
	}
}
