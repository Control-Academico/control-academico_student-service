package com.development.student.service.persistence.repository

import com.development.student.service.persistence.entity.StudentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer
import org.springframework.data.querydsl.binding.QuerydslBindings
import java.util.Optional

interface IStudentJpaRepository : JpaRepository<StudentEntity?, Long?>,
    QuerydslPredicateExecutor<StudentEntity>
{
    fun findByDni(dni: String?): Optional<StudentEntity?>?

//    override fun customize(bindings: QuerydslBindings, root: QStudentEntity) {
//        bindings.bind(root.dni).first { path, value ->
//            path.containsIgnoreCase(value)
//        }
//    }

}