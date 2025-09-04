package insurance;

import java.io.IOException;

public interface FileWriterService {
    void writeSummary(String fileName, int totalPolicies, double totalAmount) throws IOException;
}
