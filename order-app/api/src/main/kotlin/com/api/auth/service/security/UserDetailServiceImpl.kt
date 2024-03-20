package com.api.auth.service.security

import com.api.auth.exception.AuthException
import com.api.auth.exception.AuthExceptionType
import com.rds.user.repository.UserRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailServiceImpl (
    private val userRepository: UserRepository
): UserDetailsService {

    override fun loadUserByUsername(email: String): UserDetails {
        val user = (userRepository.findByEmail(email)
            ?: throw AuthException(AuthExceptionType.INVALID_EMAIL))

        val grantedAuthorities: Set<GrantedAuthority> = HashSet()
        return org.springframework.security.core.userdetails
            .User(user.id.toString(), user.password, grantedAuthorities)
    }
}