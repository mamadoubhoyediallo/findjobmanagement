package sn.groupeisi.gestionsecurite.services;

import java.util.List;

public interface IBase<T> {
    public T save(T t);
    public T update(T t, int id);
    public void delete(int id);
    public List<T> findAll();
    public T findById(int id);
}
