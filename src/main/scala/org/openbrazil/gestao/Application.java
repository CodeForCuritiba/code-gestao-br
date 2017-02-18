package org.openbrazil.gestao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Bootstrapp class.
 */
@SpringBootApplication(scanBasePackages={"org.openbrazil.*.service","org.openbrazil.*.controller"})
@EnableJpaRepositories(basePackages={"org.openbrazil.*.repository"})
public class Application extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
