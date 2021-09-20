package yourssu.assignment.exception

import org.springframework.http.HttpStatus

class ExceptionResponse(
    val message: String,
    val code: String,
    val status: HttpStatus
) {
}