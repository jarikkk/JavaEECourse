package model.dao;


public interface DAO<T>{
    void create(T t);
    T get(int id);
    void update(T t);
    void delete(int id);

}
