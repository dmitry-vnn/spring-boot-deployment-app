package dmitry.companies

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootDeploymentAppApplication

fun main(args: Array<String>) {
//
//	val request = CreateCompanyRequestDto(
//		"Microsoft",
//		"USA, California",
//		LocalDate.of(1975, Month.MAY, 13),
//		"IT",
//		emptyList()
//	)

	runApplication<SpringBootDeploymentAppApplication>(*args)
}
