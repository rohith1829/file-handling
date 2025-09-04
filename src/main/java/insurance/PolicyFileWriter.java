package insurance;

import java.io.*;

public class PolicyFileWriter implements FileWriterService {

    @Override
    public void writeSummary(String fileName, int totalPolicies, double totalAmount) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write("Total Number of Policies: " + totalPolicies);
            bw.newLine();
            bw.write("Total Policy Amount: " + totalAmount);
        }
    }
}
