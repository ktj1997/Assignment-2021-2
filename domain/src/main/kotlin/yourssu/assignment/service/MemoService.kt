package yourssu.assignment.service

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import yourssu.assignment.exception.MemoNotExistException
import yourssu.assignment.model.dto.DetailMemoDto
import yourssu.assignment.model.dto.SimpleMemoDto
import yourssu.assignment.model.entity.Memo
import yourssu.assignment.model.repository.MemoRepository
import yourssu.assignment.utils.DateUtils
import java.time.LocalDate

@Service
open class MemoService(
    private val memoRepository: MemoRepository
) {

    @Transactional(readOnly = true)
    open fun searchMemo(date: LocalDate?, page: Int): List<SimpleMemoDto> {
        val pageable = PageRequest.of(page, 5, Sort.by("id").descending())
        return if (date == null)
            memoRepository.findAll(pageable)
                .content.map { SimpleMemoDto(it) }
        else {
            val range = DateUtils.getDateRange(date)
            println(range.second)
            return memoRepository.findAllByCreatedAtIsBetween(range.first, range.second, pageable).content.map {
                SimpleMemoDto(
                    it
                )
            }
        }


    }

    @Transactional
    open fun saveMemo(title: String, text: String): DetailMemoDto {
        val memo = memoRepository.save(
            Memo(
                null,
                title,
                text
            )
        )
        return DetailMemoDto(memo)
    }

    @Transactional(readOnly = true)
    open fun getMemo(id: Long): DetailMemoDto {
        val memo = memoRepository.findByIdOrNull(id) ?: throw MemoNotExistException()
        return DetailMemoDto(memo)
    }

    @Transactional
    open fun updateMemo(id: Long, title: String, text: String): DetailMemoDto {
        val memo = memoRepository.findByIdOrNull(id)?.updateMemo(title, text) ?: throw MemoNotExistException()
        memoRepository.flush();
        return DetailMemoDto(memo)
    }

    @Transactional
    open fun deleteMemo(id: Long) {
        val memo = memoRepository.findByIdOrNull(id) ?: throw MemoNotExistException()
        memoRepository.delete(memo)
    }
}