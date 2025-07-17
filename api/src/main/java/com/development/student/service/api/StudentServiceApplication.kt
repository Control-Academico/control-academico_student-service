package com.development.student.service.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@ComponentScan(basePackages = ["com.development.student.service"])
@EnableJpaRepositories(basePackages = ["com.development.student.service.persistence"])
@EntityScan(basePackages = ["com.development.student.service.persistence.entity"])
class StudentServiceApplication

fun main(args: Array<String>) {
    runApplication<StudentServiceApplication>(*args)
}
