public class ProgramExecution {

    public static void main(String[] args) {
        String fullName = "Denys Kovalyshyn";
        int age = 32;
        ProgramElements programElements = new ProgramElements();
        System.out.println(programElements.studentInfo(fullName, age));
    }
}
