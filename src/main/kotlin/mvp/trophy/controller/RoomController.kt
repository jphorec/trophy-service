package mvp.trophy.controller

import mvp.trophy.domain.Room
import mvp.trophy.service.RoomService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Created by joshhorecny on 7/27/17.
 */
@RestController
@RequestMapping("/trophy-service")
class RoomController (val roomService: RoomService) {
    @RequestMapping("/room")
    fun getRooms() : ResponseEntity<List<Room>> {
        val rooms: List<Room> =  roomService.getAllRooms() ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(rooms, HttpStatus.OK)
    }
    @RequestMapping("/room/{id}")
    fun getRoom(@PathVariable id: String) : ResponseEntity<Room> {
        val room: Room = roomService.getRoom(id) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(room, HttpStatus.OK)
    }
    @PostMapping("/room")
    fun createRoom(@RequestBody room: Room) : ResponseEntity<Room> {
        val createdRoom: Room = roomService.createRoom(room) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(createdRoom, HttpStatus.CREATED)
    }
    @PutMapping("/room/{id}")
    fun updateRoom(@PathVariable("id") id: String, @RequestBody room: Room) : ResponseEntity<Room> {
        val updatedRoom: Room = roomService.updateRoom(id, room) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(updatedRoom, HttpStatus.OK)
    }
    @DeleteMapping("/room/{id}")
    fun deleteRoom(@PathVariable("id") id: String) : ResponseEntity<HttpStatus> {
        if (roomService.deleteRoom(id))
            return ResponseEntity(HttpStatus.NO_CONTENT)
        else
            return ResponseEntity(HttpStatus.NOT_FOUND)
    }
    @RequestMapping("/rooms")
    fun getRoomsWithIds(@RequestParam("id") ids: List<String>) : ResponseEntity<List<Room>> {
        val rooms: List<Room> =  roomService.getRoomsById(ids) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(rooms, HttpStatus.OK)
    }
}