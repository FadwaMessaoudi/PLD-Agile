package fr.insalyon.if4.h4203.pldagile.test;

import modele.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class MapTest {

	@Test
	public void test() {
		OMap map = new OMap();
		map.addIntersection(5, 5, 0);
		map.addIntersection(10, 10, 1);
		map.addSection(0, 1, 5, 5, "test");
	}

}
