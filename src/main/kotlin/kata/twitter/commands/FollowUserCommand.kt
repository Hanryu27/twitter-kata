package kata.twitter.commands

import kata.twitter.core.use.cases.FollowUserUserCase

class FollowUserCommand(private val userFollower: FollowUserUserCase, private val command: String): Command {

    override fun execute() { 
        this.userFollower.followUser()
    }

}