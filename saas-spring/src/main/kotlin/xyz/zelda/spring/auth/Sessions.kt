package xyz.zelda.spring.auth

import xyz.zelda.spring.crypto.Sign
import java.util.*
import java.util.concurrent.TimeUnit
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

object Sessions {
    val SHORT_SESSION = TimeUnit.HOURS.toMillis(12)
    val LONG_SESSION = TimeUnit.HOURS.toMillis(30 * 24.toLong())
    fun loginUser(userId: String?,
                  support: Boolean,
                  rememberMe: Boolean,
                  signingSecret: String?,
                  externalApex: String?,
                  response: HttpServletResponse) {
        val duration: Long
        val maxAge: Int
        duration = if (rememberMe) {
            // "Remember me"
            LONG_SESSION
        } else {
            SHORT_SESSION
        }
        maxAge = (duration / 1000).toInt()
        val token: String = signingSecret?.let { Sign.generateSessionToken(userId, it, support, duration) }.toString()
        val cookie = Cookie(AuthConstant.COOKIE_NAME, token)
        cookie.path = "/"
        cookie.domain = externalApex
        cookie.maxAge = maxAge
        cookie.isHttpOnly = true
        response.addCookie(cookie)
    }

    fun getToken(request: HttpServletRequest): String? {
        val cookies = request.cookies
        if (cookies == null || cookies.size == 0) return null
        val tokenCookie = Arrays.stream(cookies)
                .filter { cookie: Cookie -> AuthConstant.COOKIE_NAME == cookie.name }
                .findAny().orElse(null)
                ?: return null
        return tokenCookie.value
    }

    fun logout(externalApex: String?, response: HttpServletResponse) {
        val cookie = Cookie(AuthConstant.COOKIE_NAME, "")
        cookie.path = "/"
        cookie.maxAge = 0
        cookie.domain = externalApex
        response.addCookie(cookie)
    }
}