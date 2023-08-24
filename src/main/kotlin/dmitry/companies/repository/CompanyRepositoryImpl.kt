package dmitry.companies.repository

import dmitry.companies.entity.Company
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.transaction.Transactional
import org.springframework.stereotype.Repository

@Repository
class CompanyRepositoryImpl: CompanyRepository {

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    override fun findById(id: Int): Company? =
        entityManager.find(Company::class.java, id)

    @Transactional
    override fun save(company: Company) {
        entityManager.persist(company)
    }

    override fun findByName(companyName: String): Company? =
        entityManager.createQuery("SELECT c FROM Company c WHERE c.name = :name", Company::class.java)
            .setParameter("name", companyName).resultList.firstOrNull()

    @Transactional
    override fun removeById(id: Int) {
        entityManager.createQuery("DELETE FROM Company c WHERE c.id = :id")
            .setParameter("id", id).executeUpdate()
    }

    override fun findAll(): List<Company> =
        entityManager.createQuery("SELECT c FROM Company c", Company::class.java).resultList

    @Transactional
    override fun update(company: Company) {
        entityManager.merge(company)
    }

    @Transactional
    override fun remove(company: Company) {
        entityManager.remove(company)
    }
}