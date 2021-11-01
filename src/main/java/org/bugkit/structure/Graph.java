package org.bugkit.structure;

import java.util.Arrays;

/**
 * @param <E> the element type
 * @param <W> the weight of edge
 * @author bugkit
 * @since 2021.10.27
 */
public class Graph<E, W> {

    private boolean direction;

    private List<Node<E>> nodes;

    private final boolean[][] matrix;

    private final W[][] edges;

    public Graph(List<Node<E>> nodes) {
        this.nodes = nodes;
        matrix = new boolean[nodes.size()][nodes.size()];
        edges = (W[][]) new Object[nodes.size()][nodes.size()];
    }

    public Graph(boolean[][] matrix, W[][] edges, List<Node<E>> nodes) {
        this.nodes = nodes;
        this.matrix = matrix;
        this.edges = edges;
    }

    @Override
    public String toString() {
        return Arrays.toString(matrix);
    }

    private static class Node<E> {

        /**
         * element
         */
        private E e;
        /**
         * order, begin with order
         */
        private int order;
    }

}
