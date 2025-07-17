package com.development.student.service.core.service

import com.development.student.service.shared.dto.StudentRequest
import com.development.student.service.shared.dto.StudentResponse
import com.development.student.service.persistence.mapper.IStudentMapper
import com.development.student.service.persistence.repository.IStudentJpaRepository
import com.development.student.service.domain.service.IStudentService
import org.springframework.stereotype.Service

@Service
class StudentServiceImpl(
    private val repository: IStudentJpaRepository,
    private val mapper: IStudentMapper
) : IStudentService {

    override fun list(): MutableList<StudentResponse?>? {
        return repository.findAll()
            .map { mapper.toDtoResponse(it) }
            .toMutableList()
    }

    override fun getById(id: Long?): StudentResponse? {
        return null
    }

    override fun save(studentRequest: StudentRequest?) {
        studentRequest?.let {
            mapper.toEntity(it)?.let { entity ->
                repository.save(entity)
            }
        }
    }

    override fun update(studentRequest: StudentRequest?) {
    }

    override fun getByDni(dni: String?): StudentResponse? {
        return this.repository.findByDni(dni)
            ?.map { mapper.toDtoResponse(it) }
            ?.orElse(StudentResponse())
    }
}
