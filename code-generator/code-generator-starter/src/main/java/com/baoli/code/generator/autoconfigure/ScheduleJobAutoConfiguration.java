package com.baoli.code.generator.autoconfigure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 计划任务自动配置类
 * @author: li baojian
 * @create: 2020/01/14 14:32
 */
@Configuration
@MapperScan("com.baoli.code.generator.mapper")
@ComponentScan("com.baoli.code.generator.*")
public class ScheduleJobAutoConfiguration {
}
