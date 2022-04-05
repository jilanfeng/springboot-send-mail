package com.hehe.designMode.authlink;

/**
 * @author 刘伟锋
 * @date 2022/02/17
 **/
public class AuthInfo {

    /**
     * 编码
     */
    private String code;


    /**
     * 信息
     */
    private String info = "";

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public AuthInfo(String code, String ...infos) {
        this.code = code;
        for (String str : infos) {
            this.info = this.info.concat(str);
        }
    }
}
