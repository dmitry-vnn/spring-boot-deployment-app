package dmitry.companies.service

import dmitry.companies.dto.CompanyCreatedResponseDto
import dmitry.companies.dto.CompanyDto
import dmitry.companies.dto.ModifiedCompanyDtoRequest

interface CompanyService {

    fun createCompany(company: CompanyDto) : CompanyCreatedResponseDto

    fun removeCompany(id: Int)

    fun modify(id: Int, modifiedDto: ModifiedCompanyDtoRequest)

    fun companies() : List<CompanyDto>

}