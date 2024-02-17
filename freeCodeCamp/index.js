class Node {
  constructor(val) {
    this.val = val;
    this.next = null;
  }
}

// iterate version
// const linkedListValues = (head) => {
//   let current = head;
//   while (current) {
//     console.log(current.val);

//     current = current.next;
//   }
// };

// recursive version
const linkedListValues = (head) => {
  if (!head) return;

  console.log(head.val);
  linkedListValues(head.next);
};

const a = new Node("a");
const b = new Node("b");
const c = new Node("c");
const d = new Node("d");

a.next = b;
b.next = c;
c.next = d;

linkedListValues(a);
