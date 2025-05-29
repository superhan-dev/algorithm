class Node {
    constructor(info, val, left=null, right=null){
        this.info = info;
        this.left = left;
        this.right = right;
        this.val = val;
    }
    
    hasLeft(){
        return this.left !== null;
    }
    
    hasRight(){
        return this.right !== null;
    }
}

class BTree {
    constructor(nodeinfo){
        const nodes = Array.from({length: nodeinfo.length}, (_,i) => i+1);
        nodes.sort((a,b) => {
            const [ax,ay] = nodeinfo[a-1];
            const [bx,by] = nodeinfo[b-1];
            // y는 트리의 높이이고 x는 형제 노드의 순서를 정렬한 것으로
            // nodeinfo에서 무작위로 존재하는 순서를 실제 트리를 배열에 담은 순서로 만들기 위해 정렬한다.
            return ay === by ? ax-bx:by-ay;
        });

        let root = null;
        for(const node of nodes){
            if(!root){
                root = new Node(nodeinfo[node-1],node);
            } else {
                // parent는 root부터 시작해서 실제 값이 존재하는 reaf까지 이동할 포인터 역할을 한다.
                let parent = root;
                const newNode = new Node(nodeinfo[node- 1], node);
                while(true){
                    if(newNode.info[0] < parent.info[0]) {
                        // 왼쪽 노드가 존재한다면 계속해서 자식노드의 포인터로 현재 포인터를 교체한다. 
                        if(parent.hasLeft()){
                            parent = parent.left;
                            continue;
                        }
                        // 끝까지 내려갔다면 값을 넣고 while문을 종료한다.
                        parent.left = newNode;
                        break;
                    } else {
                        if(parent.hasRight()) {
                            parent = parent.right;
                            continue;
                        }
                        parent.right = newNode;
                        break;
                    }


                }
            }
        }
        this.root = root;
    }
   
    
    preOrder(root, arr){
        const stack = [root];
        while(stack.length){
            const node = stack.pop();
            if(!node){
                continue;
            }
            // 중위 순회는 PLR 순이다. 
            // 하지만 스택이기 때문에 R을 먼저 넣어야 
            // PLR순서로 arr에 담을 수 있게된다.
            arr.push(node.val); // P
            stack.push(node.right) // R
            stack.push(node.left); // L
        }
    }

    postOrder(root,arr){
        const stack = [[root,false]];
        while(stack.length){
            const [node, visited] = stack.pop();
            if(!node){
                continue;
            }

            if(visited){
                arr.push(node.val);
            } else {
                stack.push([node,true]);
                stack.push([node.right,false]);
                stack.push([node.left,false]);    
            }
        }
    }
    
//     inOrder(root,arr){
//         const stack = [];
//         let node = root;
        
//         while(node !== null || stack.length > 0) {
//             while(node !== null) {
//                 stack.push(node);
//                 node = node.left;
//             }
            
//             node = stack.pop();
//             arr.push(node.val);
//             node = node.right;
//         }
//     }
}

function solution(nodeinfo) {
    var answer = [[],[]];
    
    const bTree = new BTree(nodeinfo);
    bTree.preOrder(bTree.root, answer[0]);
    bTree.postOrder(bTree.root, answer[1]);
    
    return answer;
}