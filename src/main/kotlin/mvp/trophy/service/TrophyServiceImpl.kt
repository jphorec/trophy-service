package mvp.trophy.service

import mvp.trophy.domain.*
import mvp.trophy.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by joshhorecny on 7/27/17.
 */

@Service
class UserServiceImpl (val userRepository: UserRepository) : UserService {

    override fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    override fun getUser(id: String): User {
        return userRepository.findOne(id)
    }

    override fun createUser(user: User): User {
        return userRepository.save(user)
    }

    override fun updateUser(id: String, user: User): User {
        return userRepository.save(user)
    }

    override fun deleteUser(id: String) {
        userRepository.delete(id)
    }

}

@Service
class RoomServiceImpl (val roomRepository: RoomRepository) : RoomService {
    override fun getAllRooms(): List<Room> {
        return roomRepository.findAll()
    }

    override fun getRoom(id: String): Room {
        return roomRepository.findOne(id)
    }

    override fun createRoom(room: Room): Room {
        return roomRepository.save(room)
    }

}

@Service
class OrganizationServiceImpl (val organizationRepository: OrganizationRepository) : OrganizationService {
    override fun getAllOrganizations(): List<Organization> {
        return organizationRepository.findAll()
    }

    override fun getOrganization(id: String): Organization {
        return organizationRepository.findOne(id)
    }

    override fun createOrganization(organization: Organization): Organization {
        return organizationRepository.save(organization)
    }

}

@Service
class ItemServiceImpl (val itemRepository: ItemRepository) : ItemService {
    override fun getAllItems(): List<Item> {
        return itemRepository.findAll()
    }

    override fun getItem(id: String): Item {
        return itemRepository.findOne(id)
    }

    override fun createItem(item: Item): Item {
        return itemRepository.save(item)
    }

}

@Service
class ContentProviderServiceImpl (val contentProviderRepository: ContentProviderRepository) : ContentProviderService {
    override fun getAllProviders(): List<ContentProvider> {
        return contentProviderRepository.findAll();
    }

    override fun getContentProvider(id: String): ContentProvider {
        return contentProviderRepository.findOne(id)
    }

    override fun createContentProvider(contentProvider: ContentProvider): ContentProvider {
        return contentProviderRepository.save(contentProvider)
    }

}