package com.development.student.service.api.controller

import com.development.student.service.shared.dto.StudentResponse
import com.development.student.service.domain.service.IStudentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/student")
class StudentController (private val service: IStudentService){

    @GetMapping
    fun getAll(): ResponseEntity<List<StudentResponse?>> {
        return ResponseEntity.ok(service.list())
    }

}