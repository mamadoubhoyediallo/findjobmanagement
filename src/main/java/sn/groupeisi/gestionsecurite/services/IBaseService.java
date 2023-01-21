package sn.groupeisi.gestionsecurite.services;

import java.util.List;

public interface IBaseService<T> {
    public T save(T t);
    public List<T> findAll();
}
