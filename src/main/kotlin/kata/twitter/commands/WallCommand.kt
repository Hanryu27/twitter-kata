package kata.twitter.commands

import kata.twitter.core.use.cases.WallUseCase

class WallCommand(private val wall: WallUseCase, private val command: String): Command {

    override fun execute() { 
        this.wall.wallUse()
   }

}