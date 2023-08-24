package dmitry.companies.auth

import org.springframework.beans.factory.annotation.Value
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.core.annotation.Order
//import org.springframework.security.authentication.BadCredentialsException
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
//import org.springframework.security.config.http.SessionCreationPolicy
//import org.springframework.security.web.SecurityFilterChain

//@Configuration
//@EnableWebSecurity
//@Order(1)
class ApiSecurityConfig(
    @Value("\${application.api-key}")
    private val apiKeyValue: String
) {

    //@Bean
    //fun securityFilterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
    //
    //    val apiKeyAuthFilter = ApiKeyAuthFilter("X-API-Key")
    //
    //    apiKeyAuthFilter.setAuthenticationManager { authentication ->
    //
    //        val incomingApiKey = authentication.principal as String
    //
    //        if (apiKeyValue != incomingApiKey) {
    //            throw BadCredentialsException("invalid api key")
    //        }
    //
    //        authentication.isAuthenticated = true
    //
    //        authentication
    //    }
    //
    //    httpSecurity.securityMatcher("/**")
    //        .csrf { it.disable() }
    //        .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
    //        .addFilter(apiKeyAuthFilter).authorizeHttpRequests { it.anyRequest().authenticated() }
    //
    //    return httpSecurity.build()
    //}
}
