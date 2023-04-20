package com.example.thesocialnetwork.authentication.shared.mocks

import com.example.thesocialnetwork.authentication.shared.repository.domain.AuthRepository

class MockAuthRepository : AuthRepository {
    private val mockUsers = mapOf(
        "daniel@test.io" to "123456",
        "murillo@test.io" to "98765",
        "jorch@test.io" to "qwerty"
    )

    override suspend fun login(email: String, password: String): String? {
        if (mockUsers.containsKey(email)) {
            if (mockUsers[email] == password) {
                return "Token: MOCK_TOKEN $email"
            }
        }
        return null
    }

    override suspend fun singUp(email: String, password: String): String? {
        if (mockUsers.containsKey(email)) {
            if (mockUsers[email] == password) {
                return "Token: MOCK_TOKEN"
            }
        }
        return null
    }

    override suspend fun forgotPassword(email: String, mobile: String): String? {
        if (mockUsers.containsKey(email)) {
            return "Token: MOCK_TOKEN $email"
        }
        return null
    }
}
