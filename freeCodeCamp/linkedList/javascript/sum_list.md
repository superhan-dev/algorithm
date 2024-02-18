# Complexity

- n: # of nodes
- Time: O(n) or O of n
- Space: O(n)

# Code

To solve the problems we have many variations.
Basic idea is visiting all nodes and add all values for every each nodes.

First, we can do it with recursive. For recursive the most important part is the exit condition. this logic we can use it with a checking if the given head is exit or not. After check it, simply call the function with `head.next`.

Second, we can do it with iterative. For iterative we need a pointer. `current` variable will be the pointer. In a while loop, after print value of current, simply change the pointer with `current.next`.

## Node datastructure

```javascript
class Node {
  constructor(val) {
    this.val = val;
    this.next = null;
  }
}
```

## Iterative Version

```javascript
/**
 * return a string array
 */
const sumList = (head) => {
  let sum = 0;

  let current = head;
  while (current) {
    sum += current.val;
    current = current.next;
  }

  return sum;
};
```

## Recursive Version

```javascript
const sumList = (head) => {
  if (!head) return 0;
  return head.val + sumList(head.next);
};
```

## Test with code

```javascript
const a = new Node(2);
const b = new Node(8);
const c = new Node(3);
const d = new Node(7);

a.next = b;
b.next = c;
c.next = d;

sumList(a);
```
