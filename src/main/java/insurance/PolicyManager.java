package insurance;

import java.io.IOException;
import java.util.List;

public class PolicyManager {
    private final FileReaderService fileReaderService;
    private final FileWriterService fileWriterService;

    public PolicyManager(FileReaderService fileReaderService, FileWriterService fileWriterService) {
        this.fileReaderService = fileReaderService;
        this.fileWriterService = fileWriterService;
    }

    public void processPolicies(String inputFile, String outputFile) {
        try {
            List<Policy> policies = fileReaderService.readPolicies(inputFile);

            int totalPolicies = policies.size();
            double totalAmount = policies.stream()
                                         .mapToDouble(Policy::getPolicyAmount)
                                         .sum();

            fileWriterService.writeSummary(outputFile, totalPolicies, totalAmount);

            System.out.println("Processing completed. Summary written to " + outputFile);

        } catch (IOException e) {
            System.err.println("Error processing policies: " + e.getMessage());
        }
    }
}
