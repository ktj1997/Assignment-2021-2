package yourssu.assignment.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.format.DateTimeParseException

@RestControllerAdvice
class MemoExceptionHandler {

    @ExceptionHandler(MemoNotExistException::class)
    fun handleMemoNotExistException(e: MemoException): ExceptionResponse {
        return ExceptionResponse(e.errorCode.message, e.errorCode.code, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(DateTimeParseException::class)
    fun handleDateTimeParseException(e: RuntimeException): ExceptionResponse {
        return ExceptionResponse(
            ErrorCodes.INVALID_DATE_FORMAT.message,
            ErrorCodes.INVALID_DATE_FORMAT.code,
            HttpStatus.BAD_REQUEST
        )
    }
}