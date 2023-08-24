package dmitry.companies.error

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ErrorHandler {

    @ExceptionHandler(ApiError::class)
    fun handle(error: ApiError) =
        ResponseEntity(ErrorModel(error.message!!), error.status)
}
