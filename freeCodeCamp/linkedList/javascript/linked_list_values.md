# Complexity

- n: # of nodes
- Time: O(n) or O of n
- Space: O(n)

# Code

To solve the problems we have many variations.
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
const linkedListValues = (head) => {
  const answer = [];

  let current = head;
  while (current) {
    answer.push(current.val);
    current = current.next;
  }
};
```

## Recursive Version

```javascript
const linkedListValues = (head) => {
  if (!head) return;

  const answer = fillValues(head, answer);
  return answer;
};

const fillValues = (head, values) => {
  answer.push(head.val);

  fillValues(head.next);

  return answer;
};
```

## Test with code

```javascript
const a = new Node("a");
const b = new Node("b");
const c = new Node("c");
const d = new Node("d");

a.next = b;
b.next = c;
c.next = d;

linkedListValues(a);
```
