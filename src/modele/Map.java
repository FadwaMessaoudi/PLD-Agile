package modele;

import java.util.List;

public class Map {
	private DeliveryOrder deliveryOrder;
	private DeliveryRound deliveryRound;
	private List<Intersection> intersections;
	private List<Section> sections;
	
	Map()  {
		
	}
	
	void addIntersection(int x, int y) {
		intersections.add(new Intersection(x,y));
	}
	
	void addSection(int start, int end, int length, int averageSpeed, String name) {
		sections.add(new Section(name, length, averageSpeed, intersections.get(start), intersections.get(end)));
	}

}
