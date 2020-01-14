package ${package};
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
* <p>
    * ${table.comment!} 自动配置类
    * </p>
*
* @author ${author}
* @since ${date}
*/
@Configuration
@MapperScan(" ${package.Mapper}")
@ComponentScan("${package}")
public class ${entity?substring(1,entity?length-5)}AutoConfiguration {
}