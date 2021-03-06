package mvp.trophy.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 * Created by joshhorecny on 7/27/17.
 */
@Document(collection = "User")
data class User (
        @Id
        var id: String? = null,
        var firstName: String,
        var lastName: String,
        var username: String,
        var userType: String,
        var friends: List<String>? = null,
        var following: List<String>? = null,
        var rooms: List<String>? = null,
        var items: List<String>? = null

)