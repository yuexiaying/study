package com.example.service;

import com.example.entity.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;


@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class BookServiceTest {

    @Resource
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void BookControllerTest() throws Exception {
        String title = "abc";
        bookServiceMockBean(title);
        String expect = "{\"title\":\"abc\",\"price\":11}";
        mockMvc.perform(MockMvcRequestBuilders.get("/getBook").param("title",title).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(expect))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void postBookControllerTest() throws Exception {
        Book book = Book.builder().title("abc").price(11).build();
        mockMvc.perform(MockMvcRequestBuilders.post("/getBook").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)))
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(book)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getBookByTitleTest(){
        String title = "abc";
        bookServiceMockBean(title);
        Book abc = bookService.getBookByTitle(title);
        Assertions.assertEquals(Book.builder().title("abc").price(11).build(),abc);
    }

    private void bookServiceMockBean(String title){
        Mockito.when(bookService.getBookByTitle(title)).thenReturn(Book.builder().title(title).price(11).build());
    }

    @Test
    public void test() throws JsonProcessingException {
        String abc = objectMapper.writeValueAsString(Book.builder().title("abc").price(11).build());
        log.info(abc);
    }
}
