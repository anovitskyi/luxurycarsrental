package service;


import java.util.List;

public interface CommonService<T>
{
    List<T> getAll();
    T get(int id);

    void add(T param);
    void update(T param);
    void delete(int id);
}
