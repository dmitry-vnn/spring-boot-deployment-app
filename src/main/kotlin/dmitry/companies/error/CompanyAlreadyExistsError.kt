package dmitry.companies.error

import org.springframework.http.HttpStatus

class CompanyAlreadyExistsError : ApiError("company already exists", HttpStatus.BAD_REQUEST)
