package mvp.trophy.controller

import mvp.trophy.domain.Organization
import mvp.trophy.service.OrganizationService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

/**
 * Created by joshhorecny on 7/27/17.
 */
@RestController
@RequestMapping("/trophy-service")
class OrganizationController (val organizationService: OrganizationService) {
    @RequestMapping("/organization")
    fun getOrganizations (): List<Organization> {
        return organizationService.getAllOrganizations()
    }
    @RequestMapping("/organization/{id}")
    fun getOrganization (@PathVariable id: String) : Organization {
        return organizationService.getOrganization(id)
    }
    @PostMapping("/organization")
    fun createOrganization(@RequestBody organization: Organization) : Organization {
        return organizationService.createOrganization(organization)
    }
}