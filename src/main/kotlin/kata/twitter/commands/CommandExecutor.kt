package kata.twitter.commands

class CommandExecutor(val commandFactory: CommandFactory): CommandDispatcher {

    override fun execute(command: String) {
        val command = this.commandFactory.from(command)
        command.execute()
    }
}