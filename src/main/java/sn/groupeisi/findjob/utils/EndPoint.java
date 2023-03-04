package sn.groupeisi.findjob.utils;

public abstract class EndPoint {
    public static final String SIGN_IN_URL = "/login";
    public static final String SAVE = "/save";
    public static final String UPDATE = "/update/{id}";
    public static final String UPDATE_BY_NAME = "/update/{name}";
    public static final String FIND_ALL = "/findAll";
    public static final String DELETE = "/delete/{id}";
    public static final String FIND_BY_ID = "/findById/{id}";
    public static final String FIND_BY_NAME = "/findByName/{name}";
}
