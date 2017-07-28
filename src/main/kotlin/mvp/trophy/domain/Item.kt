package mvp.trophy.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

/**
 * Created by joshhorecny on 7/27/17.
 */
@Document(collection = "Item")
data class Item (
        @Id
        var id: String? = null,
        var name: String,
        var description: String,
        var creator: String,
        var rooms: List<String>,
        var owners: List<String>,
        var createdDate: LocalDate,
        var restrictions: Restriction,
        var imageURI: String,
        var imageNotCollectedURI: String
)