package kata.twitter.commands

import kata.twitter.core.use.cases.ReadPostsUseCase

class ReadPostCommnad(private val postReader: ReadPostsUseCase, private val command: String): Command {

    override fun execute() { 
        this.postReader.readPost(command)
    }

}