package dmitry.companies.dto

import java.time.LocalDate

data class CompanyDto(
    val companyName: String,
    val registrationLocation: String,
    val founded: LocalDate,
    val industry: String,

    val founders: List<String>
)
