/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Safa
 */
import java.util.*;

public class MinimumSpanningTree {
    int Vertex;
    private List<List<Edge>> neiload;
    
    //This section of the code focuses on grabbing the user's input using scanner,it does so by storing values for vertices, edges and weight
     public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of vertices and edges\n");
        int verticesSize = scan.nextInt();
        int edgesSize = scan.nextInt();
        //grabbing 3 inputs from the user, presenting intial node, second node, and the weight of the edges
        // to follow prim's algorithm
        MinimumSpanningTree graph = new MinimumSpanningTree(verticesSize);
        for (int i = 0; i < edgesSize; i++) {
            int fromNode = scan.nextInt();
            int toNode = scan.nextInt();
            int weight = scan.nextInt();
            graph.addEdge(fromNode,toNode, weight);
        }
           
        graph.MinimumSpanningTree();

        scan.close();
    }

    MinimumSpanningTree(int v) {
        Vertex = v;
        neiload = new ArrayList<>(Vertex);
        for (int i = 0; i < Vertex; i++)
            neiload.add(new ArrayList<>());
    }

    void addEdge(int d, int a, int b) {
        neiload.get(d).add(new Edge(a, b));
        neiload.get(a).add(new Edge(d, b));
    }
    //intialzition of edge's weight and where its travelings to
    class Edge {
        int travel;
        int weight;
        Edge(int travel, int weight) {
            this.travel = travel;
            this.weight = weight;
        }
    }

    void MinimumSpanningTree() {
        int[] headNode = new int[Vertex];
        int[] Prime = new int[Vertex];
        boolean[] mstLine = new boolean[Vertex];

        for (int i = 0; i < Vertex; i++) {
            Prime[i] = Integer.MAX_VALUE;
            mstLine[i] = false;
        }

        PriorityQueue<Edge> priorityQ = new PriorityQueue<>(Vertex, Comparator.comparingInt(a -> a.weight));//initlazing a new variable called a, and inside a theres weight
        Prime[0] = 0;
        headNode[0] = -1;
        priorityQ.add(new Edge(0, 0));

        while (!priorityQ.isEmpty()) {
            int u = priorityQ.poll().travel;

            mstLine[u] = true;

            for (Edge edge : neiload.get(u)) {
                int a = edge.travel;
                int b = edge.weight;
                if (!mstLine[a] && b < Prime[a]) {
                    headNode[a] = u;
                    Prime[a] = b;
                    priorityQ.add(new Edge(a, Prime[a]));
                }
            }
        }
        int sumMST = 0;
        for (int i = 1; i < Vertex; i++) {
            System.out.println("Edge " + headNode[i] + " - " + i + "  " + "has a weight of " + Prime[i]+ "\n");
            sumMST = sumMST + Prime[i];
        }
        System.out.print("MST =" + sumMST + "\n");
    }
 
}
