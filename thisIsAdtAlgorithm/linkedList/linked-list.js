export class LinkedList {
  head;
  tail;
  constructor(
    head = null,
  ){
    this.head = head;
    this.tail = this.getTail();
  }

  size(){
    let count = 0;
    let node = this.head;
    while(node){
      count++;
      node = node.next;
    }

    return count;
  }
  
  clear(){
	  this.head = null;
  }
  
  getHead(){
	  return this.head;
  }
  
  getTail(){
    if(!this.head){ 
      return; 
    }

	  let lastNode = this.head;
    if(lastNode){
      while(lastNode.next){
        lastNode = lastNode.next;
      }
    }
	  
	  return lastNode;
  }

  remove(node){
    if(this.head === node){
      this.head = node.next;
      return;
    }

    let current = this.head;
    // 노드가 현재의 다음노드가 아닐때까지만 이동한다.
    // 다음 노드를 만난다면 탐색을 멈춘다.
    while(current && current.next !== node){
      current = current.next;
    }
    // current.next가 삭제를 요청받은 노드이다.
    // 따라서 삭제를 요청받은 노드의 next를 연결하면 노드는 삭제된다.
    if(current){
      current.next = node.next;
    }

    return;
  }

  append(node){
    if(this.tail){
      this.tail.next = node;
      return;
    }

    let current = this.head;
    while(current.next) {
      console.log('in while')
      current = current.next;
    }
    current.next = node;
    return;
  }
}