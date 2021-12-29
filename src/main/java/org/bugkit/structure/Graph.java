package org.bugkit.structure;

import org.bugkit.algorithm.GraphAlgorithm;

import java.util.Arrays;

/**
 * @param <E> the element type
 * @param <W> the weight of edge
 * @author bugkit
 * @since 2021.10.27
 */
public class Graph<E, W> {

    private boolean direction = true;

    private final List<Node<E>> nodes;

    private final Edge<W>[][] edges;


    public Graph(List<Node<E>> nodes) {
        this.nodes = nodes;
        edges = new Edge[nodes.size()][nodes.size()];
    }

    public Graph(List<Node<E>> nodes, Edge<W>[][] edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public Graph(List<Node<E>> nodes, Edge<W>[][] edges, boolean direction) {
        this.nodes = nodes;
        this.edges = edges;
        this.direction = direction;
    }

    public List<Node<E>> getNodes() {
        return nodes;
    }

    public Edge<W>[][] getEdges() {
        return edges;
    }

    public boolean isDirection() {
        return direction;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nodes.toString()).append("\n");
        for (Edge[] edge : edges) {
            sb.append(Arrays.toString(edge));
        }
        return sb.toString();
    }

    public static class Node<E> {

        /**
         * element
         */
        private final E e;
        /**
         * order, begin with order
         */
        private final int order;

        public Node(E e, int order) {
            this.e = e;
            this.order = order;
        }

        public E getE() {
            return e;
        }

        public int getOrder() {
            return order;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", order=" + order +
                    '}';
        }
    }

    public static class Edge<W> {
        /**
         * edge weight
         */
        private final W w;
        /**
         * true if has edge,false otherwise
         */
        private final boolean edge;

        public Edge(W w, boolean edge) {
            this.w = w;
            this.edge = edge;
        }

        public W getW() {
            return w;
        }

        public boolean isEdge() {
            return edge;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "w=" + w +
                    ", edge=" + edge +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Node<String>> nodes = new ArrayList<>();
        nodes.add(new Node<>("node1",0));
        nodes.add(new Node<>("node2",1));
        nodes.add(new Node<>("node3",2));
        nodes.add(new Node<>("node4",3));

        Edge<Integer>[][] edges = new Edge[nodes.size()][nodes.size()];
        edges[0][1] = new Edge<>(1, true);
        edges[1][2] = new Edge<>(2, true);
        edges[2][3] = new Edge<>(3, true);
        edges[0][2] = new Edge<>(2, true);
//        edges[0][3] = new Edge<>(7, true);

        Graph<String, Integer> graph = new Graph<>(nodes, edges);
        System.out.println(graph);

        GraphAlgorithm.bfs(graph);
    }


}
