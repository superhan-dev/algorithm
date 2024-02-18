# Complexity

- Time: O(min(n,m))
- Space: O(1)

# Code

use pointers to append nodes to head1.

## what is the pointer

A variable to indicate an address of an object.

- pointers
  - tail : point to head1 and add next value of the list1 during iteration.
  - current1 : point to head1 and head1's next values.
  - current2 : point to head2 and head2's next values.

### reference by value, reference by address

```javascript
function changeStuff(a, b, c) {
  // The primitive value is passrd by value.
  // So, even if asign other value at the a, It doesn't change the value.
  a = a * 10;

  // The object is passrd by reference. So, if you use `b.item` it will reference the b value of the object with address
  // So, if you asign "changed", It will be changed.
  b.item = "changed";

  // The c also passrd by reference. therefore it can't rewrite the object address for the obj2
  // It is similar concept with `const` keyword in javascript.
  // When you use `const` with a variable, you can change the subproperties, but you can not reasign for the object or array.
  c = { item: "changed" };
}

var num = 10;
var obj1 = { item: "unchanged" };
var obj2 = { item: "unchanged" };

changeStuff(num, obj1, obj2);

console.log(num); // 10
console.log(obj1.item); // changed
console.log(obj2.item); // unchanged
```

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
const zipperList = (head1, head2) => {
  let tail = head1;
  let current1 = head1.next;
  let current2 = head2;

  let count = 0;

  while (current1 && current2) {
    if (count % 2 === 0) {
      tail.next = current1;
      current1 = current1.next;
    } else {
      tail.next = current2;
      current2 = current2.next;
    }
    tail = tail.next;
    count++;
  }

  if (current1) tail.next = current1;
  if (current2) tail.next = current2;

  return head1;
};
```

## Test with code

```javascript
const a = new Node("a");
const b = new Node("b");
const c = new Node("c");
const d = new Node("d");

const q = new Node("q");
const r = new Node("r");

a.next = b;
b.next = c;
c.next = d;

q.next = r;

zipperList(a, q);
```
