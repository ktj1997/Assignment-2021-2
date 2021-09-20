package yourssu.assignment.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import yourssu.assignment.request.MemoRequest
import yourssu.assignment.response.DetailMemoResponse
import yourssu.assignment.response.SimpleMemoResponse
import yourssu.assignment.service.MemoService
import yourssu.assignment.utils.DateUtils
import javax.validation.Valid

@RestController
@RequestMapping("/memos")
class MemoController(
    private val memoService: MemoService
) {

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getMemo(
        @Valid @PathVariable id: Long
    ): DetailMemoResponse {
        return DetailMemoResponse(
            memoService.getMemo(id)
        )
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun searchMemo(
        @RequestParam date: String?,
        @RequestParam page: Int?
    ): SimpleMemoResponse {
        return SimpleMemoResponse(
            memoService.searchMemo(
                date?.let { DateUtils.parseStringToDate(it) },
                page ?: 0
            )
        )
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveMemo(
        @Valid @RequestBody req: MemoRequest
    ): DetailMemoResponse {
        return DetailMemoResponse(
            memoService.saveMemo(req.title, req.text)
        );
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateMemo(
        @Valid @PathVariable id: Long,
        @Valid @RequestBody req: MemoRequest
    ): DetailMemoResponse {
        return DetailMemoResponse(
            memoService.updateMemo(id, req.title, req.text)
        )
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteMemo(
        @Valid @PathVariable id: Long
    ) {
        memoService.deleteMemo(id)
    }
}