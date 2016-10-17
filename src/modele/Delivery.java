package modele;

public class Delivery {
	/**
	 * @brief Duration of the delivery
	 */
	private int deliveryDuration;
	
	/**
	 * @brief Address of the delivery
	 * 
	 * Intersection where the delivery is located
	 */
	private Intersection address;
	
	/**
	 * @brief Constructor for a delivery
	 * @param address The intersection where the delivery is located
	 * @param deliveryDuration Duration of the delivery
	 */
	public Delivery(Intersection address, int deliveryDuration) {
		this.address = address;
		this.deliveryDuration = deliveryDuration;
	}
	
	/**
	 * @brief Return the duration of the delivery
	 * @return The duration of the delivery
	 */
	public int getDeliveryDuration() {
		return deliveryDuration;
	}
	
	/**
	 * @brief Return the address of the delivery
	 * @return The intersection where the delivery is located
	 */
	public Intersection getAddress() {
		return address;
	}
}
