package org.java;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStack<T> {
    public int  MAX = 10;

    private Deque<T> buf = new ArrayDeque<T>();

    public void push(T o) {
        if (!full()) { buf.add(o);}
        else { throw new IllegalStateException("can't push onto a full stack"); }
    }

    public T pop() {
        if (!empty()) { return buf.pop();}
        else { throw new IllegalStateException("can't pop an empty stack"); }
    }

    public T peek() {
        if (!empty()) { return buf.peek(); }
        else { throw new IllegalStateException("can't pop an empty stack"); }
    }

    public boolean full() {
        return buf.size() == MAX;
    }

    public boolean empty() {
        return buf.size() == 0;
    }

    public int size() {
        return buf.size();
    }

    @Override
    public String toString(){
        return "org.java.Stack("+buf.stream().map(x -> String.valueOf(x)).collect(Collectors.joining(","))+")";
    }

}