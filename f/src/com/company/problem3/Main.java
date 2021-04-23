package com.company.problem3;

public class Main {

    public static void main(String[] args){
        MyLinkedList ls = new MyLinkedList();
        for (int i = 0; i < 10; i++){
            ls.add(i);
        }

        System.out.println(ls.getNodeAt(0).prev.data);
    }
}
