package francescocristiano.U5_W2_D3.entities;

import francescocristiano.U5_W2_D3.enums.Category;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@Entity
public class BlogPost {
    @Id
    @GeneratedValue
    private UUID id;
    private Category category;
    private String title;
    private String cover;
    private String body;
    private int readingTime;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public BlogPost(String categoryString, String title, String body, int readingTime, Author author) {
        this.category = this.categoryFromString(categoryString);
        this.title = title;
        this.cover = "https://picsum.photos/200/300";
        this.body = body;
        this.readingTime = readingTime;
        this.author = author;
    }

    public Category categoryFromString(String categoryString) {
        if (categoryString == null) {
            throw new IllegalArgumentException("categoryString cannot be null");
        }
        try {
            return Category.valueOf(categoryString.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("categoryString must be one of: NEWS, TECH, SCIENCE, ENTERTAINMENT, SPORT, LIFESTYLE, TRAVEL, FASHION");
        }
    }
}
