// BasicSecurity interface
interface BasicSecurity {
    void login();
    void logout();
}

// AdvancedSecurity extends BasicSecurity
interface AdvancedSecurity extends BasicSecurity {
    void fingerprintAuthentication();
    void faceRecognition();
}

// BankingApplication implements AdvancedSecurity
class BankingApplication implements AdvancedSecurity {

    @Override
    public void login() {
        System.out.println("User logged in successfully.");
    }

    @Override
    public void logout() {
        System.out.println("User logged out successfully.");
    }

    @Override
    public void fingerprintAuthentication() {
        System.out.println("Fingerprint authentication successful.");
    }

    @Override
    public void faceRecognition() {
        System.out.println("Face recognition authentication successful.");
    }
}

// Main class
public class MobileBanking {
    public static void main(String[] args) {

        BankingApplication bank = new BankingApplication();

        // Basic security operations
        bank.login();
        bank.logout();

        // Advanced security operations
        bank.fingerprintAuthentication();
        bank.faceRecognition();
    }
}