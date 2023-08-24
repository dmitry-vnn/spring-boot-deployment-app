package dmitry.companies.mapper

import dmitry.companies.dto.CompanyDto
import dmitry.companies.entity.Company
import org.springframework.stereotype.Component

@Component
class CompanyMapperImpl : CompanyMapper {

    override fun convertToEntity(dto: CompanyDto) = dto.run {
        Company(companyName, founded, registrationAddress, industry, founders)
    }

    override fun convertToDto(company: Company): CompanyDto = company.run {
        CompanyDto(name, foundDate, registrationAddress, industry, founders)
    }

    override fun convertToDto(companies: List<Company>) =
        companies.map { convertToDto(it) }.toList()

}
