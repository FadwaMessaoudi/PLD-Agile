package modele;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import javafx.util.Pair;

import shortestpathalgo.Disktrat;
import shortestpathalgo.Graph;

import tsp.TSP;
import tsp.TSP1;

// TODO the class has to be renamed because Map already exists in java and is used here
public class OMap implements Graph {
	private DeliveryOrder deliveryOrder;
	private DeliveryRound deliveryRound;
	private Map<Integer,Intersection> intersections;
	private Map<Pair<Integer, Integer>, Section> sections;

	public OMap() {

	}

	public void addIntersection(int x, int y, int id) {
		intersections.put(id, new Intersection(x,y,id));
	}

	public void addSection(int start, int end, int length, int averageSpeed, String name) {
		sections.put(new Pair<Integer, Integer>(start, end),
				new Section(name, length, averageSpeed, intersections.get(start), intersections.get(end)));
	}
	
	public void buildeDeliveryOrder(int warehouseId, int[][] deliveries) {
		deliveryOrder = new DeliveryOrder(0, intersections.get(warehouseId));
		
		for(int i = 0; i < deliveries.length; i++) {
			deliveryOrder.addDelivery(new Delivery(intersections.get(deliveries[i][0]), deliveries[i][1]));
		}
		
		
	}

	/**
	 * Compute the deliveryRound by creating the possibles Routes in function of
	 * the deliveries of the deliveryOrder and sort them by the method of the
	 * TSP
	 */

	public void computeRound() {
		// all the deliveries + the warehouse
		int stopsNumber = deliveryOrder.getDeliveries().size() + 1;
		int[][] costs = new int[stopsNumber][stopsNumber];

		Route[][] possiblesRoutes = getShortestRouteForDeliveries(costs);

		int[] stopsDurations = new int[stopsNumber];
		int[] deliveriesDurations = deliveryOrder.getDeliveriesDurations();
		TSP tsp = new TSP1();

		// no stop duration at the warehouse
		stopsDurations[0] = 0;
		for (int i = 0; i < stopsNumber - 1; i++) {
			// TODO : code can be avoid if warehouse is the first delivery in
			// the deliveyOrder
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
	 * Use the Disktrat algorithm to return all the shortest routes in the map
	 * to go from one delivery to another
	 * 
	 * @param costs
	 *            : costs[i][j] is cost of the Route[i][j] (sum of sections
	 *            durations of the Route + the delivery duration between each
	 *            section) (/!\ tab modified by the method)
	 * @return the tab of the routes : Route[i][j] is the route to go from the
	 *         delivery i to the delivery j in the deliveryOrder List
	 */

	private Route[][] getShortestRouteForDeliveries(int[][] costs) {
		Route[][] routes;

		if (deliveryOrder != null) {		
			List<Delivery> deliveries = new ArrayList<Delivery>();
			//the warehouse is now considered as the first delivery
			deliveries.add(new Delivery(deliveryOrder.getWarehouseAddress(), 0));
			deliveries.addAll(deliveryOrder.getDeliveries());
			
			int stopsNumber = deliveries.size();
			routes = new Route[stopsNumber][stopsNumber];
			
			for (int i = 0; i < stopsNumber; i++) {
				int departureIndice = deliveries.get(i).getAddress().getId();
				Disktrat disktrat = new Disktrat(this, departureIndice);
				disktrat.compute();
				
				for (int j = 0; j < stopsNumber; j++) {
					
					if (j != i) {
						int arrivalIndice = deliveries.get(j).getAddress().getId();
						costs[i][j] = disktrat.getDistance(arrivalIndice);
						List<Section> routeSections = new LinkedList<Section>();
						
						// add backwardly all the section in the future Route List to the departure
						while (arrivalIndice != departureIndice)
						{
							int predecessorIndice = disktrat.getPredecessor(arrivalIndice);
							routeSections.add(0, sections.get(new Pair<Integer, Integer>(arrivalIndice, predecessorIndice)));
							arrivalIndice = predecessorIndice;
						}
						
						
						routes[i][j] = new Route(deliveries.get(i), deliveries.get(j), routeSections);
					}
				}
			}

		} else {
			throw new NullPointerException("deliveryOrder not defined before disktrat");
		}

		return routes;
	}

	@Override
	public void release(Integer departure, Integer arrival, Map<Integer, Integer> predecessors, Map<Integer, Integer> distances) {
		Section section = sections.get(new Pair<Integer, Integer>(departure, arrival));

		if (section != null) {
			int cost = section.getPassageDuration();

			if (distances.get(arrival) > distances.get(departure) + cost) {
				distances.put(arrival, distances.get(departure) + cost);
				predecessors.put(arrival, departure);
			}

		} else {
			throw new NullPointerException("section " + departure + " to " + arrival + " doesn't exists");
		}
	}

	@Override
	public List<Integer> getSuccessors(Integer node) {	
		List<Integer> successors = new LinkedList<Integer>();	
		Set<Integer> ints = intersections.keySet();
		
		for(Integer intersection : ints) {			
			if(sections.containsValue(new Pair<Integer, Integer>(node, intersection))) {
				successors.add(intersection);
			}
		}
		
		return successors;
	}
}
