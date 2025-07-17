package com.development.student.service.domain.service

import com.development.student.service.shared.dto.StudentRequest
import com.development.student.service.shared.dto.StudentResponse

interface IStudentService {
    fun list(): MutableList<StudentResponse?>?
    fun getById(id: Long?): StudentResponse?
    fun save(studentRequest: StudentRequest?)
    fun update(studentRequest: StudentRequest?)

    fun getByDni(dni: String?): StudentResponse?
}
