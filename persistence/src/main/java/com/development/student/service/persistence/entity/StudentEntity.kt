package com.development.student.service.persistence.entity

import com.development.config.Auditable
import com.querydsl.core.annotations.QueryEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.Email
import org.jetbrains.annotations.NotNull


@Entity
@QueryEntity
@Table(name = "students")
class StudentEntity: Auditable() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null

    @NotNull
    @Column(unique = true)
    private var dni: String? = null

    @NotNull
    private val name: String? = null

    @Email
    private val email: String? = null
}
