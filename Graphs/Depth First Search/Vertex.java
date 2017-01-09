package newLinkedList;

public class Vertex {
	String name;
	Neighbour adjList;
	Vertex(String name, Neighbour neighbour){
		this.name = name;
		this.adjList = neighbour;
	}

}
