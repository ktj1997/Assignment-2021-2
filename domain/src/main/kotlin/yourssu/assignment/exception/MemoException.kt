package yourssu.assignment.exception

abstract class MemoException(
    val errorCode: ErrorCodes
) : RuntimeException()