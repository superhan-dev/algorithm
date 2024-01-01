# Principle of Dijkstra

Find the distances from start vertex and the endest vertex

1. pop out the minimun distance for neighbor Vertices
2. find neighbor's neighbor.
   1. Keep calculate distances

## Based on BFS

The Dijkstra algorithm is based on BFS and

## Consist

- Distances Hash Map
- Unvisited List
- Priority Queue
  - QueueObject

# The Loagic

1. get a Graph, and a starting vertex with the parameters
2. initialze the distances HashMap, previous HashMap, Priority Queue,
3. loop through the vertices of the graph, and initialize distances and previous vertex of all vertices
4. put the starting vertex into the distances HashMap
5. loop through the queue
   1. take out the current vertex from queue
   2. loop through the edges for the current vertex
      1. calculate the alternative distances
      2. get neighbor's data
      3. if alternative is smaller than neighbor's distance
         1. put the HashMap value(neighbor: alternative).
         2. add the QueueObject of neighbor??

# Questions

- ## What is the previous HashMap for?
- What if it has a cycle?
  - It has a problem.
    - To fix this problem, We need to use a HashSet.

# Code
