import java.util.Vector;

/**
 * Team 1
 * Ezekiel Ramirez
 * <p>
 * pie 3.14159265359
 * phi 1.61803398875
 */

public class main {
    public static void main(String[] args) {
//        double lat = latitude(2, 5);

        // arcsine assumes radian values are input into its formula
        System.out.println(latitude(4, 5));
        // these given values should give a value of 0.814
//        System.out.println(Math.asin((2.0 * 4) / (2 * 5 + 1)));
        System.out.println(genCoord(20, 5));

    }

    /**
     * Math.asin() assumes radian values from its inputs
     * <p>
     * Math.PI stores the constant up to the 15th decimal place
     * Math.PI is a final variable that doesn't update, so
     * we will emulate it.
     * <p>
     * there is an issue with how math.asin calculates my fraction
     * it may be due to the vars i and n being integers
     */
    public static double latitude(int i, int n) {
        double pie = Math.PI;

        if (i <= 0) {
            return Math.asin((2.0 * i) / (2 * n + 1));
        } else {
            return (pie - Math.asin((2.0 * i) / (2 * n + 1)));
        }
    }

    /**
     * THIS METHOD WORKS
     * <p>
     * phi is considered a golden ratio and appears naturally
     * in the world
     */
    public static double longitude(int i) {
        double pie = Math.PI;
        double phi = 1.61803398875;

        return ((2 * pie * i) / phi);
    }

    /**
     * TODO this method needs work
     * this method will have an issue with the array size changing fix before
     * working on next method
     */
    public static Vector<Double> genX(int n, double r) {
//        double[] a = new double[(n * 2) + 1];
        int size = (2 * n) + 1;
        Vector<Double> a = new Vector<>(size);
        int i = -n;

        while (i <= n) {
            a.add((-r + Math.cos(latitude(i, n)) * Math.cos(longitude(i))));
            i += 1;
        }

        return a;
    }

    /**
     *
     */
    public static Vector<Double> genY(int n, double r) {
        //        double[] a = new double[(n * 2) + 1];
        int size = (2 * n) + 1;
        Vector<Double> a = new Vector<>(size);
        int i = -n;

        while (i <= n) {
            a.add((r + Math.sin(latitude(i, n))));
            i += 1;
        }

        return a;
    }

    /**
     *
     */
    public static Vector<Double> genZ(int n, double r) {
        //        double[] a = new double[(n * 2) + 1];
        int size = (2 * n) + 1;
        Vector<Double> a = new Vector<>(size);
        int i = -n;

        while (i <= n) {
            a.add((r + Math.cos(latitude(i, n)) * Math.sin(longitude(i))));
            i += 1;
        }

        return a;
    }

    /**
     *
     */
    public static Vector<Vector<Double>> genCoord(int n, double r) {
        int size = (2 * n) + 1;
        Vector<Vector<Double>> a = new Vector<Vector<Double>>(size, size);
        Vector<Double> x = genX(n, r);
        Vector<Double> y = genY(n, r);
        Vector<Double> z = genZ(n, r);
        int i = 0;
        while(i < x.size()){
            Vector<Double> b = new Vector<>(size);
            if(i == 41){
                System.out.println();
            }
            b.add(x.get(i));
            b.add(y.get(i));
            b.add(z.get(i));
            a.addElement(b);
            i += 1;
        }
        return a;

    }
}
