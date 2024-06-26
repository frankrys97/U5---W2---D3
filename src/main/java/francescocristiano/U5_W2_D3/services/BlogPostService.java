package francescocristiano.U5_W2_D3.services;


import francescocristiano.U5_W2_D3.entities.BlogPost;
import francescocristiano.U5_W2_D3.entities.BlogPostPayload;
import francescocristiano.U5_W2_D3.exeptions.NotFoundException;
import francescocristiano.U5_W2_D3.repositories.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private AuthorService authorService;


    public BlogPostPayload saveBlogPost(BlogPostPayload blogPostPayload) {

        BlogPost blogpost1 = new BlogPost(blogPostPayload.getCategory(), blogPostPayload.getTitle(), blogPostPayload.getBody(), blogPostPayload.getReadingTime(), authorService.findAuthorById(blogPostPayload.getAuthorId()));

        blogPostRepository.save(blogpost1);
        return blogPostPayload;
    }


    public Page<BlogPost> getAllBlogPosts(int pageNumber, int pageSize, String sortBy) {
        if (pageSize > 100) pageSize = 100;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        return blogPostRepository.findAll(pageable);
    }

    /*public List<BlogPost> getAllBlogPosts() {
        return this.blogPostRepository.findAll();
    }*/


    public BlogPost findBlogPostById(UUID id) {
        return this.blogPostRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public BlogPost findBlogPostByIdAndUpdate(UUID id, BlogPost blogPostUpdated) {
        BlogPost found = null;
        found = this.findBlogPostById(id);
        found.setTitle(blogPostUpdated.getTitle());
        found.setBody(blogPostUpdated.getBody());
        found.setReadingTime(blogPostUpdated.getReadingTime());
        found.setCategory(blogPostUpdated.getCategory());
        found.setCover(blogPostUpdated.getCover());
        return this.blogPostRepository.save(found);
    }

    public void deleteBlogPostById(UUID id) {
        this.blogPostRepository.deleteById(id);
    }

  /*  public BlogPost findBlogPostById(int id) {
        return blogPosts.stream().filter(blogPost -> blogPost.getId() == id).findFirst().orElseThrow(() -> new NotFoundExpetion(id));
    }*/

/*    public BlogPost findBlogPostByIdAndUpdate(int id, BlogPost blogPostUpdated) {
        BlogPost found = null;
        found = this.findBlogPostById(id);
        found.setTitle(blogPostUpdated.getTitle());
        found.setBody(blogPostUpdated.getBody());
        found.setReadingTime(blogPostUpdated.getReadingTime());
        found.setCategory(blogPostUpdated.getCategory());
        found.setCover(blogPostUpdated.getCover());
        return found;
    }*/

 /*   public void deleteBlogPostById(int id) {
        Iterator<BlogPost> iterator = blogPosts.iterator();
        while (iterator.hasNext()) {
            BlogPost currentBlogPost = iterator.next();
            if (currentBlogPost.getId() == id) {
                iterator.remove();
            }
        }
    }*/


}
