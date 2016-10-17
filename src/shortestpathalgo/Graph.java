package shortestpathalgo;

import java.util.List;
import java.util.Map;

/**
 * Interface between the shortests paths algorithms and the graph on which it is working
 * @author Pierre-Louis LEFEBVRE
 */

public interface Graph {

	/**
	 * method to release a arc in a Graph for the search of shortest paths
	 * 
	 * @param departure
	 *            the departure indice of the arc
	 * @param arrival
	 *            the arrival indice of the arc
	 * @param predecessors
	 *            the map of the predecessors by indice of node in the search
	 * @param distance
	 * 			  the map of the distance from the departure (sum of costs) by indice of node in the search
	 */
	public void release(Integer departure, Integer arrival, Map<Integer, Integer> predecessors, Map<Integer, Integer> distance);

	/**
	 * @param node 
	 * 			the indice of the node whose we want the successors
	 * @return the indice tab of the successors of the node
	 */
	public List<Integer> getSuccessors(Integer node);
}
