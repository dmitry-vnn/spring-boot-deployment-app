package dmitry.companies.error

import org.springframework.http.HttpStatus

class CompanyNotFoundError : ApiError("company not found", HttpStatus.NOT_FOUND)
