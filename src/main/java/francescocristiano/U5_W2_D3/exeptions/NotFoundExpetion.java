package francescocristiano.U5_W2_D3.exeptions;

import java.util.UUID;

public class NotFoundExpetion extends RuntimeException {

    public NotFoundExpetion(UUID blogPostId) {
        super("BlogPost with id " + blogPostId + " not found");
    }
}
