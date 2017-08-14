package mvp.trophy.repository

import mvp.trophy.domain.*
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

/**
 * Created by joshhorecny on 7/27/17.
 */
@Repository
interface ContentProviderRepository : MongoRepository<ContentProvider, String> {
    fun findByIdIn(ids: List<String>) : List<ContentProvider>
}

@Repository
interface OrganizationRepository : MongoRepository<Organization, String> {
     fun findByIdIn(ids: List<String>) : List<Organization>
}

@Repository
interface ItemRepository : MongoRepository<Item, String> {
    fun findByIdIn(ids: List<String>) : List<Item>
}

@Repository
interface UserRepository : MongoRepository<User, String> {
    fun findByIdIn(ids: List<String>) : List<User>
}

@Repository
interface RoomRepository : MongoRepository<Room, String> {
    fun findByIdIn(ids: List<String>) : List<Room>
}