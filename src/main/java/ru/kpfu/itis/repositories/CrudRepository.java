package ru.kpfu.itis.repositories;

import java.util.List;

public interface CrudRepository<T> {
    T save(T t);
    List<T> findAll();


}
