public class Person {

    String firstName;
    String lastName;
    String postCode;

    public Person(String first, String last, String code) {
        firstName = first;
        lastName = last;
        postCode = code;
    }

    public void displayPerson() {
        System.out.println(firstName + " " + lastName + " - " + postCode);
    }
}