package kata.twitter

import io.reactivex.rxjava3.kotlin.subscribeBy
import kata.twitter.commands.CommandDispatcher
import kata.twitter.commands.CommandExecutor
import kata.twitter.commands.CommandFactory
import kata.twitter.core.facades.Facade
import kata.twitter.core.repository.InMemoryPostRepository
import kata.twitter.core.use.cases.CreatePostUseCase
import kata.twitter.core.use.cases.FollowUserUserCase
import kata.twitter.core.use.cases.ReadPostsUseCase
import kata.twitter.core.use.cases.WallUseCase
import kata.twitter.frontal.Console
import kata.twitter.frontal.ObservableConsole
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val twitter = TwitterKata.of()
    twitter.run()
}

internal class TwitterKata private constructor(
    private val console: Console,
    private val commandDispatcher: CommandDispatcher
) {
    companion object {
        fun of(console: Console = ObservableConsole()): TwitterKata {
            val repository = InMemoryPostRepository()
            val facade = Facade(repository, console)
            val commandFactory: CommandFactory = CommandFactory(facade)
            return TwitterKata(console, CommandExecutor(commandFactory))
        }
    }


    fun run(inLoop: Boolean = true) {
        this.console.getLines()
            .subscribeBy(
                onNext = { this.commandDispatcher.execute(it) },
                onError = { it.printStackTrace() },
                onComplete = {
                    println("See ya!")
                    exitProcess(0)
                }
            )

        if (inLoop) {
            while (true) {
                this.console.readLine()
            }
        } else {
            this.console.readLine()
        }
    }

}
