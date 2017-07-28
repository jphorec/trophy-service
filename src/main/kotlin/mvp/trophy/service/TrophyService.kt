package mvp.trophy.service

import mvp.trophy.domain.*

/**
 * Created by joshhorecny on 7/27/17.
 */

interface UserService {
    fun getAllUsers(): List<User>
    fun getUser(id: String): User
    fun createUser(user: User): User
    fun updateUser(id: String, user: User): User
    fun deleteUser(id: String)
}

interface RoomService {
    fun getAllRooms(): List<Room>
    fun getRoom(id: String): Room
    fun createRoom(id: String): Room
}

interface ContentProviderService {
    fun getAllProviders(): List<ContentProvider>
    fun getContentProvider(id: String): ContentProvider
    fun createContentProvider(id: String): ContentProvider
}

interface OrganizationService {
    fun getAllOrganizations(): List<Organization>
    fun getOrganzion(id: String): Room
    fun createRoom(id: String): Room
}

interface ItemService {
    fun getAllItems(): List<Item>
    fun getItem(id: String): Item
    fun createItem(item: Item): Item
}