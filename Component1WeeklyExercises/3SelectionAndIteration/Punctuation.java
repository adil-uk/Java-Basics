public class Punctuation {

    public static void main(String[] args) {

        String text = "Mary had a little lamb, her fleece was as white as snow, "
                + "and everywhere Mary went, the lamb was sure to go. "
                + "-that was a nice poem- the end! Did you like it?";

        int commaCount = 0;
        int fullstopCount = 0;
        int dashCount = 0;
        int exclamationCount = 0;
        int questionCount = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            switch (ch) {
                case ',':
                    commaCount = commaCount + 1;
                    break;
                case '.':
                    fullstopCount = fullstopCount + 1;
                    break;
                case '-':
                    dashCount = dashCount + 1;
                    break;
                case '!':
                    exclamationCount = exclamationCount + 1;
                    break;
                case '?':
                    questionCount = questionCount + 1;
                    break;
            }
        }

        System.out.println("Comma:" + commaCount);
        System.out.println("Full Stop:" + fullstopCount);
        System.out.println("Hyphen:" + dashCount);
        System.out.println("Exclamation:" + exclamationCount);
        System.out.println("Question:" + questionCount);
    }
}
