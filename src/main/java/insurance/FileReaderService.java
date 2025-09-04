package insurance;

import java.io.IOException;
import java.util.List;

public interface FileReaderService {
    List<Policy> readPolicies(String fileName) throws IOException;
}
