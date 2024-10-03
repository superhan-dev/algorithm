export function inOrderTraverseTree(node){
  if(!node){return;}

  inOrderTraverseTree(node.left);

  console.log(node.data);

  inOrderTraverseTree(node.right);
}

export function preOrderTraverseTree(node){
  if(!node) return;

  console.log(node.data);
  preOrderTraverseTree(node.left);
  preOrderTraverseTree(node.right);
}

export function postOrderTraverseTree(node){
  if(!node) return;

  postOrderTraverseTree(node.left);
  postOrderTraverseTree(node.right);
  console.log(node.data);

}