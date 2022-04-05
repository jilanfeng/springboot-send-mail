package com.hehe.gos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author 刘伟锋
 * @date 2021/10/06
 **/
@Data
public class DriverReturnAppDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 运单号
     */
    @NotEmpty(message = "单号不能为空",groups = ReturnScan.class)
    private String trackingNo;

    @NotEmpty(message = "司机编号不能为空",groups = {PullDown.class,ReturnScan.class})
    private String driverCode;

    @NotEmpty(message = "司机名称不能为空",groups = {PullDown.class})
    private String driveName;

    /**
     * 作业单状态
     */
    @NotEmpty(message = "作业单状态不能为空", groups = ReturnQuery.class)
    private String status;

    public interface ReturnScan {
    }


    public interface PullDown {
    }

    public interface ReturnQuery {
    }
}
