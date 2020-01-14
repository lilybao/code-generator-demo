import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *  @description: 业务平台使用代码生成器  生成全套代码 不用进行业务代码的任何编写
 *  * 只需要将业务流程的表设计好，然后给需要生成代码的表加上表注释和字段注释（会根据这些注释生成代码的注释）；
 *  * 如果字段的注释中包含有  “-查询”字段，会在生成代码的列表查询中包含该字段的查询代码，默认是 如果varchar类型字段使用 like查询（lambda表达式），如果其他字段使用eq来查询
 *  * 该代码生成器可以直接生成到项目的module中，只需要配置好module的名称
 * @author: li baojian
 * @create: 2019/10/23 11:23
 */
public class ActivitiCodeGenerator {
    public static void main(String[] args) {


        //需要生成的表名
        String[] tables = new String[]{"template_info"};
        //修改成自己的module名称
        String moduleName = "/process-manage/";


        String projectPath = System.getProperty("user.dir") + moduleName;
        String middleJavaPath = "/src/main/java/";
        String middleResourcesPath = "/src/main/resources/";

        //如果不想生成某个类  只需要把路径设置为 ""  eg:   String controllerPath ="";
        //修改成自己的controller文件所在的module名称和package路径
        String controllerPath = projectPath + "process-manage-web" + middleJavaPath + "com/zskj/process/controller/";
        //修改成自己的api文件所在的module名称和package路径
        String servicePath = projectPath + "process-manage-api" + middleJavaPath + "com/zskj/process/api/";
        //修改成自己的service文件所在的module名称和package路径
        String serviceImplPath = projectPath + "process-manage-service" + middleJavaPath + "com/zskj/process/service/";
        String modelPath = projectPath + "process-manage-model" + middleJavaPath + "com/zskj/process/model/";
        //修改成自己的mapper文件所在的module名称和package路径
        String mapperPath = projectPath + "process-manage-service" + middleJavaPath + "com/zskj/process/mapper/";
        //修改成自己的xml文件所在的module名称和路径
        String mapperXmlPath = projectPath + "process-manage-service" + middleResourcesPath + "mapper/";
        //如果不想生成某个类只需要设置为空即可
        serviceImplPath="";
        controllerPath="";
        modelPath="";
        mapperPath="";
        mapperXmlPath="";
        servicePath="";
        //包结构配置
        PackageConfig pc = new PackageConfig();
        //父包名  如果为空，将下面子包名必须写全部， 否则就只需写子包名  eg:   package com.zskj.template.model;
        String pack = "com.zskj.process";
        pc.setParent(pack);
        pc.setEntity("model");
        pc.setService("api");
        pc.setServiceImpl("service");
        pc.setController("controller");
        pc.setMapper("mapper");
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        // 从试图获取
        //dsc.setSchemaName("V_LAW_CAMERA");
//        dsc.setSchemaName()
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/dap_1.0?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Hongkong&allowPublicKeyRetrieval=true&autoReconnect=true");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        jdbc:sqlserver://192.168.0.161:1433;DatabaseName=DAP_1.0

//        dsc.setUrl("jdbc:sqlserver://192.168.0.73:1433;DatabaseName=zsonline");
//        dsc.setDriverName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        dsc.setUsername("sa");
//        dsc.setPassword("guzz123");
//        dsc.setUrl("jdbc:sqlserver://192.168.0.161:1433;DatabaseName=DAP_1.0");
//        dsc.setDriverName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        dsc.setUsername("sa");
//        dsc.setPassword("hnzs@admin1");
        dsc.setDbType(DbType.MYSQL);
        executeCode(pc, dsc, tables, moduleName, controllerPath, serviceImplPath, servicePath, mapperPath, mapperXmlPath, modelPath);
    }

    private static void executeCode(PackageConfig pc, DataSourceConfig dsc, String[] tables, String moduleName, String controllerPath, String serviceImplPath, String servicePath, String mapperPath, String mapperXmlPath, String modelPath) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 是否覆盖已有文件
        gc.setFileOverride(true);
        // 生成文件的输出目录
        String projectPath = System.getProperty("user.dir") + moduleName;
        //该目录会默认生成到D：/根目录   如果配置上面这个会生成到当前模块下`
//        gc.setOutputDir(projectPath + "/src/test/resources");
//        gc.setOutputDir(projectPath);
        gc.setEntityName("%sModel");
        // 开发人员
        gc.setAuthor("Libj");
        // 是否打开输出目录
        gc.setOpen(false);
        // 开启 BaseResultMap
        gc.setBaseResultMap(true);
        // 指定生成的主键的ID类型
        gc.setIdType(IdType.ID_WORKER);
        // 时间类型对应策略: 只使用 java.util.date 代替
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);
        mpg.setDataSource(dsc);
        mpg.setPackageInfo(pc);
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        //使用freemaker模板
        //mapper.xml层
        if (!StringUtils.isEmpty(mapperXmlPath)) {
            focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    if (StringUtils.isEmpty(mapperXmlPath)) {
                        return projectPath + "/src/test/resources/mapper/" + tableInfo.getXmlName() + StringPool.DOT_XML;
                    }
                    return mapperXmlPath + tableInfo.getXmlName() + StringPool.DOT_XML;
                }
            });
        }
        if (!StringUtils.isEmpty(controllerPath)) {
            //controller层
            focList.add(new FileOutConfig("/templates/controller.java.ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return controllerPath + tableInfo.getControllerName() + StringPool.DOT_JAVA;
                }
            });
        }
        if (!StringUtils.isEmpty(modelPath)) {
            //model层
            focList.add(new FileOutConfig("/templates/entity.java.ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return modelPath + tableInfo.getEntityName() + StringPool.DOT_JAVA;
                }
            });
        }
        if (!StringUtils.isEmpty(mapperPath)) {
            //mapper层
            focList.add(new FileOutConfig("/templates/mapper.java.ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return mapperPath + tableInfo.getMapperName() + StringPool.DOT_JAVA;
                }
            });
        }
        if (!StringUtils.isEmpty(servicePath)) {
            //service层
            focList.add(new FileOutConfig("/templates/service.java.ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return servicePath + tableInfo.getServiceName() + StringPool.DOT_JAVA;
                }
            });
        }
        if (!StringUtils.isEmpty(serviceImplPath)) {
            //serviceImpl层
            focList.add(new FileOutConfig("/templates/serviceImpl.java.ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return serviceImplPath + tableInfo.getServiceImplName() + StringPool.DOT_JAVA;
                }
            });
        }
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setSuperControllerClass("com.jeerigger.frame.base.controller.BaseController");
        strategy.setSuperEntityClass("com.jeerigger.frame.base.model.BaseActivitiModel");
        strategy.setSuperServiceImplClass("com.jeerigger.frame.base.service.impl.BaseActivitiServiceImpl");
        strategy.setSuperServiceClass("com.jeerigger.frame.base.service.BaseActivitiService");
        strategy.setSuperMapperClass("com.jeerigger.frame.base.mapper.BaseActivitiMapper");
        strategy.setRestControllerStyle(false);
        // 数据库表映射到实体的命名策略: 下划线转驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 数据库表字段映射到实体的命名策略: 下划线转驼峰命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 【实体】是否为lombok模型（默认 false）
        strategy.setEntityLombokModel(true);
        // 需要包含的表名，允许正则表达式（与exclude二选一配置）
        strategy.setInclude(tables);
        // 驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        // 表前缀
//        strategy.setTablePrefix(tablePrefixs);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
