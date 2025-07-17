package com.development.student.service.persistence.mapper

import com.development.student.service.shared.dto.StudentRequest
import com.development.student.service.shared.dto.StudentResponse
import com.development.student.service.persistence.entity.StudentEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface IStudentMapper {
    fun toDtoRequest(entity: StudentEntity?): StudentRequest?
    fun toDtoResponse(entity: StudentEntity?): StudentResponse?
    fun toEntity(dto: StudentRequest?): StudentEntity?
}
