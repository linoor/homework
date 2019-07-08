package homework;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OptimizerIntegrationTest {

    @LocalServerPort
    private int port;

    private URL base;
    private URL optimizer;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
        this.optimizer = new URL("http://localhost:" + port + "/optimizer");
    }

    @Test
    public void getHello() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString(),
                String.class);
        assertThat(response.getBody(), equalTo("Greetings from cleaners Optimizer!"));
    }

    @Test
    public void getOptimization() throws URISyntaxException {
        RequestEntity<Input> requestEntity = RequestEntity
                .post(optimizer.toURI())
                .accept(MediaType.APPLICATION_JSON)
                .body(new Input(new int[] {35, 21, 17}, 10, 6));
        ResponseEntity<String> response = template.exchange(requestEntity, String.class);
        assertThat(response.getBody(), equalTo("[{\"senior\":3,\"junior\":1},{\"senior\":1,\"junior\":2},{\"senior\":2,\"junior\":0}]"));
    }
}
