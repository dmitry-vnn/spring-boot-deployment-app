package dmitry.companies.mapper

import dmitry.companies.dto.CompanyDto
import dmitry.companies.entity.Company

//@Mapper(componentModel = "spring")
interface CompanyMapper {

    fun convertToEntity(dto: CompanyDto): Company

    fun convertToDto(company: Company): CompanyDto

    fun convertToDto(companies: List<Company>): List<CompanyDto>

}