function ListNode(val, next) {
  this.val = val === undefined ? 0 : val;
  this.next = next === undefined ? null : next;
}

function LinkedList(head) {
  this.head = head === undefined ? new ListNode() : head;
  this.length = 0;

  this.push = (node) => {
    const newNode = new ListNode(node.val, node.next);

    this.head.next = newNode;
    this.head = newNode;

    this.length++;
  };

  this.size = () => {
    return this.length;
  };
}

function main() {
  const node1 = new ListNode(4);
  const node2 = new ListNode(1);
  const node3 = new ListNode(2);

  const ls = new LinkedList();

  node1.next = node2;
  node2.next = node3;

  let head = node1;

  // while (head) {
  //   console.log(head.val);
  //   head = head.next;
  // }

  recursiveTraversalListNode(head);
}

function recursiveTraversalListNode(root) {
  if (!root) return;
  console.log(root.val);

  recursiveTraversalListNode(root.next);
}

main();
