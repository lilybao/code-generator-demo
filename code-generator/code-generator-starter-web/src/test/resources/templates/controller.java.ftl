package ${package.Controller};

import com.jeerigger.core.common.annotation.Log;
import com.jeerigger.core.common.enums.LogTypeEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jeerigger.frame.support.resolver.annotation.SingleRequestBody;
import com.jeerigger.frame.page.PageHelper;
import org.springframework.web.bind.annotation.*;
import com.jeerigger.frame.base.controller.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${entity?uncap_first?substring(0,entity?length-5)}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
 @Api(value = "${entity}管理", tags = "${entity}管理")
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>
    @Autowired
    private ${table.serviceName} ${"${table.serviceName}"?substring(1,"${table.serviceName}"?length)?uncap_first};

       @ResponseBody
       @ApiOperation(value = "分页查询",notes="${table.comment}")
       @RequestMapping(value = "/listPage", method = RequestMethod.POST)
       public ResultData list${entity}ByPage(@RequestBody PageHelper<${entity}> ${"${entity}"?uncap_first}) {
            return this.success(${"${table.serviceName}"?substring(1,"${table.serviceName}"?length)?uncap_first}.list${entity}ByPage(${"${entity}"?uncap_first}));
        }

       @ResponseBody
       @ApiOperation(value = "列表查询",notes="${table.comment}")
       @RequestMapping(value = "/list", method = RequestMethod.POST)
       public ResultData list${entity}(@RequestBody ${entity} ${"${entity}"?uncap_first}) {
            return this.success(${"${table.serviceName}"?substring(1,"${table.serviceName}"?length)?uncap_first}.list${entity}(${"${entity}"?uncap_first}));
       }

       @ResponseBody
       @ApiOperation(value = "获取详情",notes="${table.comment}")
       @RequestMapping(value = "/detail", method = RequestMethod.POST)
       public ResultData detail(@SingleRequestBody String uuid) {
            return this.success(${"${table.serviceName}"?substring(1,"${table.serviceName}"?length)?uncap_first}.getById(uuid));
       }

        @ResponseBody
        @ApiOperation(value = "保存",notes="${table.comment}")
        @RequestMapping(value = "/save", method = RequestMethod.POST)
        @Log(logType = LogTypeEnum.BUSSINESS,logTitle = "保存")
        public ResultData save${entity}(@RequestBody ${entity} ${"${entity}"?uncap_first}) {
        try {
        return this.success(${"${table.serviceName}"?substring(1,"${table.serviceName}"?length)?uncap_first}.save${entity}( ${"${entity}"?uncap_first}));
        } catch (Exception e) {
        return this.failed(ResultCodeEnum.ERROR_SAVE_FAIL, e.getMessage());
        }
        }

        @ResponseBody
        @ApiOperation(value = "更新",notes="${table.comment}")
        @RequestMapping(value = "/update", method = RequestMethod.POST)
        @Log(logType = LogTypeEnum.BUSSINESS,logTitle = "更新")
        public ResultData update${entity}(@RequestBody ${entity} ${"${entity}"?uncap_first}) {
        try {
        return this.success(${"${table.serviceName}"?substring(1,"${table.serviceName}"?length)?uncap_first}.update${entity}(${"${entity}"?uncap_first}));
        } catch (Exception e) {
        return this.failed(ResultCodeEnum.ERROR_SAVE_FAIL, e.getMessage());
        }
        }

        @ResponseBody
        @ApiOperation(value = "删除",notes="${table.comment}")
        @RequestMapping(value = "/delete", method = RequestMethod.POST)
        @Log(logType = LogTypeEnum.BUSSINESS,logTitle = "删除")
        public ResultData delete${entity}(@SingleRequestBody String uuid) {
        if (${"${table.serviceName}"?substring(1,"${table.serviceName}"?length)?uncap_first}.removeById(uuid)) {
        return this.success(ResultCodeEnum.SUCCESS);
        }
        return this.failed(ResultCodeEnum.ERROR_SAVE_FAIL);
        }

}
</#if>
