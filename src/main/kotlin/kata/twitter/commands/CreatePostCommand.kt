package kata.twitter.commands

import kata.twitter.core.use.cases.CreatePostUseCase

class CreatePostCommand(private val postCreator: CreatePostUseCase, private val command: String): Command {

    override fun execute() {
        val (username, message) = command.split("->")
        this.postCreator.createPost(username.trim(), message.trim())
    }

}