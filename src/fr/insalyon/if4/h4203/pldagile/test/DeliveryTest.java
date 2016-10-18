package fr.insalyon.if4.h4203.pldagile.test;

import static org.junit.Assert.*;

import org.junit.Test;
import modele.Delivery;
import modele.Intersection;

public class DeliveryTest {

	@Test
	public void deliveryTest() {
		Intersection testIntersection = new Intersection(5,5,0);
		Delivery testDelivery = new Delivery(testIntersection, 3);
		assertEquals(3, testDelivery.getDeliveryDuration());
		assertEquals(testIntersection,testDelivery.getAddress());
	}

}
