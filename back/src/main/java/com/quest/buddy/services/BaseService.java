package com.quest.buddy.services;


public interface BaseService<T, ID> {

    void create(T object);
    void remove(ID id);
    void update(T object);
    Iterable<T> getAll();
    T findById(ID id);
}
