package mvp.trophy.repository

import mvp.trophy.domain.*
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

/**
 * Created by joshhorecny on 7/27/17.
 */
@Repository
interface ContentProviderRepository : MongoRepository<ContentProvider, String>

@Repository
interface OrganizationRepository : MongoRepository<Organization, String>

@Repository
interface ItemRepository : MongoRepository<Item, String>

@Repository
interface UserRepository : MongoRepository<User, String>

@Repository
interface RoomRepository : MongoRepository<Room, String>