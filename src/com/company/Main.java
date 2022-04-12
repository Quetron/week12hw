package com.company;

class StackFullException extends Exception {}

class StackEmptyException extends Exception {}


class Stack<E> {
    private E[] elements;
    private int index = 0;
    private int size;

    Stack(int size) {
        elements = (E[]) new Object[size];
        this.size = size;
    }

    void push(E element ) throws StackFullException {
        if (index >= size) {
            throw new StackFullException();
        }

        elements[index] = element;
        index++;
    }

    E pop () throws StackEmptyException {
        if (index == 0) {
            throw new StackEmptyException();
        }

        E returnElement = elements[size - index];
        index--;
        return returnElement;
    }
}


public class Main {
    public static void main(String[] agrs) {
        Stack<String> strings = new Stack<>(2);
        try {
            strings.push("Hello");
            strings.push("World");
            System.out.println(strings.pop());
            System.out.println(strings.pop());
        } catch (StackFullException | StackEmptyException e) {
            e.printStackTrace();
        }

    }
}
