package ru.rvkovtunov.payments.income.service.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "ru.rvkovtunov.payments")
@EnableJpaRepositories(basePackages = {"ru.rvkovtunov.payments.income.service.dataaccess"})
@EntityScan(basePackages = {"ru.rvkovtunov.payments.income.service.dataaccess"})
public class IncomeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IncomeServiceApplication.class, args);
    }

}
