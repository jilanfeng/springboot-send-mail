package com.hehe.designMode.memento;

/**
 * @author 刘伟锋
 * @date 2022/02/22
 **/
public class ConfigMemento {

    private ConfigFile configFile;

    public ConfigFile getConfigFile() {
        return configFile;
    }

    public void setConfigFile(ConfigFile configFile) {
        this.configFile = configFile;
    }

    public ConfigMemento(ConfigFile configFile) {
        this.configFile = configFile;
    }
}
