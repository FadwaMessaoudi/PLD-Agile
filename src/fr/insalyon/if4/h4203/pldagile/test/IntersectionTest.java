package fr.insalyon.if4.h4203.pldagile.test;

import modele.Intersection;

import static org.junit.Assert.fail;

import org.junit.Test;
import static org.junit.Assert.*;

public class IntersectionTest {
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void intersectionTest()
	{
		Intersection intersection = new Intersection(5,5,0);
		assertEquals(5,intersection.getX());
		assertEquals(5,intersection.getY());
		assertEquals(0,intersection.getId());
	}

}
