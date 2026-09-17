class Student {
    String name;
    int id;
    String department;

    Student(String name, int id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    void display() {
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + id);
        System.out.println("Department: " + department);
    }
}

class Course {
    String courseName;
    int courseId;

    Course(String courseName, int courseId) {
        this.courseName = courseName;
        this.courseId = courseId;
    }

    void display() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Course ID: " + courseId);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Puspita", 101, "Computer Science");
        Course c = new Course("Java Programming", 201);

        s.display();
        System.out.println();
        c.display();
    }
}