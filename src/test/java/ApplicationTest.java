import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTest {
    @Autowired
    private MockMvc mockMvc;

/*
    @Test
    void testPostAndDelete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api?post_input_text=userPostedString")).andReturn();
        mockMvc.perform(MockMvcRequestBuilders.post("/delete?post_text=userPostedString"));
        mockMvc.perform(MockMvcRequestBuilders.get("/history").contentType(MediaType.ALL))
                .andExpect(content().string(not(containsString("userPostedString"))));

    }
*/
    @Test
    void testCapsSensitivity() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api?post_input_text=BIGLETTERS")).andReturn();
        mockMvc.perform(MockMvcRequestBuilders.post("/delete?post_text=bigletters"));
        mockMvc.perform(MockMvcRequestBuilders.get("/history").contentType(MediaType.ALL))
                .andExpect(content().string(containsString("BIGLETTERS")));

    }

}