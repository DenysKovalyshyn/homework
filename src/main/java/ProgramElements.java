public class ProgramElements {

    public String studentInfo() {
        String fullName = "Denys Kovalyshyn";
        String studentInfo = "The new student of the course \"QA Automation\" is %s";
        return String.format(studentInfo, fullName);
    }
}
