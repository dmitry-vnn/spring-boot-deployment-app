package dmitry.companies.error

import org.springframework.http.HttpStatus

open class ApiError(message: String = "", val status: HttpStatus): Exception(message)