/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14342
 * Date: 2020-11-04
 * Time: 18:23
 **/
class Node{
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class MyLinkedList {

    public Node head;
public void addLast(int data){
    Node node = new Node(data);
    if (this.head == null){
        this.head = node;
        return;
    }
    Node cur = this.head;
    while(cur.next != null){
        cur = cur.next;
    }
    cur.next = node;
}
public void display(){
    Node cur = this.head;
    while(cur != null){
        System.out.print(cur.data+" ");
        cur = cur.next;
    }
    System.out.println();
}
private Node findPrev(int toRemove){
    Node prev = this.head;
    while(prev.next != null){
        if (prev.next.data == toRemove){
            return prev;
        }
        prev = prev.next;
    }
    return null;
}
public void remove(int toRemove){
    if (this.head.data == toRemove){
        this.head = this.head.next;
    }
    Node prev = findPrev(toRemove);
    if (prev == null){
        return;
    }

    Node del = prev.next;
    prev.next = del.next;

}
public void removeAllKey(int keys){
    Node prev = this.head;
    Node cur = this.head.next;
    while(cur != null){
        if (cur.data == keys){
            prev.next = cur.next;
            cur = cur.next;
        }else {
            prev = cur;
            cur = cur.next;
        }
    }
    if (this.head.data == keys){
        this.head = this.head.next;
    }
}

public Node reverse(){
    Node prev = null;
    Node newHead = null;
    Node cur = this.head;
    while(cur != null){
        Node curNext = cur.next;
        if (curNext == null){
            newHead = cur;
        }
        cur.next = prev;
        prev = cur;
        cur = curNext;

    }
    return newHead;
}
public void display(Node newHead){
    Node cur = newHead;
    while(cur != null){
        System.out.print(cur.data+" ");
        cur = cur.next;

    }
    System.out.println();
}

public Node findMiddle(){
    Node fast = this.head;
    Node slow = this.head;
    while(fast != null && fast.next != null){
        fast = fast.next.next;
        slow = slow.next;
    }
    return slow;
}

public Node FindKthToTail(int k){
    Node fast = this.head;
    Node slow = this.head;
    if (k <= 0){
        return  null;
    }
    if (this.head == null){
        return  null;
    }
    for (int i = 0; i < k-1; i++) {
        if (fast.next != null){
            fast = fast.next;
        }else {
            return null;
        }

    }
    while(fast.next != null){
        fast = fast.next;
        slow = slow.next;
    }
    return slow;
}
public Node mergeTwoLists(Node headA,Node headB){
    Node newNode = new Node(-1);
    Node tmp = newNode;
    if (headA == null && headB == null){
        return null;
    }
    while(headA != null && headB != null){
        if (headA.data < headB.data){
            if (tmp == null){
                tmp = headA;

            }else {
                tmp.next = headA;
                tmp = tmp.next;
                headA = headA.next;
            }
        }else {
            if (tmp == null){
                tmp = headB;

            }else {
                tmp.next = headB;
                tmp = tmp.next;
                headB = headB.next;

            }
        }
    }
    if (headA != null){
        tmp.next = headA;
    }
    if(headB != null){
        tmp.next = headB;
    }

    return newNode.next;
}

public Node partition(int x){
    if (this.head == null){
        return  null;
    }
    Node bs = null;
    Node be = null;
    Node as = null;
    Node ae = null;
    Node cur = this.head;
    while(cur != null){
        if (cur.data < x){

            if (bs == null){
                bs = cur;
                be = bs;
            }else {
                be.next = cur;
                be = be.next;
            }

        }else {
            if (as == null){
                as = cur;
                ae = as;
            }else {
                ae.next = cur;
                ae = ae.next;
            }

        }
        cur = cur.next;
    }
    if (bs == null){
        return as;
    }
    be.next = as;
    if (as != null){
        ae.next = null;
    }
    return bs;

}
public Node deleteDuplication(){
    if (head == null){
        return  null;
    }
    Node newHead = new Node(-1);
    Node tmp = newHead;
    Node cur = this.head;
    while(cur != null){
       if(cur.next != null && (cur.data == cur.next.data)){
           while (cur.next != null && (cur.data == cur.next.data)){
               cur = cur.next;
           }
           cur = cur.next;
       }else {
           tmp.next = cur;
           tmp = tmp.next;
           cur = cur.next;
       }
    }
    tmp.next = null;
    return newHead.next;
}

public boolean chkPalindrome(){
    if (this.head == null){
        return false;
    }
    Node fast = this.head;
    Node slow = this.head;
    while(fast != null && fast.next != null){
        fast = fast.next.next;
        slow = slow.next;
    }
    Node cur = slow.next;
    while(cur.next != null){
        Node curNext = cur.next;
        cur.next = slow;
        slow = cur;
        cur = curNext;
    }
    while(this.head != head){
        if (this.head.data != slow.data){
            return false;
        }
        if (this.head.next == slow){
            return true;
        }
        slow = slow.next;
        this.head = this.head.next;
    }
    return true;
}

public Node  getIntersectionNode(Node headA,Node headB){
    if (headA == null || headB == null){
        return  null;
    }
    Node pl = headA;
    Node ps = headB;
    int l1 = 0;
    int l2 = 0;
    while(pl != null){
        l1++;
        pl = pl.next;
    }
    while(ps != null ){
        l2++;
        ps = ps.next;
    }
    pl = headA;
    ps = headB;
    int len = l1-l2;
    if (len < 0 ){
        pl = headB;
        ps = headA;
        len = l2-l1;
    }
    for (int i = 0; i < len; i++) {
        pl = pl.next;
    }
    while(pl != ps){
        pl = pl.next;
        ps = ps.next;
    }
    if (pl != null && ps != null && ps == pl){
        return pl;
    }
    return null;
}
public boolean hasCycle(){
    Node fast = this.head;
    Node slow = this.head;
    if (head == null){
        return false;
    }
    while(fast != null && fast.next != null){
        fast = fast.next.next;
        slow = slow.next;
        if (fast == slow){
            break;
        }
    }
    if (fast == null || fast.next == null){
        return false;
    }
    return true;
}
    public Node  detectCycle(){
    if (this.head == null){
        return null;
    }
    Node fast = this.head;
    Node slow = this.head;
    while(fast != null && fast.next != null){
        fast = fast.next.next;
        slow = slow.next;
        if (fast == slow){
            break;
        }
    }
    if (fast == null || fast.next == null){
        return null;
    }
    slow = this.head;
    while(fast != slow){
        fast = fast.next;
        slow = slow.next;
    }
    return fast;
    }

}
