package yourssu.assignment.request

import javax.validation.constraints.NotEmpty

class MemoRequest(
    @field:NotEmpty
    val title: String,
    @field:NotEmpty
    val text: String,
)