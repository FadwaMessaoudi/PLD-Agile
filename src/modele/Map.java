package modele;

import java.util.LinkedList;
import java.util.List;

import tsp.TSP;
import tsp.TSP1;


public class Map {
	private DeliveryOrder deliveryOrder;
	private DeliveryRound deliveryRound;
	private List<Intersection> intersections;
	private List<Section> sections;
	
	public Map() {
		
	}
	
	public void addIntersection(int x, int y) {
		intersections.add(new Intersection(x,y));
	}
	
	public void addSection(int start, int end, int length, int averageSpeed, String name) {
		sections.add(new Section(name, length, averageSpeed, intersections.get(start), intersections.get(end)));
	}

	/**
	 * Compute the deliveryRound by creating the possibles Routes in function of the deliveries of
	 * the deliveryOrder and sort them by the method of the TSP
	 */
	
	public void computeRound() {	
		int intersectionsNbr = intersections.size();
		
		Route[][] possiblesRoutes = getFastestRouteForDeliveries();
		
		// all the deliveries + the warehouse
		int stopsNumber = deliveryOrder.getDeliveries().size() + 1;
		int[][] costs = new int[stopsNumber][stopsNumber];
		int[] stopsDurations = new int[stopsNumber];
		int[] deliveriesDurations = deliveryOrder.getDeliveriesDurations();
		TSP tsp = new TSP1();
		
		// no stop duration at the warehouse
		stopsDurations[0] = 0;
		for (int i = 0; i < stopsNumber - 1; i++) {
			// TODO : code can be avoid if warehouse is the first delivery in the deliveyOrder 
			stopsDurations[i] = deliveriesDurations[i];
			
			for (int j = 0; j < stopsNumber; j++) {
				costs[i][j] = possiblesRoutes[i][j].getRouteDuration();
			}
		}
			
		tsp.searchSolution(Integer.MAX_VALUE, stopsNumber, costs, stopsDurations);
		
		List<Route> journey = new LinkedList<Route>(); 
		
		int departureIndice = 0;
		int arrivalIndice = 0;
		
		for (int i = 0; i < stopsNumber - 1; i++) {
			departureIndice = tsp.getBestSolution(i);
			arrivalIndice = tsp.getBestSolution(i + 1);
			journey.add(possiblesRoutes[departureIndice][arrivalIndice]);
		}
		
		// add the return from the last delivery to the warehouse
		journey.add(possiblesRoutes[stopsNumber - 1][0]);
		
		int warehouseDepartureTime = deliveryOrder.getWarehouseDepartureTime();
		
		deliveryRound = new DeliveryRound(warehouseDepartureTime, journey);
	}
	
	/**
	 * Use the Disktrat algorithm to return all the fastset routes in the map to go from one delivery to another
	 * @param costs : costs[i][j] is cost of the Route[i][j] (sum of sections durations of the Route + the delivery duration between each section)
	 * @return the tab of the routes : Route[i][j] is the route to go from the delivery i to the delivery j in the deliveryOrder List
	 */
	
	private Route[][] getFastestRouteForDeliveries(int[][] costs) throws NullPointerException {
		Route[][] routes;
		
		if (deliveryOrder != null) {
			int stopsNumber = deliveryOrder.getDeliveries().size() + 1;
			
			routes = new Route[stopsNumber][];
			
			
			
		
		} else {
			throw new NullPointerException("deliveryOrder not defined before disktrat");
		}
		
		return routes;
	}
	
	private Route[] disktrat(int[] costs) {
		
		return null;
	}
}
