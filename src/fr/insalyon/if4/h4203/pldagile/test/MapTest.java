package fr.insalyon.if4.h4203.pldagile.test;

import modele.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class MapTest {

	@Test
	public void test() {
		OMap map = new OMap();
		
		map.addIntersection(1,1,1);	//Test fails here with NullPointerException
		map.addIntersection(5,5,2);	
		map.addSection(0, 1, 5, 5, "test");
	}

}
