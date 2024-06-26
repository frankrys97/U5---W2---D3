package francescocristiano.U5_W2_D3.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class BlogPostPayload {
    private String category;
    private String title;
    private String cover;
    private String body;
    private int readingTime;
    private UUID authorId;
}
