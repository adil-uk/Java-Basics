// **************************************************
//   StringPlay.java
//
//   Play with String objects
// **************************************************
public class StringPlay
{
    public static void main (String[] args)
    {
        String college = new String ("Leeds Beckett University"); //Similar for part (a)

        // part (a)

        String town = new String("Anytown, UK");
        int stringLength;
        String change1, change2, change3;

        // part (b)

        stringLength = college.length();
        System.out.println (college + " contains " + stringLength + " characters.");


        change1 = college.toUpperCase(); // part (c)
        change2 = change1.replace('e', '*'); // part (d)
        change3 = college.concat(" ").concat(town); // part (e)


        System.out.println ("The final string is " + change3);
    }
}