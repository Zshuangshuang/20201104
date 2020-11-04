/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14342
 * Date: 2020-11-04
 * Time: 18:23
 **/
public class Test {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(10);
        myLinkedList.addLast(20);
        myLinkedList.addLast(30);
        myLinkedList.addLast(40);
        myLinkedList.addLast(50);
        myLinkedList.display();
        /*myLinkedList.removeAllKey(10);
        myLinkedList.display();*/
        Node newHead = myLinkedList.reverse();
        myLinkedList.display(newHead);
    }
}
