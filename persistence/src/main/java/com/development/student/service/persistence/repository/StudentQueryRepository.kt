package com.development.student.service.persistence.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import java.time.LocalDateTime

class StudentQueryRepository(
    private val repository: StudentQueryRepository,
    private val queryFactory: JPAQueryFactory
) {

//    fun findStudentsCreatedAfter(date: LocalDateTime): List<StudentEntity> {
//        val student = QStudentEntity.studentEntity
//
//        return queryFactory.selectFrom(student)
//            .where(student.createDate.after(date))
//            .fetch()
//    }
//
//    fun findStudentsByDniPattern(pattern: String): List<StudentEntity> {
//        val student = QStudentEntity.studentEntity
//
//        return queryFactory.selectFrom(student)
//            .where(student.dni.like("%$pattern%"))
//            .fetch()
//    }

}