package dao;

import java.util.List;

public interface CommonDao<T>
{
    List<T> getAll();
    T get(int id);

    void add(T param);
    void update(T param);
    void delete(T param);
}
