package com.hehe.collection;


import java.util.HashMap;

/**
 * @author 刘伟锋
 * @date 2021/07/18
 **/
public class MyHashMap<K, V> {


    private static final Integer CAPACITY = 8;
    private Entry<K, V>[] table;
    private Integer size = 0;


    private void put(K key, V value) {
        if (table == null) {
            inition();
        }

        Integer hashCode = key.hashCode();
        Integer index = indexFor(hashCode);
        for (Entry<K, V> enrty = table[index]; enrty != null; enrty = enrty.next) {
            if (enrty.key.equals(key)) {
                enrty.value = value;
            }
        }
        addEntry(key, value, index);
    }

    private void addEntry(K key, V value, Integer index) {
        Entry<K, V> entry = new Entry<>(key, value, table[index]);
        table[index] = entry;
        size++;
    }


    public V get(K key) {
        Integer hashCode = key.hashCode();
        Integer index = indexFor(hashCode);
        for (Entry<K, V> enrty = table[index]; enrty != null; enrty = enrty.next) {
            if (enrty.key.equals(key)) {
                return enrty.value;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    private int indexFor(Integer hashCode) {
        return hashCode % table.length;
    }

    private void inition() {
        table = new Entry[CAPACITY];
    }


    public class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Entry<K, V> getNext() {
            return next;
        }
    }

    public static void main(String[] args) {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        for (int i = 0; i < 9; i++) {
            myHashMap.put(i, i + "v");
        }

        System.out.println(myHashMap.get(1));


        //1.扩容 2.线程安全

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "1v");
        System.out.println(map.get(1));

    }
}
