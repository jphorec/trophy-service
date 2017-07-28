package mvp.trophy.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 * Created by joshhorecny on 7/27/17.
 */
@Document(collection = "Organization")
data class Organization (
        @Id
        var id: String,
        var name: String,
        var homepageURI: String,
        var rooms: List<String>,
        var images: List<String>,
        var items: List<String>
)