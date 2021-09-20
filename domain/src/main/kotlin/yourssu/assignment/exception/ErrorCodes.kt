package yourssu.assignment.exception

enum class ErrorCodes(val code: String, val message: String) {
    MEMO_NOT_EXISTS("Memo-001", "Memo가 존재하지 않습니다"),
    INVALID_DATE_FORMAT("Memo-002", "유효하지 않은 날짜 포멧입니다.")
}