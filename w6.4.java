// Tagging interface
interface Confidential {
}

// Document class
class Document {
    String title;

    Document(String title) {
        this.title = title;
    }

    void display() {
        System.out.println("Document: " + title);
    }
}

// Confidential document
class SalaryReport extends Document implements Confidential {

    SalaryReport(String title) {
        super(title);
    }
}

// Non-confidential document
class PublicNotice extends Document {

    PublicNotice(String title) {
        super(title);
    }
}

// Main class
public class DocumentManagement {
    public static void main(String[] args) {

        Document doc1 = new SalaryReport("Employee Salary Report");
        Document doc2 = new PublicNotice("Public Holiday Notice");

        // Checking whether documents are confidential
        doc1.display();

        if (doc1 instanceof Confidential) {
            System.out.println("This document is Confidential.");
        } else {
            System.out.println("This document is not Confidential.");
        }

        System.out.println();

        doc2.display();

        if (doc2 instanceof Confidential) {
            System.out.println("This document is Confidential.");
        } else {
            System.out.println("This document is not Confidential.");
        }
    }
}