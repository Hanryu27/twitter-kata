package kata.twitter.core.facades

import kata.twitter.core.domain.entities.Post
import kata.twitter.core.repository.PostRepository
import kata.twitter.core.use.cases.CreatePostUseCase
import kata.twitter.core.use.cases.FollowUserUserCase
import kata.twitter.core.use.cases.ReadPostsUseCase
import kata.twitter.core.use.cases.WallUseCase
import kata.twitter.frontal.Console

interface UseCases: CreatePostUseCase, FollowUserUserCase, ReadPostsUseCase, WallUseCase

class Facade(private val repository: PostRepository, private val console: Console):  UseCases {
    override fun createPost(username: String, message: String) {
        println("Creating post from username: $username and message: $message")
        val post = Post(username, message)
        this.repository.save(post)
    }

    override fun followUser() {
        TODO("Not yet implemented")
    }

    override fun readPost(username: String) {
        println("Trying to read posts from user: $username")
        val posts = this.repository.getByUser(username.trim())
        posts.forEach {
            this.console.writeLine(it.message)
        }
    }

    override fun wallUse() {
        TODO("Not yet implemented")
    }
}