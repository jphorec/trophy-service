package mvp.trophy.controller

import mvp.trophy.domain.Organization
import mvp.trophy.service.OrganizationService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

/**
 * Created by joshhorecny on 7/27/17.
 */
@RestController
@RequestMapping("/trophy-service")
class OrganizationController (val organizationService: OrganizationService) {
    @RequestMapping("/organization")
    fun getAllOrganizations(): ResponseEntity<List<Organization>> {
        val organizations: List<Organization> = organizationService.getAllOrganizations() ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(organizations, HttpStatus.OK)
    }

    @RequestMapping("/organization/{id}")
    fun getOrganization(@PathVariable id: String): ResponseEntity<Organization> {
        val organization: Organization = organizationService.getOrganization(id) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(organization, HttpStatus.OK)
    }

    @PostMapping("/organization")
    fun createOrganization(@RequestBody organization: Organization): ResponseEntity<Organization> {
        val organization: Organization = organizationService.createOrganization(organization) ?: return ResponseEntity(HttpStatus.BAD_REQUEST)
        return ResponseEntity(organization, HttpStatus.CREATED)
    }

    @PutMapping("/organization/{id}")
    fun updateOrganization(@PathVariable("id") id: String, @RequestBody organization: Organization): ResponseEntity<Organization> {
        val organization: Organization = organizationService.updateOrganization(id, organization) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(organization, HttpStatus.OK)
    }

    @DeleteMapping("/organization/{id}")
    fun deleteOrganization(@PathVariable("id") id: String): ResponseEntity<HttpStatus> {
        if (organizationService.deleteOrganization(id))
            return ResponseEntity(HttpStatus.NO_CONTENT)
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @RequestMapping("/organizations")
    fun getOrganizationsById(@RequestParam("id") ids: List<String>): ResponseEntity<List<Organization>> {
        val organizations: List<Organization> = organizationService.getOrganizationsById(ids) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(organizations, HttpStatus.OK)
    }
}