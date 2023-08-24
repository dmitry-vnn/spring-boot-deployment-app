package dmitry.companies.repository

import dmitry.companies.entity.Company

interface CompanyRepository {

    fun findById(id: Int): Company?

    fun findByName(companyName: String): Company?

    fun findAll(): List<Company>

    fun update(company: Company)

    fun remove(company: Company)

    fun removeById(id: Int)

    fun save(company: Company)



}