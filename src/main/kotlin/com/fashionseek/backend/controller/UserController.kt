package com.fashionseek.backend.controller

import com.fashionseek.backend.dto.SignupRequest
import com.fashionseek.backend.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService
) {
    @PostMapping("/signup")
    fun signup(@RequestBody request: SignupRequest): ResponseEntity<String> {
        val result = userService.signup(request)
        return ResponseEntity.ok(result)
    }
}
