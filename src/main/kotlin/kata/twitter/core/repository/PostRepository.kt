package kata.twitter.core.repository

import kata.twitter.core.domain.entities.Post

interface PostRepository {
    fun save(post: Post)
    fun getBy(id: String): List<Post>
    fun getByUser(userId: String): List<Post>
}