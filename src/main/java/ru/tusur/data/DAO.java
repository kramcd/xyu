package ru.tusur.data;

import java.util.Collection;
import java.util.List;

/**
 * xyu
 * ru.tusur.data
 * by Oleg Alekseev
 * 15.04.14.
 */
public interface DAO<T> {

    Collection<T> getAll();

    T getById(int id);

    void insert(T record);

    void save(T record);

    void remove(T record);

}
