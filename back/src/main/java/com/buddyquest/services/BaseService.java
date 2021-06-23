package com.buddyquest.services;

import java.util.List;

public interface BaseService<T, ID> {

    void create(T object);
    void remove(ID id);
    void update(T object);
    List<T> getAll();
    T findById(ID id);
}
