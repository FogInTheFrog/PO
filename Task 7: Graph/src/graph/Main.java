package graph;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	    Graph<Integer> graf = new Graph<>();
	    graf.addVertex(1);
	    graf.addVertex(2);
	    graf.addVertex(3);
	    graf.addEdge(1, 2);
        graf.addEdge(2, 3);
        graf.addEdge(1, 3);
        Iterator<Integer> bfsit = graf.BFSIter(2);
        Iterator<Integer> dfsit = graf.DFSIter(1);

        while(bfsit.hasNext()){
            int x = bfsit.next();
            if(x == 2)
                graf.addEdge(1,4);
            System.out.println("bfs = " + x);
        }
        while(dfsit.hasNext()){
            System.out.println("dfs = " + dfsit.next());
        }

    }
}
