function TreeNode(val, left, right) {
  this.val = val === undefined ? 0 : val;
  this.left = left === undefined ? null : left;
  this.right = right === undefined ? null : right;
}
/**
 * @param {TreeNode} root
 * @return {number[]}
 */

// [3,1,5,0,2,4,6]
const t1_2_2 = new TreeNode(6);
const t1_2_1 = new TreeNode(4);
const t1_1_2 = new TreeNode(2);
const t1_1_1 = new TreeNode(0);
const t1_2 = new TreeNode(5, t1_2_1, t1_2_2);
const t1_1 = new TreeNode(1, t1_1_1, t1_1_2);
const t1 = new TreeNode(3, t1_1, t1_2);

console.log(t1.val);

function averageOfLevels(root) {
  const queue = [];
  queue.push(root);

  const answer = [];

  while (queue.length > 0) {
    let sum = 0;

    let size = queue.length;
    for (let i = 0; i < size; i++) {
      const current = queue.shift();
      sum = current.val && sum + current.val;

      if (current.left) queue.push(current.left);
      if (current.right) queue.push(current.right);
    }

    answer.push(sum / size);
  }

  return answer;
}

console.log(averageOfLevels(t1));
