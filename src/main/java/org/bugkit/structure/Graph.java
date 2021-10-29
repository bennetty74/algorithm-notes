package org.bugkit.structure;

/**
 * @param <E> the element type
 * @param <W> the weight of edge
 * @author bugkit
 * @since 2021.10.27
 */
public class Graph<E, W> {

    private List<Node<E, W>> nodes;

    public Graph() {
        nodes = new LinkedList<>();
    }

    public void addNode(Node<E, W> node) {
        nodes.add(node);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Graph: \n");
        for (int i = 0; i < nodes.size(); i++) {
            sb.append("     node: ").append(nodes.get(i).e);
            List<Edge<E, W>> edges = nodes.get(i).edges;
            for (int j = 0; j < edges.size(); j++) {
                sb.append("( ").append(edges.get(i).node.e).append(",").append(" )").append("   ");
            }
        }
        return sb.toString();
    }

    private static class Node<E, W> {

        private final E e;
        private final List<Edge<E, W>> edges;

        public Node(E e) {
            this.e = e;
            edges = new LinkedList<>();
        }

        public Node(E e, List<Edge<E, W>> neighbors) {
            this.e = e;
            edges = new LinkedList<>();
            for (int i = 0; i < neighbors.size(); i++) {
                Edge<E, W> edge = new Edge<>(neighbors.get(i).node.e, neighbors.get(i).w);
                edges.add(edge);
            }
        }

        public void addEdge(Edge<E, W> edge) {
            this.edges.add(edge);
        }

        public List<Node<E, W>> getNeighbors(Node<E, W> node) {
            List<Node<E, W>> nodeList = new LinkedList<>();
            List<Edge<E, W>> edges = node.edges;
            for (int j = 0; j < edges.size(); j++) {
                nodeList.add(edges.get(j).node);
            }
            return nodeList;
        }
    }

    private static class Edge<E, W> {
        /**
         * weight
         */
        private final W w;
        /**
         * the neighbor
         */
        private final Node<E, W> node;

        public Edge(E e, W w) {
            this.w = w;
            this.node = new Node<>(e);
        }
    }


    public static void main(String[] args) {
        Graph<String, Integer> graph = new Graph<>();
        Node<String, Integer> nodeA = new Node<>("A");
        Edge<String, Integer> edgeAB = new Edge<>("B", 1);
        nodeA.addEdge(edgeAB);
        graph.addNode(nodeA);
        Node<String, Integer> nodeB = new Node<>("B");
        Edge<String, Integer> edgeBC = new Edge<>("C", 2);
        nodeB.addEdge(edgeBC);
        graph.addNode(nodeB);
        Node<String, Integer> nodeC = new Node<>("C");
        graph.addNode(nodeC);
            System.out.println(graph);
    }


}
