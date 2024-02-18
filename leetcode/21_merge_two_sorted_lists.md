# Idea

# Code

```javascript
function ListNode(val, next) {
  this.val = val === undefined ? 0 : val;
  this.next = next === undefined ? null : next;
}

var nodeA1 = new ListNode(1);
var nodeA2 = new ListNode(2);
var nodeA4 = new ListNode(4);

nodeA1.next = nodeA2;
nodeA2.next = nodeA4;

var nodeB1 = new ListNode(1);
var nodeB3 = new ListNode(3);
var nodeB4 = new ListNode(4);

nodeB1.next = nodeB3;
nodeB3.next = nodeB4;

const mergeTwoLists = (head1, head2) => {};

mergeTwoLists(nodeA1, nodeB1);
```
