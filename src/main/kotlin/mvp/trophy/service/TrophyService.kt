package mvp.trophy.service

import mvp.trophy.domain.*

/**
 * Created by joshhorecny on 7/27/17.
 */

interface UserService {
    fun getAllUsers(): List<User>
    fun getUser(id: String): User?
    fun createUser(user: User): User?
    fun updateUser(id: String, user: User): User?
    fun deleteUser(id: String): Boolean
    fun getUsersById(ids: List<String>) : List<User>?
}

interface RoomService {
    fun getAllRooms(): List<Room>?
    fun getRoom(id: String): Room?
    fun createRoom(room: Room): Room?
    fun updateRoom(id: String, room: Room) : Room?
    fun deleteRoom(id: String) : Boolean
    fun getRoomsById(ids: List<String>) : List<Room>?
}

interface ContentProviderService {
    fun getAllProviders(): List<ContentProvider>?
    fun getContentProvider(id: String): ContentProvider?
    fun createContentProvider(contentProvider: ContentProvider): ContentProvider?
    fun updateContentProvider(id: String, contentProvider: ContentProvider) : ContentProvider?
    fun deleteContentProvider(id: String) : Boolean
    fun getProvidersById(ids: List<String>) : List<ContentProvider>?
}

interface OrganizationService {
    fun getAllOrganizations(): List<Organization>?
    fun getOrganization(id: String): Organization?
    fun createOrganization(organization: Organization): Organization?
    fun updateOrganization(id: String, organization: Organization) : Organization?
    fun deleteOrganization(id: String) : Boolean
    fun getOrganizationsById(ids: List<String>) : List<Organization>?
}

interface ItemService {
    fun getAllItems(): List<Item>?
    fun getItem(id: String): Item?
    fun createItem(item: Item): Item?
    fun updateItem(id: String, item: Item) : Item?
    fun deleteItem(id: String) : Boolean
    fun getItemsById(ids: List<String>) : List<Item>?
}