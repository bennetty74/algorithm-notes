package org.bugkit.algorithm;

import org.bugkit.structure.Graph;
import org.bugkit.structure.LinkedList;
import org.bugkit.structure.Queue;

/**
 * @author bugkit
 * @since 2021.11.2
 */
public class GraphAlgorithm {


    public static <E, W> void bfs(Graph<E, W> graph) {
        Graph.Node<E> startNode = graph.getNodes().get(0);
        Queue<Graph.Node<E>> queue = new LinkedList<>();
        queue.offer(startNode);
        boolean[] visited = new boolean[graph.getNodes().size()];
        while (!queue.isEmpty()) {
            Graph.Edge<W>[][] edges = graph.getEdges();
            Graph.Node<E> node = queue.poll();
            visited[node.getOrder()] = true;
            System.out.print(node.getE() + ", ");
            for (int i = 0; i < edges[node.getOrder()].length; i++) {
                if (edges[node.getOrder()][i] != null && edges[node.getOrder()][i].isEdge()) {
                    if (!visited[i]) {
                        queue.offer(findNode(graph, i));
                    }
                }
            }
        }
    }

    public static <E, W> void dfs(Graph<E, W> graph) {

    }

    private static <E,W> Graph.Node<E> findNode(Graph<E, W> graph, int order) {
        for (int i = 0; i < graph.getNodes().size(); i++) {
            if (graph.getNodes().get(i).getOrder() == order) {
                return graph.getNodes().get(i);
            }
        }
        return null;
    }

}
