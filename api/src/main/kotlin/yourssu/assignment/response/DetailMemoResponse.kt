package yourssu.assignment.response

import com.fasterxml.jackson.annotation.JsonFormat
import yourssu.assignment.model.dto.DetailMemoDto
import java.time.LocalDateTime

data class DetailMemoResponse(
    val id: Long,
    val title: String,
    val text: String,
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
    constructor(dto: DetailMemoDto) : this(dto.id, dto.title, dto.text, dto.createdAt, dto.updatedAt)
}