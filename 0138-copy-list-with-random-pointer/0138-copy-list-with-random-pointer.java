/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public void insertCopyInBetween(Node head){
        Node temp = head;
        while(temp!=null){
            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = copyNode.next;
        }
    }
    public void connectRandomPointer(Node head){
        Node temp = head;
        while(temp!=null){
            Node copyNode = temp.next;
            if(temp.random!=null){
                copyNode.random = temp.random.next;
            }else{
                copyNode.random = null;
            }
            temp = temp.next.next;
        }
    }
    public Node deepCopy(Node head){
        Node dummy = new Node(-1);
        Node res = dummy;
        Node temp = head;
        while(temp!=null){
            res.next = temp.next;
            temp.next = temp.next.next;
            res=res.next;
            temp=temp.next;
        }
        return dummy.next;
    }
    public Node copyRandomList(Node head) {
        insertCopyInBetween(head);
        connectRandomPointer(head);
        return deepCopy(head);
    }
}