package Divide_Nodes_Into_the_Maximum_Number_of_Groups_2493;/*
A. Understanding the Problem:
The goal is to find the maximum number of groups in which nodes can be arranged such that:
Every node appears in exactly one group.
Every edge connects nodes from different groups.

B. Approach:
1. Graph Representation:
The graph is represented as an adjacency list (adj).
Nodes are 1-indexed in input but converted to 0-indexed for easier array handling.

2. Checking Bipartite:
A graph component can only be split into valid groups if it is bipartite.
The function isBipartite() performs a DFS-based bipartite check, coloring nodes in two colors (0 and 1).
If a node's neighbor has the same color as the node, the graph is not bipartite, and we return -1.
Finding Connected Components:
If the component is bipartite, we store all nodes in a list.

3. Finding Maximum Groups:
The function maxGroupsInComponent() finds the longest shortest path (diameter) in the component.
It does BFS from every node in the component to determine the maximum depth.
The number of groups is equal to maxDepth + 1 (since depth is 0-based).

C. Complexity Analysis
Bipartite Check:
O(N+M) (DFS over all nodes and edges)
Finding Maximum Groups:
O(N(N+M)) (BFS from each node in a component)
Overall Complexity:
O(N(N+M)), which is feasible for small to medium-sized graphs.

D. Edge Cases Handled
Disconnected graphs
Single node graphs that are not bipartite
Sparse and dense graphs

*/

import java.util.*;

public class Solution {
    private int[] color; // To track partition colors (0/1)
    private List<List<Integer>> adj;
    private int n;

    public int magnificentSets(int n, int[][] edges) {
        this.n = n;
        color = new int[n];
        Arrays.fill(color, -1);
        adj = new ArrayList<>();

        for(int i = 0; i < n ; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            int u = edge[0] - 1, v = edge[1] - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        List<List<Integer>> components = new ArrayList<>();
        for(int i =0; i < n; i++) {
            if (color[i] == -1) {
                List<Integer> component = new ArrayList<>();
                if(!isBipartite(i, 0, component)) {
                    return -1;
                }
                components.add(component);
            }
        }

        int total = 0;
        for(List<Integer> comp : components) {
            total += maxGroupsInComponent(comp);
        }

        return total;
    }

    // DFS to check bipartite and collect component nodes
    private boolean isBipartite(int node, int col, List<Integer> component) {
        color[node] = col;
        component.add(node);

        for(int neighbor : adj.get(node)) {
            if(color[neighbor] == col) return false;
            if(color[neighbor] == -1 && !isBipartite(neighbor, 1 - col, component)) return false;
        }

        return true;
    }

    // BFS to compute max depth (groups) for a component
    private int maxGroupsInComponent(List<Integer> comp) {
        int maxDepth = 0;
        for(int start : comp) {
            int[] depth = new int[n];
            Arrays.fill(depth, -1);
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            depth[start] = 0;
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for(int neighbor : adj.get(node)) {
                    if(depth[neighbor] == -1) {
                        depth[neighbor] = depth[node] + 1;
                        maxDepth = Math.max(maxDepth, depth[neighbor]);
                        queue.add(neighbor);
                    }
                }
            }
        }

        return maxDepth + 1; // Depth to groups conversion
    }
}