package com.wang.utils;

import java.util.List;

/**
 * Created by zxm on 2017/8/11.
 */
public interface RedisBaiseTakes<H,K,V> {
    //��
    public void add(K key, String value);
    public void addObj(H objectKey, K key, V object);
    //ɾ
    public void delete(K key);
    public void delete(List<K> listKeys);
    public void deletObj(H objecyKey, K key);
    //��
    public void update(K key, String value);
    public void updateObj(H objectKey, K key, V object);
    //��
    public String get(K key);
    public V getObj(H objectKey, K key);
}
