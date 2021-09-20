package yourssu.assignment.model.entity

import javax.persistence.*

@Entity
data class Memo(
    @field:Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @Column(length = 20, nullable = false)
    var title: String,

    @Lob
    var text: String,
) : BaseTimeEntity() {

    fun updateMemo(title: String, text: String): Memo {
        this.title = title
        this.text = text
        return this
    }
}
