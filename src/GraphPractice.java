import org.jgrapht.experimental.dag.*;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph.CycleFoundException;
import org.jgrapht.graph.DefaultEdge;

public class GraphPractice {
	
	public static void main(String[] args) {
		//Create a DAG with Strings as vertices and the DefaultEdge object defined in the 
		//JGraphT library as edges
		DirectedAcyclicGraph<String, DefaultEdge> graph = new DirectedAcyclicGraph<>(DefaultEdge.class);
		
		//Add vertices of type String to the DAG graph
		graph.addVertex("Start");
		graph.addVertex("Second");
		graph.addVertex("Third");
		
        System.out.println(graph.toString());;

		// TODO I need addDagEdge (both versions?) and addEdge (use a try catch block) and addVertex
		
		//Show the correct usage of addDagEdge
		try {
			graph.addDagEdge("Start", "Second");
			graph.addDagEdge("Second", "Third");
		} catch (CycleFoundException e) {
			e.printStackTrace();
		}
        System.out.println(graph.toString());;
		
		//Show how the error pops up when a cycle is attempted
		try {
			graph.addDagEdge("Third", "Start");
		} catch (CycleFoundException e) {
			e.printStackTrace();
		}
        System.out.println(graph.toString());;
		
        //Show the remove vertex method
		graph.removeVertex("Second");
		
		//See how the edges have also been deleted? Now there are only two unconnected vertices
        System.out.println(graph.toString());;
        
        //Add "Second" back to the graph, and connect "start" to "second", and "second" to "third".
		graph.addVertex("Second");
        graph.addEdge("Start", "Second");
		graph.addEdge("Second", "Third");
        System.out.println(graph.toString());;
        //One big thing to note here, is that addVertex adds vertices in topological order. 
        //So, when it is listed by the toString method, it comes after "Third"
        //However, in still comes between "Start" and "Third" as defined by their edges
        
        graph.addEdge("Third", "Start");
        //This causes a runtime error IllegalArgumentException, caused by a uncaught CycleFoundException. 
        //This is because addEdge doesn't automatically throw a CycleFoundException
        
		// TODO also need to use getAncestors and getDescendents somehow
		System.out.println();
		// TODO how does the iterator work?
		
		// TODO need to use the remove all vertices, or at least the removeVertex. See what that does
		
		//Print out a string of the parenthesized pair (Vertex, Edge) representing the DAG graph
		//This method is inherited from the AbstractGraph<V,E> class
        System.out.println(graph.toString());;
	}
}
