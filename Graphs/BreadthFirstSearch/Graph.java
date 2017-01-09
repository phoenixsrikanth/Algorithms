package newLinkedList;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.AbstractQueue;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Graph {
	
	private static final int INFINITY = 0;
	Vertex[] adjList;
	public boolean[] marked;
	public int[] edgeTo;
	public int[] distTo;
	
	public Graph(String file) throws FileNotFoundException{
		
		Scanner scan = new Scanner(new File(file));
		
		String  graphType = scan.next();
		boolean undirected = true;
		if (graphType.equals("directed")){
			undirected = false;
		}
	
		adjList = new Vertex[scan.nextInt()];
		
		// Reads vertex
		for (int v=0; v<adjList.length; v++){
			adjList[v] = new Vertex(scan.next(), null);
		}
		
		// Reads edges
		while (scan.hasNext()){
			
			int v1 = indexOfName(scan.next());
			int v2 = indexOfName(scan.next());
			
			adjList[v1].adjList = new Neighbour(v2, adjList[v1].adjList);
			// if Graph is an undirected
			if (undirected){
				adjList[v2].adjList = new Neighbour(v1, adjList[v2].adjList);
			}
		}
	}
	
	// returns array index for a string
	public int indexOfName(String str){
		for (int i=0; i<adjList.length; i++){
			if(adjList[i].name.equals(str))
				return i;
		}
		return -1;
	}
	
	// Prints each vertex and it's neighbours.
	public void display(){
		for (int v=0; v < adjList.length; v++ ){
			System.out.println(adjList[v].name);
			for (Neighbour nbr=adjList[v].adjList; nbr!= null; nbr=nbr.neighbour){
				System.out.println("-> " + adjList[nbr.vertexNum].name);
			}
			System.out.println("\n");
		}
	}
	
	//BFS Start
	public void bfs(){
		marked = new boolean[adjList.length];
		distTo = new int[adjList.length];
		edgeTo = new int[adjList.length];
		for (int i=0; i<adjList.length; i++){
			distTo[i] = INFINITY;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int v=0; v<marked.length; v++){
			if (!marked[v]){
				System.out.println("Starting at vertex: " + adjList[v].name);
				queue.clear();
				breadthFirstSearch(queue, marked, v);
			}
		}
	}
	
	public void breadthFirstSearch(Queue<Integer> queue, boolean[] marked, int start ){
		marked[start] = true;
		distTo[start] = 0;
		queue.add(start);
		while (!queue.isEmpty()){
			int v = queue.remove();
			for (Neighbour nbr=adjList[v].adjList; nbr != null; nbr = nbr.neighbour){
				int vnum = nbr.vertexNum;
				if (!marked[vnum]){
					edgeTo[vnum] = v;
					distTo[vnum] = distTo[v] + 1;
					marked[vnum] = true;
					System.out.println(adjList[v].name + "->" + adjList[vnum].name);
				}
			}
		}
	}
	
	public int distTo(String str){
		int v = indexOfName(str);
		return distTo[v];
	}
	
	public boolean hasPathTo(String str){
		int v = indexOfName(str);
		if (marked[v])
			return true;
		else 
			return false;
	}
	
	public static void main(String args[]) throws FileNotFoundException{
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the name of Graph file: ");
		String file = scan.nextLine();
		Graph graph = new Graph(file);
		graph.bfs();
	}
}
