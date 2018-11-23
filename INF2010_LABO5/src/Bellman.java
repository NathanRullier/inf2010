import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;


public class Bellman {
	private Graph graph;
	private Node sourceNode;
	private List<Vector<Double>> piTable =  new ArrayList<Vector<Double>>();
	private List<Vector<Integer>> rTable =  new ArrayList<Vector<Integer>>();
	
	public Bellman (Graph g) {
		this.graph = g;
	}
	
	public void setSourceNode(Node source) {
		this.sourceNode = source;
	}
	
	public void shortestPath() {
		boolean shortestPathFound = false;
		int iteration = 1;
		Vector<Double> vectorDblToAdd = new Vector<Double>(graph.getNodes().size());
		Vector<Integer> vectorIntToAdd = new Vector<Integer>(graph.getNodes().size());
		for(int i = 0 ; i< graph.getNodes().size(); i++) {

			if(i==0) {
				vectorDblToAdd.add(0.0);
			}else {
				vectorDblToAdd.add(99999.0);
			}
			if(vectorDblToAdd.get(i)== 99999.0) {
				vectorIntToAdd.add(null);
			}
			else {
				vectorIntToAdd.add(i);
			}
			
		}
		
		while(!shortestPathFound) {
			for(int i =0 ; i < graph.getNodes().size(); i++) {
				piTable.get(iteration).add(99999.0);
				rTable.get(iteration).add(null);
			}
			for(int i =0 ; i < piTable.get(iteration-1).size(); i++) {
				
				if(piTable.get(iteration-1).get(i) != 99999.0) {
					List<Edge> edgeTotest = graph.getOutEdges(graph.getNodeById(i));
					
					for(int j =0; j < edgeTotest.size(); j++) {
							
						Double newValueToTest = piTable.get(iteration-1).get(i) + edgeTotest.get(j).getDistance();
						int idNode = edgeTotest.get(j).getDestination().getId();
						
						if(newValueToTest < piTable.get(iteration-1).get(edgeTotest.get(j).getDestination().getId())) {
							
							piTable.get(iteration).set(idNode ,newValueToTest);
							rTable.get(iteration).set(idNode, i);
						}
					}
				}
			}
			iteration++;
			if(piTable.get(iteration-1) == piTable.get(iteration) && rTable.get(iteration) == rTable.get(iteration-1)) {
				shortestPathFound = true;
			}
		}

		
	}
	
	public void  diplayShortestPaths() {
		//Compl�ter
	}

	public void displayTables() {
	 //Compl�ter
	}
}
