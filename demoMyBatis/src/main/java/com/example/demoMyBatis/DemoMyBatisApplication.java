package com.example.demoMyBatis;

import com.example.demoMyBatis.mapper.ClientMapper;
import com.example.demoMyBatis.mapper.FindAllMapper;
import com.example.demoMyBatis.model.Client;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;

import javax.sql.DataSource;
import java.util.List;

@SpringBootApplication
public class DemoMyBatisApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(DemoMyBatisApplication.class, args);
	}

	@Autowired
	private ClientMapper clientMapper;

	@Autowired
	private FindAllMapper findAllMapper;

	@Override
	public void run(String...args) throws Exception {

		logger.info("Selecting -> {}", "Theo");
		//logger.info("Fetched -> {}", clientMapper.findByFirstName("Theo"));

		/*logger.info("All users -> {}", employeeRepository.findAll())*/;
		logger.info("Fetching all");
		List<Client> clients = clientMapper.findAllUsers();
		clients.forEach(client -> System.out.println(client.getFirstName()));
		logger.info("All users -> {}", findAllMapper.findAll());
	}


	@Autowired
	private ResourceLoader resourceLoader;

	@Bean
	@ConfigurationProperties("spring.datasource")
	public DataSource dataSource() { return DataSourceBuilder.create().build(); }

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setTypeAliasesPackage("com.example.demoMyBatis.model");
		sessionFactory.setMapperLocations(ResourcePatternUtils.getResourcePatternResolver(resourceLoader).
				getResources("classpath:/mybatis/*.xml"));
		return sessionFactory;
	}

}
