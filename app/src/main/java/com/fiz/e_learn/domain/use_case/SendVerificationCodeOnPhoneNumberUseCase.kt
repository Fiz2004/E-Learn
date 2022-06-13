package com.fiz.e_learn.domain.use_case

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SendVerificationCodeOnPhoneNumberUseCase @Inject constructor() {

    suspend operator fun invoke(): Boolean = withContext(Dispatchers.Default) {
        delay(3000)
        val isVerificationCodeTrue = true
        isVerificationCodeTrue
    }
}