package pc.leon;



import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        URI path = Main.class.getResource("Repositories.txt").toURI();
    }
}