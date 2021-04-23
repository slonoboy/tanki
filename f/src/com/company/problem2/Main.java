package com.company.problem2;

public class Main {

    public static void main(String[] args){
        MyLinkedList ls = new MyLinkedList();
        for (int i = 0; i < 10; i++){
            ls.addToStart(i);
        }

        for (int i = 0; i < ls.size; i++){
            System.out.print(ls.getNumberAt(i) + " ");
        }

        System.out.println("");
        ls.reverse();


        for (int i = 0; i < ls.size; i++){
            System.out.print(ls.getNumberAt(i) + " ");
        }

        System.out.println();

        System.out.print(ls.tail.prev.data);

    }
}
