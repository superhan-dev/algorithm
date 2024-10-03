import { Node } from "./node.js";
import {
  inOrderTraverseTree,
  postOrderTraverseTree,
  preOrderTraverseTree,
} from "./traverse-tree.js";

//     A
//    B E
//  C D F G
const root = new Node({ data: "A" });
const b = new Node({ data: "B" });
const c = new Node({ data: "C" });
const d = new Node({ data: "D" });
const e = new Node({ data: "E" });
const f = new Node({ data: "F" });
const g = new Node({ data: "G" });
const h = new Node({ data: "H" });

root.left = b;
b.left = c;
b.right = d;

root.right = e;
e.left = f;
e.right = g;

// c.left=h;
console.log(root);

// inOrderTraverseTree(root);
// preOrderTraverseTree(root);
postOrderTraverseTree(root);
