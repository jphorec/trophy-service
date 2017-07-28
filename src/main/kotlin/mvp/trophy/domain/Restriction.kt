package mvp.trophy.domain

import java.time.LocalDateTime
import java.time.LocalTime

/**
 * Created by joshhorecny on 7/27/17.
 */
data class Restriction(val geolocation: String, val startTime: LocalDateTime, val availableTime: LocalTime, val qrCode: String, val hash: String)