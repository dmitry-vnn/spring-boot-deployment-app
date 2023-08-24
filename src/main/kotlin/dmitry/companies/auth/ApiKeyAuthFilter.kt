package dmitry.companies.auth

import jakarta.servlet.http.HttpServletRequest
//import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter

class ApiKeyAuthFilter(private val principalHeader: String) /*: AbstractPreAuthenticatedProcessingFilter() {

    override fun getPreAuthenticatedPrincipal(request: HttpServletRequest): Any? {
        return request.getHeader(principalHeader)
    }

    override fun getPreAuthenticatedCredentials(request: HttpServletRequest): Any? {
        return null
    }
}
*/