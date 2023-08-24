package dmitry.companies.dto

import com.fasterxml.jackson.annotation.JsonFormat
import dmitry.companies.shared.CompanyIndustry
import java.time.LocalDate

data class CompanyDto(
    val companyName: String,

    @JsonFormat(pattern = "dd-MM-yyyy")
    val founded: LocalDate,

    val registrationAddress: String?,
    val industry: CompanyIndustry? = null,

    val founders: Set<String> = emptySet()
)
