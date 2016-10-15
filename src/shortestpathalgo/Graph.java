package shortestpathalgo;

/**
 * Interface between the shortests paths algorithms and the graph on which it is working
 * @author Pierre-Louis LEFEBVRE
 */

public interface Graph {

	/**
	 * method to release a arc in a Graph for the search of shortest paths
	 * 
	 * @param departure
	 *            the departure indices of the arc
	 * @param arrival
	 *            the arrival indices of the arc
	 * @param predecessors
	 *            the tab of the predecessors in the search
	 * @param distance
	 * 			  the tab of the distance from the departure (sum of costs) in the search
	 */
	void release(int departure, int arrival, int[] predecessors, int[] distance);

	/**
	 * @return the number of nodes in the graph
	 */
	int numberOfNodes();
	
	/**
	 * @param node 
	 * 			the indice of the node whose we want the successors
	 * @return the indice tab of the successors of the node
	 */
	int[] getSuccessors(int node);
}
