
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.TestGraphs;

import java.util.Collection;

// Servers as a utility class to generate request graphs
public class GraphGenerator {
	

	public static Graph<String, Number> generateGraph(int nodes) {

		int layers = nodes/2;

		Graph<String, Number> graph;
		do {
			graph = TestGraphs.createDirectedAcyclicGraph(
					layers, nodes / layers, 0.5);
			String resultVertex = "Result";
			graph.addVertex(resultVertex);
			for(String vertex : graph.getVertices()) {
				if(!vertex.equals(resultVertex) && graph.getOutEdges(vertex).isEmpty())
					graph.addEdge(System.nanoTime() + Math.random(), vertex, resultVertex);
			}
			// TestGraph graph = new TestGrap();
			System.out.println(graph.getVertexCount());
		} while(!validateGraph(graph,nodes));

		return graph;

	}

	// Checks if this graph is valid for our purposes and transforms it to a
	// valid graph if possible
	// There should be no isolated vertices
	// There should be some vertices with no incoming edges (DataServices) at
	// least one
	public static boolean validateGraph(Graph<String, Number> graph, int nodes) {
		Collection<String> vertices = graph.getVertices();

		boolean valid = true;

		if(vertices.size() != nodes)
			valid = false;
		
		for (String vertex : vertices) {
			if (graph.inDegree(vertex) + graph.outDegree(vertex) == 0)
				valid = false;
		}

		return valid;
	}

}
