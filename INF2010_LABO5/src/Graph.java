import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {

	private List<Node> nodes = new ArrayList<Node>(); // Noeuds
	private List<Edge> edges = new ArrayList<Edge>();; // Les arcs
	static final double inf = 99999;

	public Graph() {

	}

	public void readFromFile(String filePath, String separtor) throws IOException {
		File file = new File(filePath);
		FileReader lecteur = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(lecteur);
		String line = bufferedReader.readLine();
		System.out.println(line);
		String[] ligneSepare = line.split(separtor);
		for (int i = 0; i < ligneSepare.length; i++) {
			nodes.add(new Node(i, ligneSepare[i]));
		}
		for (int i = 0; i < ligneSepare.length; i++) {
			line = bufferedReader.readLine();
			ligneSepare = line.split(separtor);
			for (int j = 0; j < ligneSepare.length; j++) {
				if (!ligneSepare[j].equals("inf")) {
					double tempDouble = Double.parseDouble(ligneSepare[j]);
					edges.add(new Edge(nodes.get(i), nodes.get(j),tempDouble));
				}
			}

		}
		bufferedReader.close();
	}

	public List<Edge> getOutEdges(Node source) {
		List<Edge> outEdges = new ArrayList<Edge>();
		for (int i = 0; i < edges.size(); i++) {
			if (edges.get(i).getSource() == source) {
				outEdges.add(edges.get(i));
			}
		}
		return outEdges;
	}

	public List<Edge> getInEdges(Node dest) {
		List<Edge> inEdges = new ArrayList<Edge>();
		for (int i = 0; i < edges.size(); i++) {
			if (edges.get(i).getDestination() == dest) {
				inEdges.add(edges.get(i));
			}
		}
		return inEdges;
	}

	// Accesseurs
	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public Node getNodeByName(String name) {
		for (Node node : nodes) {
			if (node.getName().equals(name)) {
				return node;
			}
		}
		return null;
	}

	public Node getNodeById(int id) {
		for (Node node : nodes) {
			if (node.getId() == id) {
				return node;
			}

		}
		return null;
	}
}
