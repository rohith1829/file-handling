package insurance;

public class InsuranceApp {
    public static void main(String[] args) {
        FileReaderService reader = new PolicyFileReader();
        FileWriterService writer = new PolicyFileWriter();

        PolicyManager manager = new PolicyManager(reader, writer);
        manager.processPolicies("C:\\Users\\Rohith Kumar\\bridgelabz\\InsurancePolicyDataManagement\\src\\main\\java\\insurance\\policies.txt", "C:\\Users\\Rohith Kumar\\bridgelabz\\InsurancePolicyDataManagement\\src\\main\\java\\insurance\\summary.txt");
    }
}
