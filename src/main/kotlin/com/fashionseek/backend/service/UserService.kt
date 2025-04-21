package com.fashionseek.backend.service

import com.fashionseek.backend.dto.SignupRequest
import com.fashionseek.backend.entity.User
import com.fashionseek.backend.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {
    private val passwordEncoder = BCryptPasswordEncoder()

    fun signup(request: SignupRequest): String {
        if (userRepository.findByEmail(request.email) != null) {
            throw IllegalArgumentException("이미 존재하는 이메일입니다.")
        }
        val encodedPassword = passwordEncoder.encode(request.password)
        val user = User(email = request.email, password = encodedPassword)
        userRepository.save(user)
        return "회원가입 완료"
    }
}
