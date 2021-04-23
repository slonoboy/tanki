package com.company.problem2;

public class MyLinkedList {
        public Node head;
        public Node tail;
        public int size;

        public void addToEnd(int data){
            Node node = new Node(data);
            if (head == null){
                head = node;
            }
            else{
                tail.next = node;
                node.prev = tail;
            }
            tail = node;
            size++;
        }

        public void addToStart(int data){
            Node node = new Node(data);
            if (head != null) {
                head.prev = node;
                node.next = head;
            }
            else {
                tail = node;
            }
            head = node;
            size++;
        }

        public int getNumberAt(int index){
            return getNodeAt(index).data;
        }

        public Node getNodeAt(int index){
            Node node = head;
            for (int i = 0; i < index; i++){
                node = node.next;
            }
            return node;
        }

        public void reverse(){
            if (head != null && head.next != null) {
                Node prev = null;
                Node current = head;
                Node next = head.next;
                while (next != null){
                    current.next = prev;
                    current.prev = next;
                    prev = current;
                    current = next;
                    next = next.next;
                }

                current.next = prev;
                head = current;
                head.prev = null;
                tail = getNodeAt(size-1);
            }
        }

}
