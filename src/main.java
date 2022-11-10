/**
 * Team 1
 * Ezekiel Ramirez
 */

public class main {
    public static void main(String[] args) {
        //start adding psuedo code

//        double lat = latitude(2, 5);

//        System.out.println(lat);

        double frac = (2 * 2.0) / (2 * 5.0 + 1);
        System.out.println(frac);
        double fracSine = Math.asin(frac);
        System.out.println(fracSine);

//        double pie = Math.PI - 1;
//        System.out.println(pie);
    }

    /**
     * Math.PI stores the constant up to the 15th decimal place
     * Math.PI is a final variable that doesn't update, so
     * we will emulate it.
     *
     * there is an issue with how math.asin calculates my fraction
     * it may be due to the vars i and n being integers
     *
     * to get Math.asin() to work I may need to convert some of these values
     * radians and maybe convert them back
     */
    public static double latitude(int i, int n) {
        System.out.println(Math.PI);
        double pie = 3.141592653589793;

        double ret = pie - Math.asin((2.0 * i) / (2.0 * n + 1));
        double ret2 = pie - 1;
        System.out.println(Math.asin(((2.0 * i) / (2.0 * n + 1))));

        if (i <= 0 ) {
            return Math.asin((2.0 * i) / (2 * n + 1));
        } else {
            return (pie - Math.asin((2.0 * i) / (2 * n + 1)));
        }
    }

    /**
     *
     */
    public static void longitude(int i) {
        double pie = Math.PI;
        double some = Math.
    }

    /**
     *
     */
    public static void genX() {
    }

    /**
     *
     */
    public static void genY() {
    }

    /**
     *
     */
    public static void genZ() {
    }

    /**
     *
     */
    public static void genCoord() {
    }
}
