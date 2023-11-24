package dataStructure.listNode;

 /**
     * @dscription add a value with current (as a pointer)
     * 
     * @param n
     * @return
     * @source
        public ListNode initializeListNode(){
          ListNode head = null;
          ListNode current = null;

          for(int i = 0;i < 5; i++){
            ListNode newNode = new ListNode(i+1);
            
            if(head == null){
              head = newNode;
              current = head;
            } else {
              current.next = newNode;
              current = newNode;
            }
          }

          return head;
        }
    */

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
