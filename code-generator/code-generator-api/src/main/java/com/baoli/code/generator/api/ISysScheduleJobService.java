package com.baoli.code.generator.api;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jeerigger.frame.page.PageHelper;
import java.util.List;
import com.baoli.code.generator.model.SysScheduleJobModel;
import com.jeerigger.frame.base.service.BaseService;

/**
 * <p>
 * 系统计划任务表  用来维护计划任务的开启与取消 服务类
 * </p>
 *
 * @author Libj
 * @since 2020-01-14
 */
public interface ISysScheduleJobService extends BaseService<SysScheduleJobModel> {

 Page<SysScheduleJobModel> listSysScheduleJobModelByPage(PageHelper<SysScheduleJobModel> sysScheduleJobModel);
 List<SysScheduleJobModel> listSysScheduleJobModel(SysScheduleJobModel sysScheduleJobModel);

 SysScheduleJobModel saveSysScheduleJobModel(SysScheduleJobModel sysScheduleJobModel);

 SysScheduleJobModel updateSysScheduleJobModel(SysScheduleJobModel sysScheduleJobModel);

}
