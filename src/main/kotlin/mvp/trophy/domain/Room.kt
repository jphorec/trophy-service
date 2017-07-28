package mvp.trophy.domain

import org.springframework.data.mongodb.core.mapping.Document

/**
 * Created by joshhorecny on 7/27/17.
 */
@Document(collection = "Room")
data class Room (
        var id: String? = null,
        var name: String,
        var description: String,
        var owners: String,
        var backgroundURI: String,
        var items: List<String>,
        var followers: List<String>,
        var roomType: String
)