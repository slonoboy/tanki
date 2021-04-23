package com.company.problem1;

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
            }
            tail = node;
            size++;
        }

        public void addToStart(int data){
            Node node = new Node(data);
            if (head != null) {
                node.next = head;
            }
            else{
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
}
