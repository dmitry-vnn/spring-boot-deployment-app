package dmitry.companies.entity

import dmitry.companies.shared.CompanyIndustry
import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Company(

    name: String,

    @Column
    var foundDate: LocalDate,

    @Column
    var registrationAddress: String? = null,

    @Enumerated(value = EnumType.STRING)
    var industry: CompanyIndustry? = null,

    founders: Set<String> = mutableSetOf()
) {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Int? = null
        private set

    @Column(unique = true, nullable = false)
    var name: String = name
        private set

    @ElementCollection(fetch = FetchType.LAZY)
    var founders: Set<String> = mutableSetOf()
        private set

    init {
        this.founders = HashSet(founders)
    }



}