package com.hehe.designMode.iterator;

/**
 * @author εδΌι
 * @date 2022/02/13
 **/
public interface Collection<E,L> extends Iterable<E> {

    boolean add(E e);

    boolean remove(E e);

    boolean addLink(String key,L l);

    boolean removeLink(String key);

    @Override
    Iterator<E> iterator();
}
