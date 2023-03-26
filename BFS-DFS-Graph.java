import java.util.*;

public class Graph {

    ArrayList<LinkedList<Node>> alist;//intilazing an ArrayList thats grabbing Node Linkedlist called alist
    //alist is the name
    
    
    Graph(){//Graph is construct function
        alist = new ArrayList<>();
    }

    public void addNode(Node node) {//method addNode which node from node class
        LinkedList<Node> currentList = new LinkedList<>();// creating a linkedlist type Node called
          
        currentList.add(node);// currentList add nodes
        alist.add(currentList);//alist is grabbing a list and inside that list that has a node from currentList
    }
    public void addEdge(int src, int dst) {//method addEdge which grabs Source and Destination
        LinkedList<Node> currentList = alist.get(src);//Alist is made of Linkedlist ( nodes), get source grabs one of the Linkedlist
        Node dstNode = alist.get(dst).get(0);//So dstNode grabs the first node of DST LInkedlist
        currentList.add(dstNode);//we are adding the 0 element from DST to currentList
    }
	
    public int degreeVertex(int src){// method degreeVertex
        LinkedList<Node> currentList = alist.get(src);
        int size = currentList.size() - 1;//this checks the size of the Linkedlist
        return size;
    }
    public void printAdjVertices(int src){//method printAdjVertices
        LinkedList<Node> currentList = alist.get(src);
        //for(Node node : currentList) {//for loop node is equal to each nodes in the currentList
                      //System.out.print(node.data + " -> ");//data is variable inside Node class that grabs char
        //} 
        System.out.print("Adjacent Vertices of vertex (" + alist.get(src).get(0).data + ") : ");
        for(int i = 1; i<alist.get(src).size(); i++){//src
        System.out.print(alist.get(src).get(i).data + "  ");
        }
      System.out.println();
    }

        
    public void printBFS(){//print BFS
        //First rest all nodes to not visited
        for(LinkedList<Node> temList: alist){//Every Linkedlist inside alist is going to equal temlist
            temList.get(0).visited = false;// basically stating that no nodes are visted
            //the first node in linkedList is the owner, and so we are setting it as false
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(alist.get(0).get(0));//this will grab the linkedlist and then grab the first node, and add it to queue
        alist.get(0).get(0).visited = true;// changing that the first node is visited
        Node currentNode;
        while(!queue.isEmpty()){//while queue isnt empty
            currentNode = queue.pollFirst();//pollFirst just pulls first element of the queue

            System.out.print(currentNode.data + " ");//displaying what was garbbed

            for(Node n : alist.get(currentNode.index)){//index is created to cnvert from char to int
                if(!n.visited){//if n isnt visisted this for loop while add it to the q until all n elements are visisted
                    queue.add(n);//we grab the elements from alistlinkedlist 
                    n.visited = true;
                }
            }

        }
        System.out.println();
    }

    public void printDFS(){//Stack
        //First rest all nodes to not visited
        for(LinkedList<Node> temList: alist){//create temp list
            temList.get(0).visited = false;// intalize for 0
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(alist.get(0).get(0));
        alist.get(0).get(0).visited = true;
        System.out.print(alist.get(0).get(0).data + " ");
        Node currentNode;
        while(!queue.isEmpty()){//while the queue isnt empty
            currentNode = queue.getLast();

            boolean deleteNode = false;//deleteNode is set as false
            for(Node n : alist.get(currentNode.index)){
                deleteNode = true;//change is it to true 
                if(!n.visited){// if n isnt visited 
                    queue.add(n);
                    n.visited = true;
                    System.out.print(n.data + " ");
                    deleteNode = false;
                    break;
                }
            }
            if(deleteNode){
                queue.pollLast();
            }

        }
        System.out.println();
    }
}
