package 链表;

public class LinkList {
    Node head = null; // 头节点
    class Node {
        Node next = null;
        int data;
        public Node(int data) {
            this.data = data;
        }
    }


    public void addNode(int d) {
        Node newNode = new Node(d);
        if (head == null) {
            head = newNode;
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }


    public boolean deleteNode(int index) {
        if (index < 1 || index > length()) {
            return false;
        }
        if (index == 1) {
            head = head.next;
            return true;
        }

        int i = 1;
        Node preNode = head;
        Node curNode = preNode.next;
        while (curNode != null) {
            if (i == index) {
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        return false;
    }

    //返回节点长度
    public int length() {
        int length = 0;
        Node tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }



    public void printList() {
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.addNode(5);
        list.addNode(3);
        list.addNode(1);
        list.addNode(2);;
        System.out.println("linkLength:" + list.length());
        list.printList();
        list.deleteNode(4);
        list.printList();
    }
}
