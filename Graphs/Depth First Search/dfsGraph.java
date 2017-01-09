package newLinkedList;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class dfsGraph {
	
	private static final int INFINITY = 0;
	Vertex[] adjList;
	public boolean[] marked;
	public int[] edgeTo;
	
	public dfsGraph(String file) throws FileNotFoundException{
		
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
	
	public void dfs(){
		marked = new boolean[adjList.length];
		edgeTo = new int[adjList.length];
		for (int v=0; v<adjList.length; v++){
			if(!marked[v]){
				System.out.println(" Starting at: " + adjList[v].name);
				depthFirstSearch(v, marked);
			}
		}
	}
	
	private void depthFirstSearch(int v, boolean[] marked){
		marked[v] = true;
		for (Neighbour nbr=adjList[v].adjList; nbr != null; nbr = nbr.neighbour){
			int verNum = nbr.vertexNum;
			if (!marked[verNum]){
				edgeTo[verNum] = v;
				System.out.println(adjList[v].name + "-> " + adjList[verNum].name);
				depthFirstSearch(verNum, marked);
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
		dfsGraph graph = new dfsGraph(file);
		graph.dfs();
	}
}
