package dmitry.companies.service

import dmitry.companies.dto.CompanyCreatedResponseDto
import dmitry.companies.dto.CompanyDto
import dmitry.companies.dto.ModifiedCompanyDtoRequest
import dmitry.companies.error.CompanyAlreadyExistsError
import dmitry.companies.error.CompanyNotFoundError
import dmitry.companies.mapper.CompanyMapper
import dmitry.companies.repository.CompanyRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CompanyServiceImpl @Autowired constructor(

    private val companyRepository: CompanyRepository,
    private val companyMapper: CompanyMapper

): CompanyService {

    override fun createCompany(company: CompanyDto): CompanyCreatedResponseDto {

        if (companyRepository.findByName(company.companyName) != null)
            throw CompanyAlreadyExistsError()

        val entity = companyMapper.convertToEntity(company)

        companyRepository.save(entity);

        return CompanyCreatedResponseDto(entity.id!!)
    }

    override fun findCompany(id: Int): CompanyDto =
        companyMapper.convertToDto(companyRepository.findById(id) ?: throw CompanyNotFoundError())

    override fun removeCompany(id: Int) {
        companyRepository.removeById(id)
    }

    override fun modify(id: Int, modifiedDto: ModifiedCompanyDtoRequest) {
        TODO("Not yet implemented")
    }

    override fun companies(): List<CompanyDto> =
        companyMapper.convertToDto(companyRepository.findAll())
}