package kata.twitter.commands

import kata.twitter.core.facades.UseCases

class CommandFactory(
    private val useCases: UseCases
) {

    fun from(command: String): Command {
        return when {
            command.contains("->") -> CreatePostCommand(useCases, command)
            command.contains("follow") -> FollowUserCommand(useCases, command)
            command.contains("wall") -> WallCommand(useCases, command)
            else -> ReadPostCommnad(useCases, command)
        }
    }
}