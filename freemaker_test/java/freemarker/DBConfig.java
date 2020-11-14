package freemarker;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class DBConfig {
	
	@Bean
	   public DataSource dataSource() {
	      BasicDataSource dataSource = new BasicDataSource();
	      
	      dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	      dataSource.setUrl("jdbc:mysql://localhost:53306/me?allowMultiQueries=true&serverTimezone=UTC");
	      dataSource.setUsername("me");
	      dataSource.setPassword("me");

	      return dataSource;
	   }

	 

	   @Bean
	   public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
	      SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
	      sqlSessionFactory.setDataSource(dataSource);

	      sqlSessionFactory.setMapperLocations(
	         new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/mapper/*.xml")
	      );

	      return (SqlSessionFactory)sqlSessionFactory.getObject();
	   }

	   @Bean
	   public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
	      return new SqlSessionTemplate(sqlSessionFactory);
	   } 
}
