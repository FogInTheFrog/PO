package graph;

import java.util.*;

public class Graph<T> {
    private Map<T, Set<T>> map = new HashMap<>();

    public Graph() {}

    public void addVertex(T s) {
        if (!map.containsKey(s))
            map.put(s, new HashSet<>());
    }

    public void addEdge(T source,
                        T destination) {
        addVertex(source);
        addVertex(destination);

        map.get(source).add(destination);
        map.get(destination).add(source);
    }

    public Iterator<T> DFSIter(T source){
        DataStructure<T> dataStructure = new Stack<>();
        return iterator(source, dataStructure);
    }

    public Iterator<T> BFSIter(T source){
        DataStructure<T> dataStructure = new myQueue<>();
        return iterator(source, dataStructure);
    }

    public Iterator<T> iterator(T source, DataStructure<T> dataStructureType) {
        dataStructureType.push(source);
        Set<T> inDS = new HashSet<>();
        inDS.add(source);

        return new Iterator<>() {
            Set<T> wasVisitedOrInDataStructure = inDS;
            DataStructure<T> dataStructure = dataStructureType;

            public boolean hasNext() {
                return !dataStructure.isEmpty();
            }

            @Override
            public T next() {
                T nextVertice = dataStructure.pop();

                Set<T> neighbours = map.get(nextVertice);
                for (T neighbour : neighbours) {
                    if (!wasVisitedOrInDataStructure.contains(neighbour)) {
                        dataStructure.push(neighbour);
                        wasVisitedOrInDataStructure.add(neighbour);
                    }
                }
                return nextVertice;
            }
        };
    }

}