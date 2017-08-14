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

    override fun getUser(id: String): User? {
        return userRepository.findOne(id)
    }

    override fun createUser(user: User): User? {
        return userRepository.save(user)
    }

    override fun updateUser(id: String, user: User): User? {
        if (userRepository.exists(id)) {
            userRepository.save(user)
        }
        return null
    }

    override fun deleteUser(id: String): Boolean {
        if (userRepository.exists(id)) {
            userRepository.delete(id)
            return true
        }
        return false
    }

    override fun getUsersById(ids: List<String>): List<User>? {
        return userRepository.findByIdIn(ids)
    }

}

@Service
class RoomServiceImpl (val roomRepository: RoomRepository) : RoomService {
    override fun updateRoom(id: String, room: Room): Room? {
        if (roomRepository.exists(id)) {
            return roomRepository.save(room)
        }
        return null
    }

    override fun deleteRoom(id: String): Boolean {
        if (roomRepository.exists(id)) {
            roomRepository.delete(id)
            return true
        }
        else
            return false
    }

    override fun getRoomsById(ids: List<String>): List<Room>? {
        return roomRepository.findByIdIn(ids)
    }

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
    override fun updateOrganization(id: String, organization: Organization): Organization? {
        if (organizationRepository.exists(id)) {
            return organizationRepository.save(organization)
        }
        return null
    }

    override fun deleteOrganization(id: String): Boolean {
        if (organizationRepository.exists(id)) {
            organizationRepository.delete(id)
            return true
        }
        return false
    }

    override fun getOrganizationsById(ids: List<String>): List<Organization>? {
        return organizationRepository.findByIdIn(ids)
    }

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
    override fun updateItem(id: String, item: Item): Item? {
        if (itemRepository.exists(id)) {
            return itemRepository.save(item)
        }
        return null
    }

    override fun deleteItem(id: String): Boolean {
        if (itemRepository.exists(id)) {
            itemRepository.delete(id)
            return true
        }
        return false
    }

    override fun getItemsById(ids: List<String>): List<Item>? {
        return itemRepository.findByIdIn(ids)
    }

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
    override fun updateContentProvider(id: String, contentProvider: ContentProvider): ContentProvider? {
        if (contentProviderRepository.exists(id)) {
            return contentProviderRepository.save(contentProvider)
        }
        return null
    }

    override fun deleteContentProvider(id: String): Boolean {
        if (contentProviderRepository.exists(id)) {
            contentProviderRepository.delete(id)
            return true
        }
        return false
    }

    override fun getProvidersById(ids: List<String>): List<ContentProvider>? {
        return contentProviderRepository.findByIdIn(ids)
    }

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