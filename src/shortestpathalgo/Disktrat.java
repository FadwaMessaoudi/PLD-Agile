package shortestpathalgo;

import java.util.HashSet;
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
	private int[] predecessors;
	private int[] distances;
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
		this.predecessors = new int[graph.numberOfNodes()];
		this.distances = new int[graph.numberOfNodes()];
		this.completedNodes = new HashSet<Integer>();
		this.visitedNodes = new HashSet<Integer>();
	}

	/**
	 * compute the Disktrat algorithm
	 */
	public void compute() {

		for(int i = 0; i < distances.length; i++) {
			distances[i] = Integer.MAX_VALUE;
		}
		
		distances[departure] = 0;
		int minimalDistanceVisited = 0;

		while (!visitedNodes.isEmpty()) {
			minimalDistanceVisited = getMinimalDistanceVisited();
			int[] successors = graph.getSuccessors(minimalDistanceVisited);

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
	public int getPredecessor(int i) {
		return predecessors[i];
	}

	/**
	 * after calling compute(), give the distance from the departure to the
	 * others nodes of the graph
	 * @param node : the other node of th graph
	 * @return the cost of the path
	 */
	public int getDistance(int node) {
		return distances[node];
	}

	private int getMinimalDistanceVisited() {

		int minimalDistanceVisited = 0;

		if (visitedNodes.contains(departure)) {
			minimalDistanceVisited = departure;

		} else {
			for (int node : visitedNodes) {
				// if a minimal Distance visited node ins't already defined
				if (distances[node] < distances[minimalDistanceVisited]) {
					minimalDistanceVisited = node;
				}
			}
		}

		return minimalDistanceVisited;
	}
}
