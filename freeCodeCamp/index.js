class Node {
  constructor(val) {
    this.val = val;
    this.next = null;
  }
}

const a = new Node("a");
const b = new Node("b");
const c = new Node("c");
const d = new Node("d");

const q = new Node("q");
const r = new Node("r");
const x = new Node("x");
const z = new Node("z");

a.next = b;
b.next = c;
c.next = d;

q.next = r;
r.next = x;
x.next = z;

const zipperList = (head1, head2) => {
  /**
   * use the pointers to append the ListNode's vals.
   */
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

  // how return head1?
  // need understaning about pointer more.
  let temp = head1;
  while (temp) {
    console.log(temp.val);
    temp = temp.next;
  }

  return head1;
};

console.log(zipperList(a, q));
