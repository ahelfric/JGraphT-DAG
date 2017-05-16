import org.jgrapht.experimental.dag.*;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph.CycleFoundException;
import org.jgrapht.graph.DefaultEdge;

public class DAGProject {

	public static void main(String[] args) {
		//Create a DAG with integers as vertices and the DefaultEdge object defined in the
		//JGraphT library as edges
		DirectedAcyclicGraph<String, DefaultEdge> dag = new DirectedAcyclicGraph<>(DefaultEdge.class);
		
		//Add some vertices to the DAG and display the contents
		dag.addVertex("1");
		dag.addVertex("2");
		dag.addVertex("3");
		dag.addVertex("4");
		System.out.println(dag.toString());
		
		//Properly use the addDagEdge() method and display the contents
		try {
			dag.addDagEdge("1", "2");
			dag.addDagEdge("2", "3");
			dag.addDagEdge("3", "4");
		} catch (CycleFoundException e) {
			e.printStackTrace();
		}
		System.out.println(dag.toString());
		
		//Purposefully have addDagEdge() throw an exception
		try {
			dag.addDagEdge("4", "1");
		} catch (CycleFoundException e) {
			e.printStackTrace();
		}
		
		//Display the contents of the DAG
		System.out.println(dag.toString());
		
		//Acknowledge that the addEdge() method can work without a try-catch block
		dag.addEdge("2", "4");
		
		//Display the contents of the DAG
		System.out.println(dag.toString());
		
		//Show that addEdge() throws an IllegalArgumentException when used improperly
		try {
			dag.addEdge("4", "1");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		//Remove "4" from the DAG and display the contents
		dag.removeVertex("4");
		System.out.println(dag.toString());
		
		//Add "4" and "5" and associated edges (3, 4) and (3, 5)
		dag.addVertex("4");
		dag.addVertex("5");
		try {
			dag.addDagEdge("3", "4");
			dag.addDagEdge("3", "5");
		} catch (CycleFoundException e) {
			e.printStackTrace();
		}
		
		//Display the ancestors of "4"
		System.out.println(dag.getAncestors(dag, "4").toString());
		
		//Display the descendants of "2"
		System.out.println(dag.getDescendants(dag, "2").toString());
	}
}
