/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var averageOfLevels = function(root) {
    const answer = [];
    if(root == null) return answer;
    
    const queue = [];
    queue.push(root);
    
    while(queue.length > 0){
        let levelSum = 0;
        
        let size = queue.length;
        for(let i=0;i<size;i++){
            const current = queue.shift();
            
            levelSum += current.val;
            
            if(current.left) queue.push(current.left);
            if(current.right) queue.push(current.right);
            
        }
        // avg = total sum of siblings / count of siblings
        answer.push(levelSum / size);
    }
    
    return answer;
};