// TODO: Remove each 'todo' comment once I implement each part!

// TODO: class comment header

import java.util.*;

public class SearchableGraph<V, E> extends AbstractGraph<V, E> {

	// TODO: comment header
	public SearchableGraph() {
		super();
	}
	
	// TODO: comment header
	public SearchableGraph(boolean directed, boolean weighted) {
		super(directed, weighted);
	}
	
	// TODO: comment header
	public boolean isReachable(V v1, V v2) {
		clearVertexInfo();
		if (v1 == null || v2 == null){
			throw new NullPointerException("null arguments");
		}
		if (this.containsVertex(v1) == false || this.containsVertex(v2) == false){
			throw new IllegalArgumentException("doesnt contain vertex");
		}
		if (v1.equals(v2)){
			return true;
		}
		
		return depthFirstSearch(v1, v2);
		
		
	}
	
	private boolean depthFirstSearch(V v1, V v2){
		Vertex<V> v1info = vertexInfo(v1);
		v1info.setVisited(true);
		
		if(v1.equals(v2)){
			return true;
		}else{
		
		
		Set<V> v1neighbors = neighbors(v1);
		for (V neighbor : v1neighbors){
			Vertex<V> neighborInfo = vertexInfo(neighbor);
			if(neighborInfo.visited() == false){
				if(depthFirstSearch(neighbor, v2)){
					return true;
				}
			
				}
			}
		}
		return false;
	}
	
	// TODO: comment header
	public List<V> minimumWeightPath(V v1, V v2) {
		clearVertexInfo();
		if (v1 == null || v2 == null){
			throw new NullPointerException("null arguments");
		}
		if (this.containsVertex(v1) == false || this.containsVertex(v2) == false){
			throw new IllegalArgumentException("doesnt contain vertex");
		}
		
		
		List<V> shortest = new LinkedList<V>();
		shortest.add(v1);
		
		if (v1.equals(v2)){
			return shortest;
		}
		if (this.containsEdge(v1, v2)){
			shortest.add(v2);
			return shortest;
		}
		
		Vertex<V> v1info = vertexInfo(v1);
		v1info.setVisited(true);
		
		V vtemp = v1;
		V previous = vtemp;
		Vertex<V> vtempInfo = vertexInfo(vtemp);
		vtempInfo.setPrevious(previous);
		List<V> shortestFinal = new LinkedList<V>();
		
		while (!shortest.isEmpty()){
			//base case for first vertex
			if(shortestFinal.size() <= 1){
			vtemp = shortest.remove(0);
			}
			else {
				//if you end up with the desired final node in the set of possibilities, use it!
				if(shortest.contains(v2)){
					vtemp = v2;	
					}else{
						//if not, check to see if a member of the possibilities connects to the final node, if so, use it
						boolean isTrue = false;
						for (V v : shortest){
							if(this.containsEdge(v, v2)){
								vtemp = v;
								isTrue = true;
							}
					}
						//if not, then just grab the next neighbor and iterate
						 if (isTrue == false){
								vtemp = shortest.remove(0);
								}
				}
			}
			
			//if you've gotten to the desired node, you're done, print the shortest path
			if (vtemp.equals(v2)){
				shortestFinal.add(vtemp);
				return shortestFinal;
			}
			
			//add the set of unvisited neighbors to the possibilities
			Set<V> vtempneighbors = neighbors(vtemp);
			for (V neighbor : vtempneighbors){
				Vertex<V> neighborInfo = vertexInfo(neighbor);
				if(neighborInfo.visited() == false){
					neighborInfo.setVisited(true);
					shortest.add(neighbor);
				}
			}
			//keep track of the previous node you visited and add it to the shortest path list
			previous = vtemp;
			vtempInfo.setPrevious(previous);
			shortestFinal.add(previous);
		}
		return null;
	}

	// TODO: comment header
	public List<V> shortestPath(V v1, V v2) {
		// TODO: implement this method
		return null;
	}
}
