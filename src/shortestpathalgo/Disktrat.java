package shortestpathalgo;

import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Class who describe the algorithm of Disktrat applied on a graph from a chosen
 * node of it
 * 
 * @author Pierre-Louis LEFEBVRE
 */
public class Disktrat {
	private Graph graph;
	private int departure;
	private Map<Integer, Integer> predecessors;
	private Map<Integer, Integer> distances;
	private Set<Integer> completedNodes;
	private Set<Integer> visitedNodes;

	/**
	 * Constructor of the Disktrat calculator
	 * 
	 * @param graph
	 *            the graph on which the algorithm will be applied
	 * @param departure
	 *            the indice of the departure node for the algorithm
	 */
	public Disktrat(Graph graph, int departure) {
		this.graph = graph;
		this.departure = departure;
		this.predecessors = new HashMap<Integer, Integer>();
		this.distances = new HashMap<Integer, Integer>();
		this.completedNodes = new HashSet<Integer>();
		this.visitedNodes = new HashSet<Integer>();
	}

	/**
	 * compute the Disktrat algorithm
	 */
	public void compute() {
		
		distances.put(departure, 0);
		int minimalDistanceVisited = 0;

		while (!visitedNodes.isEmpty()) {
			minimalDistanceVisited = getMinimalDistanceVisited();
			List<Integer> successors = graph.getSuccessors(minimalDistanceVisited);

			for (int successor : successors) {
				if (!completedNodes.contains(successor)) {
					graph.release(departure, successor, predecessors, distances);

					if (!visitedNodes.contains(successor)) {
						visitedNodes.add(successor);
					}
				}
			}

			visitedNodes.remove(minimalDistanceVisited);
			completedNodes.add(minimalDistanceVisited);
		}
	}

	/**
	 * after calling compute(), give the predecessor of node given in parameter
	 * 
	 * @param node
	 *            the indice of the node
	 * @return the indice of the predecessor
	 */
	public Integer getPredecessor(int i) {
		return predecessors.get(i);
	}

	/**
	 * after calling compute(), give the distance from the departure to the
	 * others nodes of the graph
	 * @param node : the other node of the graph
	 * @return the cost of the path
	 */
	public Integer getDistance(int node) {
		return distances.get(node);
	}

	private Integer getMinimalDistanceVisited() {

		Integer minimalDistanceVisited = null;

		if (visitedNodes.contains(departure)) {
			minimalDistanceVisited = departure;

		} else {
			for (Integer node : visitedNodes) {
				// if a minimal Distance visited node ins't already defined
				if (distances.get(node) != null) { // distance of node isn't infinite
					if (minimalDistanceVisited == null) {
						minimalDistanceVisited = node;
					}
					else if (distances.get(node) < distances.get(minimalDistanceVisited)) {
						minimalDistanceVisited = node;
					}
				}
			}
		}

		return minimalDistanceVisited;
	}
}
