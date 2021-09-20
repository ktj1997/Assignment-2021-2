package yourssu.assignment.model.dto

import com.fasterxml.jackson.annotation.JsonFormat
import yourssu.assignment.model.entity.Memo
import java.time.LocalDateTime

data class SimpleMemoDto(
    val id: Long,
    val title: String,
    @JsonFormat(
        shape = JsonFormat.Shape.STRING,
        pattern = "yyyy-MM-dd HH:mm:ss",
        locale = "Asia/Seoul"
    )
    val createdAt: LocalDateTime,
    @JsonFormat(
        shape = JsonFormat.Shape.STRING,
        pattern = "yyyy-MM-dd HH:mm:ss",
        locale = "Asia/Seoul"
    )
    val updatedAt: LocalDateTime
) {
    constructor(memo: Memo) : this(memo.id!!, memo.title, memo.createdAt!!, memo.updatedAt!!)
}