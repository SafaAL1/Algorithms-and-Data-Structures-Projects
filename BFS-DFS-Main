import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	
        Graph graph = new Graph();
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of vertices and edges");// Asking User for Input 
        int verticesSize = scan.nextInt();
        int edgesSize = scan.nextInt();
        
        for(int i = 0; i < verticesSize; i++){
            graph.addNode(new Node(Integer.toString(i), i));
        }
		
        System.out.println("Enter " + edgesSize + " edges");
		
        for(int i = 0; i < edgesSize; i++){
            int fromNode = scan.nextInt();
            int toNode = scan.nextInt();
            graph.addEdge(fromNode, toNode);
        }
	   
        System.out.print("BFS: ");
	graph.printBFS();
        
        System.out.print("DFS: ");
	graph.printDFS();
        
        graph.printAdjVertices(3);//I chnage this value in bracket
        System.out.println("Degree of Vertex is   " + graph.degreeVertex(3));//0

    }

    
}
