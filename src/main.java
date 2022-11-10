/**
 * Team 1
 * Ezekiel Ramirez
 *
 * pie 3.14159265359
 * phi 1.61803398875
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

        System.out.println(longitude(20));
    }

    /**
     * TODO this method needs work!
     *
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
        double pie = Math.PI;

        if (i <= 0 ) {
            return Math.asin((2.0 * i) / (2 * n + 1));
        } else {
            return (pie - Math.asin((2.0 * i) / (2 * n + 1)));
        }
    }

    /**
     * THIS METHOD WORKS
     *
     * phi is considered a golden ratio and appears naturally
     * in the world
     */
    public static double longitude(int i) {
        double pie = Math.PI;
        double phi = 1.61803398875;

        return ((2 * pie * i)/phi);
    }

    /**
     * TODO this method needs work
     * this method will have an issue with the array size changing fix before
     * working on next method
     */
    public static double[] genX(int n, double r) {
        double[] a = new double[]{};
        int i = -n;

        while (i <= n){
            a[i] += (-r + Math.cos(latitude(i,n)) * Math.cos(longitude(i)));
            i += 1;
        }

        return a;
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
