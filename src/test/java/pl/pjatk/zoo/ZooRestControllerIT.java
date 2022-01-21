package pl.pjatk.zoo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ZooRestControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnSuccess_exampleZoo() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/zoo/example");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"name\":\"Zoo\",\"location\":\"Gdansk\",\"animal\":[{\"id\":1,\"specimen\":\"lion\",\"diet\":\"MEAT\",\"type\":\"LAND\",\"health\":100,\"hungry\":true}],\"closed\":false}"));
    }

    @Test
    void shouldReturnSuccess_namedZoo() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/zoo/empty_name").param("name","test");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"name\":\"test\",\"location\":\"Gdansk\",\"animal\":null,\"closed\":false}"));
    }

    @Test
    void shouldReturnSuccess_emptyZoo() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/zoo/empty");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

    @Test
    void shouldReturnSuccess_fullZoo() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/zoo/all");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

//    @Test
//    void shouldReturnSuccess_zooById() throws Exception {
//        MockHttpServletRequestBuilder getRequestBuilder = get("/zoo/id/{id}", "id");
//        mockMvc.perform(getRequestBuilder)
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string("[]"));
//    }
}
