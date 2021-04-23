package com.company.problem1;


public class Main {

    public static void main(String[] args){
        MyLinkedList ls = new MyLinkedList();
        for (int i = 0; i < 10; i++){
            ls.addToStart(i);
        }

        for (int i = 0; i < 10; i++){
            System.out.print(ls.getNumberAt(i) + " ");
        }

        System.out.println();

        System.out.println(ls.head.next.data);
    }
}
