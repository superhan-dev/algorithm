# linkedList study

To solve linked list problems, I needed to study about linked list.

## what I don't know?

- structure of linked list.
  - attrubutes
    - head
      - ListNode
    - length
  - fuctions
    - push()
    - find()
    - size()
      - The size could be save as an attribute (length). When the node add into the linked list, just increse the length. And if the function has been called, return the length.
- how to add a node in the list in code.
  - in linked list, the function of the name of add a node is `push()`. It use a pointer and temp place to add a new node.
- how to iterate the linked list in code.
- how to dynamically add node?
  - recursive?

## ListNode

```javascript
function ListNode(val, next) {
  this.val = val === undefined ? 0 : val;
  this.next = next === undefined ? null : next;
}
```

## iterate ListNode

### init

```javascript
const node1 = new ListNode(4);
const node2 = new ListNode(1);
const node3 = new ListNode(2);

node1.next = node2;
node2.next = node3;
```

### while loop

```javascript
function iterateListNode(root) {
  let head = root;

  while (head) {
    console.log(head.val);
    head = head.next;
  }
}
```

### recursive call

```javascript
function recursiveTraversalListNode(root) {
  if (root == null) return;

  console.log(root.val);
  recursiveTraversalListNode(root.next);
}
```
