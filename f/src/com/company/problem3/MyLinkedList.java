package com.company.problem3;

public class MyLinkedList {
        public Node head;
        public Node tail;
        public int size;

        public void add(int data){
            Node node = new Node(data);
            if (head == null){
                head = node;
            }
            else{
                tail.next = node;
                node.prev = tail;
                node.next = head;
                head.prev = node;
            }
            tail = node;
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
}
