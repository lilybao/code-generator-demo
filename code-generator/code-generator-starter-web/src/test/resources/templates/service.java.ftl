package ${package.Service};
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jeerigger.frame.page.PageHelper;
import java.util.List;
import ${package.Entity}.${entity};
import ${superServiceClassPackage};

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

 Page<${entity}> list${entity}ByPage(PageHelper<${entity}> ${"${entity}"?uncap_first});
 List<${entity}> list${entity}(${entity} ${"${entity}"?uncap_first});

 ${entity} save${entity}(${entity} ${"${entity}"?uncap_first});

 ${entity} update${entity}(${entity} ${"${entity}"?uncap_first});

}
</#if>
