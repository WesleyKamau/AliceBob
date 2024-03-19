import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Wesley Kamau
 *
 */
public final class ProgramWithIOAndStaticMethod {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private ProgramWithIOAndStaticMethod() {
    }

    private static String generateString() {
        String s = "";
        for (int i = 0; i <= 1000; i++) {
            if (Math.random() < .5) {
                s = s.concat("H");
            } else {
                s = s.concat("T");
            }
        }
        return s;
    }

    private static int alicePoints(String s) {
        int total = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            String sub = s.substring(i, i + 2);
            if (sub.equals("HH")) {
                total++;
            }
        }
        return total;
    }

    private static int bobPoints(String s) {
        int total = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.substring(i, i + 2).equals("TT")) {
                total++;
            }
        }
        return total;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        int bobTotal = 0;
        int aliceTotal = 0;
        for (int i = 0; i < 10000; i++) {
            String seq = generateString();
            out.println(seq);

            out.println("Alice: " + alicePoints(seq));
            out.println("Bob: " + bobPoints(seq));

            if (alicePoints(seq) > bobPoints(seq)) {
                aliceTotal++;
            } else if (bobPoints(seq) > alicePoints(seq)) {
                bobTotal++;
            }
        }

        out.println("ALICE HAS WON " + aliceTotal);
        out.println("BOB HAS WON " + bobTotal);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
