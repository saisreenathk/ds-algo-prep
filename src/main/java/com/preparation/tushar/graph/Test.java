package com.preparation.tushar.graph;

import java.util.HashSet;
import java.util.Set;

class Test {
	public static void main(String[] args) {
		Test t = new Test();
		int numCourses=2;
		int[][] p = {{1,0},{2,0}};
		System.out.println("course possible: "+t.canFinish(numCourses, p));
	}

	public boolean canFinish(int numCourses, int[][] p) {
		if (p.length <= 1) {
			return true;
		}
		Graph<Integer> graph = new Graph<>(false);
		for (int i = 0; i < p.length; i++) {
			System.out.println("adding edge:"+ p[i][0]+" "+ p[i][1]);
			graph.addEdge(p[i][0], p[i][1]);
		}
		boolean result = hasCycle(graph);
		System.out.println("hasCycle:" + result);
		if (result) {
			return false;
		} else {
			return true;
		}
	}

	public boolean hasCycle(Graph<Integer> graph) {
		Set<Vertex<Integer>> visited = new HashSet<Vertex<Integer>>();
		for (Vertex<Integer> vertex : graph.getAllVertex()) {
			if (visited.contains(vertex)) {
				continue;
			}
			boolean flag = hasCycleDFSUtil(vertex, visited, null);
			if (flag) {
				return true;
			}
		}
		return false;
	}

	public boolean hasCycleDFSUtil(Vertex<Integer> vertex, Set<Vertex<Integer>> visited, Vertex<Integer> parent) {
		visited.add(vertex);
		for (Vertex<Integer> adj : vertex.getAdjacentVertexes()) {
//			if (adj.equals(parent)) {
//				continue;
//			}
			if (visited.contains(adj)) {
				return true;
			}
			boolean hasCycle = hasCycleDFSUtil(adj, visited, vertex);
			if (hasCycle) {
				return true;
			}
		}
		return false;
	}

}
