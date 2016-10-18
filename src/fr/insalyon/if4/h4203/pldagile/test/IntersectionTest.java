package fr.insalyon.if4.h4203.pldagile.test;

import modele.Intersection;

import static org.junit.Assert.fail;

import org.junit.Test;
import static org.junit.Assert.*;

public class IntersectionTest {
	
	
	@Test
	public void intersectionTest()
	{
		Intersection testIntersection = new Intersection(5,5,0);
		assertEquals(5,testIntersection.getX());
		assertEquals(5,testIntersection.getY());
		assertEquals(0,testIntersection.getId());
	}

}
