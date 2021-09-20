package yourssu.assignment

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
open class MemoApplication

fun main(args: Array<String>) {
    runApplication<MemoApplication>(*args)
}
