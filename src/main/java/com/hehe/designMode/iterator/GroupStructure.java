package com.hehe.designMode.iterator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 核心迭代器功能的实现
 *
 * @author 刘伟锋
 * @date 2022/02/13
 **/
public class GroupStructure implements Collection<Employee,Link> {

    /**
     * 组织ID
     */
    private String groupId;

    /**
     * 组织名称
     */
    private String groupName;


    /**
     * 雇员列表
     */
    private Map<String,Employee> employeeMap =  new ConcurrentHashMap<String,Employee>();


    /**
     * 组织架构关系；id -> list
     */
    private Map<String, List<Link>> linkMap = new ConcurrentHashMap<String,List<Link>>();


    /**
     * 反向关系链
     */
    private Map<String,String> invertedMap = new ConcurrentHashMap<String,String>();


    public GroupStructure(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    @Override
    public boolean add(Employee employee) {
        return null != employeeMap.put(employee.getuId(),employee);
    }

    @Override
    public boolean remove(Employee employee) {
        return null != employeeMap.remove(employee.getuId());
    }

    @Override
    public boolean addLink(String key, Link link) {
        invertedMap.put(link.getToId(),link.getFromId());
        if (linkMap.containsKey(key)) {
            return  linkMap.get(key).add(link);
        } else {
            List<Link> links = new LinkedList<Link>();
            links.add(link);
            linkMap.put(key,links);
            return true;
        }
    }

    @Override
    public boolean removeLink(String key) {
        return null != linkMap.remove(key);
    }

    @Override
    public Iterator<Employee> iterator() {
        return new Iterator<Employee>() {
            HashMap<String,Integer> keyMap = new HashMap<String, Integer>();
            int totalIdx = 0;
            /**
             * 雇员ID，From
             */
            private String fromId = groupId;

            /**
             * 雇员ID，To
             */
            private String toId = groupId;
            @Override
            public boolean hasNext() {
                return totalIdx < employeeMap.size();
            }

            @Override
            public Employee next() {
                List<Link> links = linkMap.get(toId);
                int cursorIdx = getCursorIdx(toId);

                //同级节点扫描
                if (null == links) {
                    cursorIdx = getCursorIdx(fromId);
                    links = linkMap.get(fromId);
                }

                //上级节点扫描
                while (cursorIdx > links.size() - 1) {
                    fromId = invertedMap.get(fromId);
                    cursorIdx = getCursorIdx(fromId);
                    links = linkMap.get(fromId);
                }

                //获取节点
                Link link = links.get(cursorIdx);
                toId = link.getToId();
                fromId = link.getFromId();
                totalIdx ++;
                //返回结果
                return employeeMap.get(link.getToId());
            }


            /**
             * 给每个层级定义宽度遍历进度
             *
             * @param key
             * @return
             */
            private int getCursorIdx(String key) {
                int idx = 0;
                if (keyMap.containsKey(key)) {
                    idx = keyMap.get(key);
                    keyMap.put(key,++idx);
                } else {
                    keyMap.put(key,idx);
                }
                return idx;
            }
        };
    }


}
