package fr.insalyon.if4.h4203.pldagile.test;

import static org.junit.Assert.*;

import org.junit.Test;
import modele.*;
import java.util.List;
import java.util.LinkedList;

public class DeliveryRoundTest {
	
	@Test
	public void deliveryRoundTest()	{
		
		Intersection testIntersection1 = new Intersection(5,5,0);
		Intersection testIntersection2 = new Intersection(10,10,1);
		Intersection testIntersection3 = new Intersection(6,6,2);
		Intersection testIntersection4 = new Intersection(9,9,3);
		Delivery testDelivery1 = new Delivery(testIntersection1, 3);
		Delivery testDelivery2 = new Delivery(testIntersection2, 5);
		Delivery testDelivery4 = new Delivery(testIntersection4, 5);
		List <Section> sections1 = new LinkedList<Section>();
		List <Section> sections2 = new LinkedList<Section>();
		Route testRoute1 = new Route(testDelivery1,testDelivery2,sections1);
		Route testRoute2 = new Route(testDelivery2,testDelivery4,sections2);
		
		Section s1 = new Section("s1", 2, 1, testIntersection1 , testIntersection2);
		Section s2 = new Section("s2", 3, 1, testIntersection2,testIntersection3);
		Section s3 = new Section("s3", 4, 1, testIntersection3, testIntersection4);
		
		testRoute1.addSection(s1);
		testRoute2.addSection(s2);
		testRoute2.addSection(s3);
		
		List <Route> testJourney = new LinkedList<Route>();
		testJourney.add(testRoute1);
		testJourney.add(testRoute2);
		
		DeliveryRound testDeliveryRound = new DeliveryRound(8,testJourney);
		assertEquals(19,testDeliveryRound.getDeliveryRoundDuration());
		
	}
}
