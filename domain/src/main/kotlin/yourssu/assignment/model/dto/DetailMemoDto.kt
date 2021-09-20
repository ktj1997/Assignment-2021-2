package yourssu.assignment.model.dto

import yourssu.assignment.model.entity.Memo
import java.time.LocalDateTime

data class DetailMemoDto(
    val id: Long,
    val title: String,
    val text: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    constructor(memo: Memo) : this(memo.id!!, memo.title, memo.text, memo.createdAt!!, memo.updatedAt!!)
}