package com.myThreadsLists;

public interface IMyCollections<T> {
    boolean add(T t);
    void remove(T t);
    boolean contains(T t);
    T get(int position);
    int size();
    boolean isEmpty();
    void clear();
}
