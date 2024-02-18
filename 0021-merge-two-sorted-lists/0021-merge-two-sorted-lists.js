/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} list1
 * @param {ListNode} list2
 * @return {ListNode}
 */
var mergeTwoLists = function(list1, list2) {
    if((list1 && !list2) || (!list1 && !list2)) return list1;
    if(!list1 && list2) return list2;
    
    if(list1.val > list2.val){
        let temp = list1;
        list1 = list2;
        list2 = temp;
    }
    
    let tail = list1;
    let curr1 = list1.next;
    let curr2 = list2;
    
    while(curr1 && curr2){
        if(curr1.val > curr2.val){
            tail.next = curr2;
            curr2 = curr2.next;
        } else {
            tail.next = curr1;
            curr1 = curr1.next;
        }
        
        tail = tail.next;
    }
    
    if(curr1) tail.next = curr1;
    if(curr2) tail.next = curr2;
    
    return list1;
    
}

