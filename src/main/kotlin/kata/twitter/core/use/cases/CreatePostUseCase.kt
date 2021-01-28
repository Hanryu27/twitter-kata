package kata.twitter.core.use.cases

interface CreatePostUseCase {
fun createPost(username: String, message: String) 
}