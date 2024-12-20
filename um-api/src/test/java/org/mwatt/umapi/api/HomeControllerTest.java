package org.mwatt.umapi.api;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HomeController.class)
public class HomeControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @Disabled
        // until authentication
    void testRedirectionToLoginPage() {
        // Perform a request to the "/" endpoint
        webTestClient.get().uri("/")
                .exchange()
                .expectStatus().is3xxRedirection()
                .expectHeader()
                .valueMatches("Location", "http://localhost/login");
    }
}
