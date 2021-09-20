package yourssu.assignment.model.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import yourssu.assignment.model.entity.Memo
import java.time.LocalDateTime

@Repository
interface MemoRepository : JpaRepository<Memo, Long> {
    fun findAllByCreatedAtIsBetween(start: LocalDateTime, end: LocalDateTime, pageable: Pageable): Page<Memo>
}