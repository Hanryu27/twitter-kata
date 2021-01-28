package kata.twitter.core.domain.entities

import java.time.LocalDateTime

data class Post(
    val owner: String,
    val message: String,
    val date: LocalDateTime = LocalDateTime.now(),
    val postId: Number = Math.random()
)