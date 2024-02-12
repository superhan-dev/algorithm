# Analysis the logic
It can be solved with Folyd's find cycle algorithm (or tortoises and hare).

I solved the algorithm before in java. 
this time I want to try it in javascript to repeat my self.

## the data structure of linked list
A Linked List is given. we can use two pointers for head and head's next.
and if the pointers have same next, It means the cycle.

```javascript
/**
 * Definition for singly-linked list.
*/

function ListNode(val) {
    this.val = val;
    this.next = null;
}

```

# The Code
```javascript

var hasCycle = function(head){
    if(head == null || head.next == null || head.next.next == null){
        return false;
    }
    
    let tortoises = head;
    let hare = head.next.next;
    
    // If it is cycle, the hare.next.next is null, and It will occur an error.
    // Therefore we need try/catch here.
    try {
        while(tortoises != null && hare != null){
        
            tortoises = tortoises.next;
            hare = hare.next.next;
        
            if(tortoises === hare){
                return true;
            }
        }
    } catch(error){
        return false;
    }
    
    return false;
}

```

# The Best code 
I had some mistake at my code. I used head.next.next for initial the fast and slow,
but that was the reason why the error is occurred.

Also, I don't need to use the variable for slow and fast.
If I allocate a variable, I spend more memory, 
and It will be the reason that why the code is going to be slow.

don't use the filter too much.

```javascript 
var hasCycle = function(head) {
    let fast = head;
    while(fast && fast.next) {
        head = head.next;
        fast = fast.next.next;
        if (head === fast) return true
    }
    return false
};

```