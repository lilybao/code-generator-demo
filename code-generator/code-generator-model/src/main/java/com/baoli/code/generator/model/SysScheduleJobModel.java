package com.baoli.code.generator.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.jeerigger.frame.base.model.BaseModel;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统计划任务表  用来维护计划任务的开启与取消
 * </p>
 *
 * @author Libj
 * @since 2020-01-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_schedule_job")
@ApiModel(value="SysScheduleJobModel对象", description="系统计划任务表  用来维护计划任务的开启与取消")
public class SysScheduleJobModel extends BaseModel {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "bean名称")
    private String beanName;

    @ApiModelProperty(value = "方法名称")
    private String methodName;

    @ApiModelProperty(value = "参数")
    private String params;

    @ApiModelProperty(value = "cron表达式")
    private String cronExpression;

    @ApiModelProperty(value = "启用状态 0未启用 1 已启用")
    private Integer status;

    @ApiModelProperty(value = "备注")
    private String memo;






}
