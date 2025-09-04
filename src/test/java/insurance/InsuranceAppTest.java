package insurance;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class InsuranceAppTest {

    private static final String TEST_INPUT_FILE = "test_policies.txt";
    private static final String TEST_OUTPUT_FILE = "test_summary.txt";

    @BeforeEach
    void setup() throws IOException {
        
        Files.write(Paths.get(TEST_INPUT_FILE),
                Arrays.asList(
                        "101,Rajeev Shukla,5000",
                        "102,Richa Ghosh,7000",
                        "103,Allu Arjun,3000"
                ));
    }

    @AfterEach
    void cleanup() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_INPUT_FILE));
        Files.deleteIfExists(Paths.get(TEST_OUTPUT_FILE));
    }

    @Test
    void testPolicyEncapsulation() {
        Policy policy = new Policy(101, "Rajeev Shukla", 5000);

        assertEquals(101, policy.getPolicyId());
        assertEquals("Rajeev Shukla", policy.getPolicyHolderName());
        assertEquals(5000, policy.getPolicyAmount());
    }

    @Test
    void testFileReader() throws IOException {
        FileReaderService reader = new PolicyFileReader();
        List<Policy> policies = reader.readPolicies(TEST_INPUT_FILE);

        assertEquals(3, policies.size());
        assertEquals("Richa Ghosh", policies.get(1).getPolicyHolderName());
        assertEquals(3000, policies.get(2).getPolicyAmount());
    }

    @Test
    void testFileWriter() throws IOException {
        FileWriterService writer = new PolicyFileWriter();
        writer.writeSummary(TEST_OUTPUT_FILE, 3, 15000);

        List<String> lines = Files.readAllLines(Paths.get(TEST_OUTPUT_FILE));
        assertEquals("Total Number of Policies: 3", lines.get(0));
        assertEquals("Total Policy Amount: 15000.0", lines.get(1));
    }

    @Test
    void testPolicyManagerIntegration() throws IOException {
        FileReaderService reader = new PolicyFileReader();
        FileWriterService writer = new PolicyFileWriter();
        PolicyManager manager = new PolicyManager(reader, writer);

        manager.processPolicies(TEST_INPUT_FILE, TEST_OUTPUT_FILE);

        List<String> lines = Files.readAllLines(Paths.get(TEST_OUTPUT_FILE));
        assertEquals("Total Number of Policies: 3", lines.get(0));
        assertEquals("Total Policy Amount: 15000.0", lines.get(1));
    }
}
