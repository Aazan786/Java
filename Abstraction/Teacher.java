

public class Course {
    private String courseName; // Descriptive and follows naming conventions
    private String courseCode; // Descriptive and follows naming conventions
    private int creditHours; // Descriptive and follows naming conventions

    public Course(String courseName, String courseCode, int creditHours) {
        this.courseName = courseName; // Properly initialized
        this.courseCode = courseCode; // Properly initialized
        this.creditHours = creditHours; // Properly initialized
    }


    public void setcourseName(int courseName) {
        this.courseName = courseName; // VC4: Properly initialized, FD4: Should validate non-negative
    }

    public int getcourseName() {
        return courseName; // VC3: Correctly typed and used
    }

    public void setcourseCod(int courseCod) {
        this.courseCod = courseCod; // VC4: Properly initialized, FD4: Should validate non-negative
    }

    public int getcourseCod() {
        return courseCod; // VC3: Correctly typed and used
    }

    public void updateCreditHours(int newCreditHours) {
        if (newCreditHours > 0) { // Checks parameter value before use
            creditHours = newCreditHours;
        }
    }

}

   


   



