
public class minitest {

	public static void main(String[] args) {
		Graph<String, Void> graph = new SearchableGraph<String, Void>(true, true);
		
		
		System.out.println("adding vertices ...");
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		
		System.out.println("adding edges ...");
		graph.addEdge("A", "B", 2);
		graph.addEdge("A", "D", 1);
		graph.addEdge("B", "D", 3);
		graph.addEdge("B", "E", 10);
		graph.addEdge("C", "A", 4);
		graph.addEdge("C", "F", 5);
		graph.addEdge("D", "C", 2);
		graph.addEdge("D", "E", 2);
		graph.addEdge("D", "F", 8);
		graph.addEdge("D", "G", 4);
		graph.addEdge("E", "G", 6);
		graph.addEdge("G", "F", 1);
		
		//graph.shortestPath(A, F);
	}
}
