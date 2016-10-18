package fr.insalyon.if4.h4203.pldagile.test;

import static org.junit.Assert.*;

import org.junit.Test;

import modele.*;

import java.util.LinkedList;
import java.util.List;

public class RouteTest {

	@Test
	public void routeTest() {
		Intersection testIntersection1 = new Intersection(5,5,0);
		Intersection testIntersection2 = new Intersection(10,10,1);
		Delivery testDelivery1 = new Delivery(testIntersection1, 3);
		Delivery testDelivery2 = new Delivery(testIntersection2, 10);
		Route testRoute = new Route(testDelivery1,testDelivery2);
		
		Intersection testIntersection4 = new Intersection(9,9,3);
		
		Section s1 = new Section("s1", 10, 5, testIntersection1 , testIntersection2);
		Section s2 = new Section("s2", 10, 10, testIntersection2, testIntersection4);
		List <Section> sections = new LinkedList<Section>();
		
		testRoute = new Route (testDelivery1,testDelivery2,sections);
		testRoute.addSection(s1);
		testRoute.addSection(s2);
		
		assertEquals(13,testRoute.getRouteDuration());
		
		assertEquals(testDelivery1,testRoute.getDeliveryDeparture());
		assertEquals(testDelivery2,testRoute.getDeliveryArrival());
		
		
		
	 }

}
