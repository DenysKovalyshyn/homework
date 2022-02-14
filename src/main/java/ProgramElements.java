public class ProgramElements {

    public String studentInfo(String fullName, int age) {
        String studentInfo = "The new student of the course \"QA Automation\" is %s. He is %d years old";
        return String.format(studentInfo, fullName, age);
    }
}
