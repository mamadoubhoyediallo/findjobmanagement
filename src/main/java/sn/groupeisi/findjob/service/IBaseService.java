package sn.groupeisi.findjob.service;

import java.util.List;

public interface IBaseService<T> {
    public T save(T t);
    public List<T> findAll();
}
