package unit.commands

import kata.twitter.commands.*
import kata.twitter.core.facades.UseCases
import kata.twitter.core.use.cases.CreatePostUseCase
import kata.twitter.core.use.cases.FollowUserUserCase
import kata.twitter.core.use.cases.ReadPostsUseCase
import kata.twitter.core.use.cases.WallUseCase
import org.junit.jupiter.api.Assertions
import org.mockito.Mockito.mock
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object CommandFactoryTest : Spek({
    describe("Given a CommandFactory") {
        lateinit var commandFactory: CommandFactory

        beforeGroup {
            commandFactory = CommandFactory(
                mock(UseCases::class.java)
            )
        }

        describe("And a post message is received") {
            val message = "Alice -> Hello! How are you?"

            it("should create a CreatePostCommand") {
                val command = commandFactory.from(message)
                Assertions.assertTrue(command is CreatePostCommand)
            }
        }

        describe("And a read post message is received") {
            val message = "Alice"

            it("should create a ReadPostCommand") {
                val command = commandFactory.from(message)
                Assertions.assertTrue(command is ReadPostCommnad)
            }
        }

        describe("And a follow user message is received") {
            val message = "Alice follows Bob"
            it("should create a FollowUserCommand") {
                val command = commandFactory.from(message)
                Assertions.assertTrue(command is FollowUserCommand)
            }
        }


        describe("And a wall user message is received") {
            val message = "Alice wall"
            it("should create a WallCommand") {
                val command = commandFactory.from(message)
                Assertions.assertTrue(command is WallCommand)
            }
        }
    }
})

