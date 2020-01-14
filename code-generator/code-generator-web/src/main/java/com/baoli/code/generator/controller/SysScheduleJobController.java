package com.baoli.code.generator.controller;


import com.baoli.code.generator.api.ISysScheduleJobService;
import com.jeerigger.core.common.annotation.Log;
import com.jeerigger.core.common.enums.LogTypeEnum;
import com.jeerigger.frame.base.controller.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jeerigger.frame.support.resolver.annotation.SingleRequestBody;
import com.jeerigger.frame.page.PageHelper;
import org.springframework.web.bind.annotation.*;
import com.jeerigger.frame.base.controller.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.baoli.code.generator.model.SysScheduleJobModel;

import org.springframework.stereotype.Controller;
import com.jeerigger.frame.base.controller.BaseController;

/**
 * <p>
 * 系统计划任务表  用来维护计划任务的开启与取消 前端控制器
 * </p>
 *
 * @author Libj
 * @since 2020-01-14
 */
@Controller
@RequestMapping("/sysScheduleJob")
@Api(value = "SysScheduleJobModel管理", tags = "SysScheduleJobModel管理")
public class SysScheduleJobController extends BaseController {
    @Autowired
    private ISysScheduleJobService sysScheduleJobService;

    @ResponseBody
    @ApiOperation(value = "分页查询", notes = "系统计划任务表  用来维护计划任务的开启与取消")
    @RequestMapping(value = "/listPage", method = RequestMethod.POST)
    public ResultData listSysScheduleJobModelByPage(@RequestBody PageHelper<SysScheduleJobModel> sysScheduleJobModel) {
        return this.success(sysScheduleJobService.listSysScheduleJobModelByPage(sysScheduleJobModel));
    }

    @ResponseBody
    @ApiOperation(value = "列表查询", notes = "系统计划任务表  用来维护计划任务的开启与取消")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResultData listSysScheduleJobModel(@RequestBody SysScheduleJobModel sysScheduleJobModel) {
        return this.success(sysScheduleJobService.listSysScheduleJobModel(sysScheduleJobModel));
    }

    @ResponseBody
    @ApiOperation(value = "获取详情", notes = "系统计划任务表  用来维护计划任务的开启与取消")
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public ResultData detail(@SingleRequestBody String uuid) {
        return this.success(sysScheduleJobService.getById(uuid));
    }

    @ResponseBody
    @ApiOperation(value = "保存", notes = "系统计划任务表  用来维护计划任务的开启与取消")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Log(logType = LogTypeEnum.BUSSINESS, logTitle = "保存")
    public ResultData saveSysScheduleJobModel(@RequestBody SysScheduleJobModel sysScheduleJobModel) {
        try {
            return this.success(sysScheduleJobService.saveSysScheduleJobModel(sysScheduleJobModel));
        } catch (Exception e) {
            return this.failed(ResultCodeEnum.ERROR_SAVE_FAIL, e.getMessage());
        }
    }

    @ResponseBody
    @ApiOperation(value = "更新", notes = "系统计划任务表  用来维护计划任务的开启与取消")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @Log(logType = LogTypeEnum.BUSSINESS, logTitle = "更新")
    public ResultData updateSysScheduleJobModel(@RequestBody SysScheduleJobModel sysScheduleJobModel) {
        try {
            return this.success(sysScheduleJobService.updateSysScheduleJobModel(sysScheduleJobModel));
        } catch (Exception e) {
            return this.failed(ResultCodeEnum.ERROR_SAVE_FAIL, e.getMessage());
        }
    }

    @ResponseBody
    @ApiOperation(value = "删除", notes = "系统计划任务表  用来维护计划任务的开启与取消")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @Log(logType = LogTypeEnum.BUSSINESS, logTitle = "删除")
    public ResultData deleteSysScheduleJobModel(@SingleRequestBody String uuid) {
        if (sysScheduleJobService.removeById(uuid)) {
            return this.success(ResultCodeEnum.SUCCESS);
        }
        return this.failed(ResultCodeEnum.ERROR_SAVE_FAIL);
    }

}
