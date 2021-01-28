package kata.twitter.core.repository

import kata.twitter.core.domain.entities.Post

class InMemoryPostRepository: PostRepository {
    private val posts: MutableMap<String, MutableList<Post>> = mutableMapOf()
    
    override fun save(post: Post) {
        if (posts.containsKey(post.owner)) {
            posts[post.owner]?.add(post)
        } else {
            posts[post.owner] = mutableListOf(post)
        }
    }

    override fun getBy(id: String) = this.posts.values.flatten()
    
    override fun getByUser(userId: String) =  this.posts[userId]?.toList() as List<Post>
}