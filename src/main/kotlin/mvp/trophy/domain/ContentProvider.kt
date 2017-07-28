package mvp.trophy.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 * Created by joshhorecny on 7/27/17.
 */
@Document(collection = "ContentProvider")
data class ContentProvider (
    @Id
    var id: String,
    var name: String,
    var admins: List<String>,
    var homepageURI: String
)