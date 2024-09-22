import { LinkedList } from "./linked-list";
import { Node } from "./node";

let node3 = new Node({data:3, next: null});
let node2 = new Node({data:2, next: node3});
let node1 = new Node({data:1, next: node2});


let list = new LinkedList(node1);

console.log(list.remove(node2));
console.log(list);

console.log('before append:',list.getTail().data,'size:',list.size());

let node4 = new Node({data:4, next:null});
list.append(node4);
console.log('after append:',list.getTail().data,'size:',list.size());



