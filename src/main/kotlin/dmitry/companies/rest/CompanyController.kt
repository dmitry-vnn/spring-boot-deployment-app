package dmitry.companies.rest

import dmitry.companies.dto.CompanyDto
import dmitry.companies.service.CompanyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["companies", "companies/"])
class CompanyController @Autowired constructor(
    val companyService: CompanyService) {

    @GetMapping("{id}")
    fun getCompany(@PathVariable id: Int) =
        companyService.findCompany(id)

    @DeleteMapping("{id}")
    fun deleteCompany(@PathVariable id: Int) {
        companyService.removeCompany(id)
    }

    @PostMapping("")
    fun createCompany(@RequestBody companyDto: CompanyDto) =
        companyService.createCompany(companyDto)


    @GetMapping("")
    fun getAllCompanies() = companyService.companies()


}