# What I missed.

spend time too much for a question.

## First misstake

At the first, I try to use the Set() for visited value.
But, in this solution, the dfs function should return a node according to solution.
So, after check the answer from other people, I reallized that It needs to return a Node rather than boolean.

## Second mistake

I never thought about the inner dfs function. And It was stubborn and stupid decision.

I totally under stand for the solution

# Spend time

- 4 hours

```Javascript

// Definition for a Node.
function Node(val, neighbors) {
  this.val = val === undefined ? 0 : val;
  this.neighbors = neighbors === undefined ? [] : neighbors;
}

/**
 * @param {Node} node
 * @return {Node}
 */
var cloneGraph = function (node) {
  // Nodes we have already copied
  const visited = {};

  // DFS function to copy graph
  const dfs = (node) => {
    if (!node) return node;
    // If we have seen this node before, return it
    if (visited[node.val] != null) return visited[node.val];

    // Create base for copied node
    const root = new Node(node.val);
    // Add this copied node to group of nodes we hav copied
    visited[node.val] = root;

    // Add copied neighbors to the current copied node
    node.neighbors.forEach((n) => root.neighbors.push(dfs(n)));
    return root;
  };

  // Return new copied graph
  return dfs(node);
};

// Example usage:
const node1 = new Node(1);
const node2 = new Node(2);
const node3 = new Node(3);
const node4 = new Node(4);

node1.neighbors = [node2, node4];
node2.neighbors = [node1, node3];
node3.neighbors = [node2, node4];
node4.neighbors = [node1, node3];

const clonedGraph = cloneGraph(node1);
console.log(clonedGraph);


```
