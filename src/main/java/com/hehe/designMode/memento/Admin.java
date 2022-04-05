package com.hehe.designMode.memento;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 刘伟锋
 * @date 2022/02/22
 **/
public class Admin {

    private int cursorIdx = 0;

    private List<ConfigMemento> mementoList = new ArrayList<ConfigMemento>();
    private Map<String, ConfigMemento> mementoMap = new ConcurrentHashMap<String, ConfigMemento>();

    public void append(ConfigMemento memento) {
        mementoList.add(memento);
        mementoMap.put(memento.getConfigFile().getVersion(), memento);
        cursorIdx++;
    }


    public ConfigMemento undo() {
        if (--cursorIdx <= 0) return mementoList.get(0);
        return mementoList.get(cursorIdx);
    }

    public ConfigMemento redo() {
        if (++cursorIdx > mementoList.size()) return mementoList.get(mementoList.size() -1);
        return mementoList.get(cursorIdx);
    }

    public  ConfigMemento get(String version) {
        return mementoMap.get(version);
    }

}
