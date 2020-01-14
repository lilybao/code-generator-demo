package com.baoli.code.generator.service;

import com.baoli.code.generator.api.ISysScheduleJobService;
import com.baoli.code.generator.mapper.SysScheduleJobMapper;
import com.baoli.code.generator.model.SysScheduleJobModel;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jeerigger.frame.base.service.impl.BaseServiceImpl;
import com.jeerigger.frame.page.PageHelper;
import com.jeerigger.frame.support.validate.ValidateUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统计划任务表  用来维护计划任务的开启与取消 服务实现类
 * </p>
 *
 * @author Libj
 * @since 2020-01-14
 */
@Service
public class SysScheduleJobServiceImpl extends BaseServiceImpl<SysScheduleJobMapper, SysScheduleJobModel> implements ISysScheduleJobService {


    @Override
    public Page<SysScheduleJobModel> listSysScheduleJobModelByPage(PageHelper<SysScheduleJobModel> pageHelper) {
        LambdaQueryWrapper<SysScheduleJobModel> queryWrapper = new LambdaQueryWrapper<>();
        //编写查询条件
        if (null != pageHelper.getData()) {
            SysScheduleJobModel sysScheduleJobModel = pageHelper.getData();
            queryWrapper = assembleQueryWrapper(sysScheduleJobModel);
        }
        Page<SysScheduleJobModel> page = new Page<>(pageHelper.getCurrent(), pageHelper.getSize());
        return (Page<SysScheduleJobModel>) this.page(page, queryWrapper);
    }

    /**
     * 组装 LambdaQueryWrapper
     *
     * @param sysScheduleJobModel
     * @return
     */
    private LambdaQueryWrapper<SysScheduleJobModel> assembleQueryWrapper(SysScheduleJobModel sysScheduleJobModel) {
        LambdaQueryWrapper<SysScheduleJobModel> queryWrapper = new LambdaQueryWrapper<>();
        if (null != sysScheduleJobModel) {
        }
        return queryWrapper;
    }


    @Override
    public List<SysScheduleJobModel> listSysScheduleJobModel(SysScheduleJobModel sysScheduleJobModel) {
        //编写查询条件
        LambdaQueryWrapper<SysScheduleJobModel> queryWrapper = assembleQueryWrapper(sysScheduleJobModel);
        return this.list(queryWrapper);
    }

    @Override
    public SysScheduleJobModel saveSysScheduleJobModel(SysScheduleJobModel sysScheduleJobModel) {
        //校验SysScheduleJobModel实体类中的注解  eg:@NotNull 不允许为空
        ValidateUtil.validateObject(sysScheduleJobModel);
        this.save(sysScheduleJobModel);
        return sysScheduleJobModel;
    }


    @Override
    public SysScheduleJobModel updateSysScheduleJobModel(SysScheduleJobModel sysScheduleJobModel) {
        ValidateUtil.validateObject(sysScheduleJobModel);
        this.updateById(sysScheduleJobModel);
        return sysScheduleJobModel;
    }


}
