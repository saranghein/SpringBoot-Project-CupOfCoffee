//package me.shinsunyoung.springbootdeveloper.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import me.shinsunyoung.springbootdeveloper.domain.Post;
//import me.shinsunyoung.springbootdeveloper.dto.Post.AddPostRequest;
//import me.shinsunyoung.springbootdeveloper.dto.Post.UpdatePostRequest;
//import me.shinsunyoung.springbootdeveloper.repository.PostRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class articleControllerTest {
//
//    @Autowired
//    protected MockMvc mockMvc;
//
//    @Autowired
//    protected ObjectMapper objectMapper;
//
//    @Autowired
//    private WebApplicationContext context;
//
//    @Autowired
//    PostRepository blogRepository;
//
//    @BeforeEach
//    public void mockMvcSetUp() {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
//                .build();
//        blogRepository.deleteAll();
//    }
//
//    @DisplayName("addArticle: 블로그 글 추가에 성공한다.")
//    @Test
//    public void addArticle() throws Exception {
//        // given
//        final Long id=0;
//        final String url = "/posts";
//        final String content_type="content_type";
//        final String title = "title";
//        final String content = "content";
//        final int like_num=0;
//        final int dislike_num=0;
//        final String user_id="user_id";
//        final String image_id="image_id";
//        final String file_id="file_id";
//        final String user_type="user_type";
//
//        final AddPostRequest userRequest =
//                new AddPostRequest(id,content_type, title, content,like_num,dislike_num,user_id,image_id,file_id,user_type);
//
//        final String requestBody = objectMapper.writeValueAsString(userRequest);
//
//        // when
//        ResultActions result = mockMvc.perform(post(url)
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .content(requestBody));
//
//        // then
//        result.andExpect(status().isCreated());
//
//        List<Post> posts = blogRepository.findAll();
//
//        assertThat(posts.size()).isEqualTo(1);
//        assertThat(posts.get(0).getTitle()).isEqualTo(title);
//        assertThat(posts.get(0).getContent()).isEqualTo(content);
//    }
//
//    @DisplayName("findAllposts: 블로그 글 목록 조회에 성공한다.")
//    @Test
//    public void findAllposts() throws Exception {
//        // given
//        final String url = "/posts";
//        final String title = "title";
//        final String content = "content";
//
//        blogRepository.save(Post.builder()
//                .title(title)
//                .content(content)
//                .build());
//
//        // when
//        final ResultActions resultActions = mockMvc.perform(get(url)
//                .accept(MediaType.APPLICATION_JSON));
//
//        // then
//        resultActions
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].content").value(content))
//                .andExpect(jsonPath("$[0].title").value(title));
//    }
//
//    @DisplayName("findArticle: 블로그 글 조회에 성공한다.")
//    @Test
//    public void findArticle() throws Exception {
//        // given
//        final String url = "/posts/{id}";
//        final String title = "title";
//        final String content = "content";
//
//        Post savedArticle = blogRepository.save(Post.builder()
//                .title(title)
//                .content(content)
//                .build());
//
//        // when
//        final ResultActions resultActions = mockMvc.perform(get(url, savedArticle.getId()));
//
//        // then
//        resultActions
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.content").value(content))
//                .andExpect(jsonPath("$.title").value(title));
//    }
//
//
//    @DisplayName("deleteArticle: 블로그 글 삭제에 성공한다.")
//    @Test
//    public void deleteArticle() throws Exception {
//        // given
//        final String url = "/posts/{id}";
//        final String title = "title";
//        final String content = "content";
//
//        Post savedArticle = blogRepository.save(Post.builder()
//                .title(title)
//                .content(content)
//                .build());
//
//        // when
//        mockMvc.perform(delete(url, savedArticle.getId()))
//                .andExpect(status().isOk());
//
//        // then
//        List<Post> posts = blogRepository.findAll();
//
//        assertThat(posts).isEmpty();
//    }
//
//
//    @DisplayName("updateArticle: 블로그 글 수정에 성공한다.")
//    @Test
//    public void updateArticle() throws Exception {
//        // given
//        final String url = "/posts/{id}";
//        final String title = "title";
//        final String content = "content";
//
//        Post savedArticle = blogRepository.save(Post.builder()
//                .title(title)
//                .content(content)
//                .build());
//
//        final String newContent_type="new";
//        final String newTitle = "new title";
//        final String newContent = "new content";
//        final int newLike_num=0;
//        final int newDislike_num=0;
//        final String newUser_id="new";
//        final String newImage_id="new";
//        final String newFile_id="new";
//        final String newUser_type="new";
//
//
//        UpdatePostRequest request = new UpdatePostRequest(
//                newContent_type,newTitle, newContent,newLike_num,newDislike_num,newUser_id,newImage_id,newFile_id,newUser_type);
//
//        // when
//        ResultActions result = mockMvc.perform(put(url, savedArticle.getId())
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .content(objectMapper.writeValueAsString(request)));
//
//        // then
//        result.andExpect(status().isOk());
//
//        Post article = blogRepository.findById(savedArticle.getId()).get();
//
//        assertThat(article.getTitle()).isEqualTo(newTitle);
//        assertThat(article.getContent()).isEqualTo(newContent);
//    }
//
//}
//
//
