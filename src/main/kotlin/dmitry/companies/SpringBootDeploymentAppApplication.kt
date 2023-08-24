package dmitry.companies

import dmitry.companies.entity.Company
import dmitry.companies.shared.CompanyIndustry
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@SpringBootApplication
class SpringBootDeploymentAppApplication

private fun String.toDate() =
	LocalDate.parse(this, DateTimeFormatter.ofPattern("dd.MM.yyyy"))

fun main(args: Array<String>) {
	runApplication<SpringBootDeploymentAppApplication>(*args)
}
