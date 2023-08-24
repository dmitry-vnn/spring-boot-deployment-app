package dmitry.companies

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*


@SpringBootTest(
	webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc
class CompanyControllerTests(
	@Autowired val restTemplate: TestRestTemplate,
	@Autowired val mockMvc: MockMvc,
	@LocalServerPort val port: Int,
	@Value("\${application.api-key}") val apiKey: String
) {

	@Test
	fun `empty authorize token test`() {
		restTemplate
			.getForEntity("http://localhost:$port/companies", Nothing::class.java)
			.statusCode.isSameCodeAs(HttpStatus.UNAUTHORIZED)
	}

	@Test
	fun `bad authorize token test`() {

		mockMvc.perform(
			get("/companies")
				.header("X-API-Key", "123sdfg24t")
		).andExpect(status().isForbidden)
	}

	@Test
	fun `token is correct test with return result`() {
		mockMvc.perform(
			get("/companies")
				.header("X-API-Key", apiKey)
		).andReturn().also {
			Assertions.assertEquals(it.response.status, HttpStatus.OK.value())
		}
	}

	@Test
	fun `token is correct test with expect`() {
		mockMvc.perform(
			get("/companies")
				.header("X-API-Key", apiKey)
		).andExpect(status().isOk).andExpect(content().string("[]"))
	}


}
