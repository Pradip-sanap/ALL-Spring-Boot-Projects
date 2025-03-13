package com.cybage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
  

import com.cybage.repository.Repository;
import com.cybage.service.Service;

@Configuration
public class AppConfig {

	@Bean
    public Repository repository() {
        return new Repository();
    }

    @Bean
    public Service service(Repository repository) {
        return new Service(repository);
    }


}
