package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jeerigger.frame.exception.ValidateException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jeerigger.frame.page.PageHelper;
import com.jeerigger.frame.support.validate.ValidateUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.stereotype.Service;

/**
* <p>
    * ${table.comment!} 服务实现类
    * </p>
*
* @author ${author}
* @since ${date}
*/
@Service
<#if kotlin>
    open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

    }
<#else>
    public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {


    @Override
    public Page<${entity}> list${entity}ByPage(PageHelper<${entity}> pageHelper) {
    LambdaQueryWrapper<${entity}> queryWrapper = new LambdaQueryWrapper<>();
    //编写查询条件
    if (null != pageHelper.getData()) {
    ${entity} ${"${entity}"?uncap_first} = pageHelper.getData();
    queryWrapper = assembleQueryWrapper(${entity?uncap_first});
    }
    Page< ${entity}> page = new Page<>(pageHelper.getCurrent(), pageHelper.getSize());
    return (Page< ${entity}>) this.page(page, queryWrapper);
    }

    /**
    * 组装 LambdaQueryWrapper
    *
    * @param ${entity?uncap_first}
    * @return
    */
    private LambdaQueryWrapper<${entity}> assembleQueryWrapper(${entity} ${entity?uncap_first}) {
    LambdaQueryWrapper<${entity}> queryWrapper = new LambdaQueryWrapper<>();
    if (null != ${entity?uncap_first}) {
    <#list table.fields as field>
        <#if  field.propertyName=="updateUserName"||field.propertyName=="updateUser"||field.propertyName=="updateDate"||field.propertyName=="createDate"||field.propertyName=="createUser"||field.propertyName=="createUserName"||field.propertyName=="uuid">
        <#else>
            <#if  field.comment?contains("查询")>
                <#if field.propertyType=="String">
                    if (StringUtils.isNotEmpty(${"${entity}"?uncap_first}.get${field.propertyName?cap_first}())) {
                    queryWrapper.like(${entity}::get${field.propertyName?cap_first}, ${"${entity}"?uncap_first}.get${field.propertyName?cap_first}());
                    }
                <#else>
                    if (null !=${"${entity}"?uncap_first}.get${field.propertyName?cap_first}()) {
                    queryWrapper.eq(${entity}::get${field.propertyName?cap_first}, ${"${entity}"?uncap_first}.get${field.propertyName?cap_first}());
                    }
                </#if>

            </#if>
        </#if>
    </#list>
    }
    return queryWrapper;
    }





    @Override
    public List<${entity}> list${entity}(${entity} ${entity?uncap_first}) {
    //编写查询条件
    LambdaQueryWrapper<${entity}> queryWrapper = assembleQueryWrapper(${entity?uncap_first});
    return this.list(queryWrapper);
    }

    @Override
    public ${entity} save${entity}(${entity} ${"${entity}"?uncap_first}) {
    //校验${entity}实体类中的注解  eg:@NotNull 不允许为空
    ValidateUtil.validateObject(${"${entity}"?uncap_first});
    this.save(${"${entity}"?uncap_first});
    return ${"${entity}"?uncap_first};
    }


    @Override
    public ${entity} update${entity}(${entity} ${"${entity}"?uncap_first}) {
    ValidateUtil.validateObject(${"${entity}"?uncap_first});
    this.updateById(${"${entity}"?uncap_first});
    return ${"${entity}"?uncap_first};
    }


    }
</#if>
