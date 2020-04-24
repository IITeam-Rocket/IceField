import java.io.IOException;
import java.io.InputStream;

public class hackIStream extends InputStream {

    @Override
    public int read() throws IOException {
        return 0;
    }
}
