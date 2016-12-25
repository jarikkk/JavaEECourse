package dao;


public interface DAO<T>{
    void create(T t);
    T get(int id);
    boolean update(T t);
    boolean delete(int id);

}
