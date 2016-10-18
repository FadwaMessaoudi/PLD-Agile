package fr.insalyon.if4.h4203.pldagile.test;

import modele.Intersection;
import modele.Section;

import static org.junit.Assert.*;

import org.junit.Test;

public class SectionTest {
	
	@Test
	public void startNotEqualEnd() {
		Intersection i1 = new Intersection(1,1,1);
		Intersection i2 = new Intersection(5,5,2);
		
		Section s1 = new Section("s1", 10, 5, i1, i2);
		assertEquals(2,s1.getPassageDuration());
		assertEquals("s1",s1.getName());
		assert(s1.getIntersectionStart() != s1.getIntersectionEnd());
	}

}
