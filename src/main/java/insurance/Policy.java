package insurance;


public class Policy {
    private int policyId;
    private String policyHolderName;
    private double policyAmount;

    public Policy(int policyId, String policyHolderName, double policyAmount) {
        this.policyId = policyId;
        this.policyHolderName = policyHolderName;
        this.policyAmount = policyAmount;
    }

    public int getPolicyId() {
        return policyId;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public double getPolicyAmount() {
        return policyAmount;
    }
}
