# Graph

Graph has vertex and edge

Weighted graph: Edge has weight/cost/value associated with it.
Unweighted graph: No weight/cost/value associated.

## Undirected graph
Edge has no specific direction
That means if first vertex is connected to the second, it means the second vertex is connected to the first
A ----- B

## Directed Graph
Edge between vertex has direction
If first vertex is connected to the second, it doesn't imply the second vertex is connected to the first

A -----> B

## Types of graph
1. Undirected unweighted graph
2. Undirected weighted graph 
3. Directed unweighted graph 
4. Directed weighted graph


## Small definitions
**Size of graph**: `Number of vertex in the graph`

Degree of a vertex: Number of vertex is connected directly.
* In undirected, A ---- B, deg(A) = 1 and deg(B) = 1
* In directed,   A ---> B, deg(A) = 1 and deg(B) = 0

## Traversal in graph
* BFS
* DFS
* Topological order/sort


## Simple data structure representation of undirected unweighted graph

1. Array of ArrayList (When capacity is given C) (Usually when vertex is integer and index represents that vertex)
2. ArrayList of ArrayList (Usually when vertex is integer and index represents that vertex)
3. Map<Integer or String or Character, ArrayList> (Usually when vertex is different from integer and key represents that vertex)
4. LinkedList of LinkedList

In most ds-algo question we go with 1 or 2
When vertex is integer and is large or when vertex is of different data type, go with 3 or 4