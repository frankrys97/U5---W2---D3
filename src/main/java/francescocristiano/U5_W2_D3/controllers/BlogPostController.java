package francescocristiano.U5_W2_D3.controllers;


import francescocristiano.U5_W2_D3.entities.BlogPost;
import francescocristiano.U5_W2_D3.entities.BlogPostPayload;
import francescocristiano.U5_W2_D3.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/blogposts")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;


    @GetMapping
    private List<BlogPost> getAllBlogPosts() {
        return blogPostService.getAllBlogPosts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private BlogPostPayload saveBlogPost(@RequestBody BlogPostPayload blogPostPayload) {
        return blogPostService.saveBlogPost(blogPostPayload);
    }

    @GetMapping("/{id}")
    private BlogPost findBlogPostById(@PathVariable UUID id) {
        return blogPostService.findBlogPostById(id);
    }

    @PutMapping("/{id}")
    private BlogPost findBlogPostByIdAndUpdate(@PathVariable UUID id, @RequestBody BlogPost blogPostUpdated) {
        return blogPostService.findBlogPostByIdAndUpdate(id, blogPostUpdated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteBlogPostById(@PathVariable UUID id) {
        blogPostService.deleteBlogPostById(id);
    }
}
