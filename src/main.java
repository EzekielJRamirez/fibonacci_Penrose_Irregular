import java.util.Vector;

/**
 * Team 1
 * Ezekiel Ramirez
 * Marcus McClatchy
 * <p>
 * pie 3.14159265359
 * phi 1.61803398875
 */

public class main {
    public static void main(String[] args){

        Vector<Vector<Double>> circle = genCord(20, 5);

        int radius = 5;
        int genSize = 0;
        boolean findDist;
        // Determines if the circle is regular or not
        while(genSize < circle.size()){

            // Creates a new set of cords off of the set point in
            // the genSize cord
            Vector<Vector<Double>> valueCord = distanceCord(circle, genSize);

            // Uses the euclidean distance formula to determine the distance
            // to the genSize cord
            Vector<Double> ecu = euc_Dist(valueCord);

            // Finds the points that are close to the genSize cord
            Vector<Double> minPoints = miniValues(ecu, genSize);

            // Trig Points of a triangle on the overall circle
            Vector<Vector<Double>> trigPoints = getTrigPoints(minPoints, circle, genSize);
            System.out.println("Trig Points:");
            System.out.println(trigPoints);
            System.out.println();

            // Center Point of the three points of a triangle
            Vector<Double> centPoint = getCenterPoints(trigPoints);
            System.out.println("Center Point");
            System.out.println(centPoint);
            System.out.println();

            // Find if the distance to the three points
            // of the triangle to the center point that fits
            // the radius of the center point of the circle.
            findDist = distanceToCenter(trigPoints, centPoint, radius);
            System.out.println("Determine if the ball fits through the Trig Points:");
            System.out.println(findDist);
            System.out.println();

            // If the circle fits through the three points then show the distance of
            // the circle to the Trig Points
            if(findDist){
                System.out.println("The circle can fit through these three points:");
                System.out.println(trigPoints);
                System.out.println("---------------------");
                System.out.println("With the center point of the circle being:");
                System.out.println(centPoint);
                System.out.println("---------------------");
            }
            System.out.println("-------------------------------");

            genSize++;
        }

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

    public static Vector<Vector<Double>> genCord(int n, double r) {
        int size = (2 * n) + 1;
        Vector<Vector<Double>> a = new Vector<>();
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

    public static Vector<Vector<Double>> distanceCord(Vector<Vector<Double>> cord, int value){

        Vector<Vector<Double>> tempCord = new Vector<>();
        Vector<Double> genTempX = genValue(cord, value, 0);
        Vector<Double> genTempY = genValue(cord, value, 1);
        Vector<Double> genTempZ = genValue(cord, value, 2);
        for(int i = 0; i < cord.size(); i++){
            Vector<Double> tempXYZ = new Vector<>();
            tempXYZ.add(genTempX.get(i));
            tempXYZ.add(genTempY.get(i));
            tempXYZ.add(genTempZ.get(i));
            tempCord.addElement(tempXYZ);

        }
        return tempCord;
    }

    public static Vector<Double> genValue(Vector<Vector<Double>> cord, int value, int i){
        Vector<Double> genTemp = new Vector<>();
        for(int j = 0; j < cord.size(); j++){
            double temp = cord.get(value).get(i) - cord.get(j).get(i);
            temp = Math.pow(temp, 2);
            genTemp.add(temp);
        }
        return genTemp;
    }

    public static Vector<Double> euc_Dist(Vector<Vector<Double>> valueCord){
        Vector<Double> tempVect = new Vector<>();
        for (int i = 0; i < valueCord.size(); i++) {
            double value = 0;
            for (int j = 0; j < valueCord.get(0).size(); j++) {
                value = value + valueCord.get(i).get(j);
            }
            value = Math.sqrt(value);
            tempVect.add(value);

        }
        return tempVect;
    }

    public static Vector<Double> miniValues(Vector<Double> ecu, int value){
        Vector<Double> minV = new Vector<>();
        double temp;
        if(value >= ecu.size() - 1){
            temp = ecu.get(value - 1);
        } else {
            temp = ecu.get(value + 1);
        }

        double temp2 = temp;
        int getMin1 = 0;
        for(int i = 0; i < ecu.size(); i++){
            if(i != value){
                if(ecu.get(i) < temp){
                    temp = ecu.get(i);
                    getMin1 = i;
                }
            }
        }

        int getMin2 = 0;
        for(int i = 0; i < ecu.size(); i++){
            if(i != value && i != getMin1){
                if(ecu.get(i) < temp2){
                    temp2 = ecu.get(i);
                    getMin2 = i;
                }
            }
        }

        minV.add((double)getMin1);
        minV.add((double) getMin2);

        return minV;
    }

    public static Vector<Vector<Double>> getTrigPoints(Vector<Double> minPoints,
                                               Vector<Vector<Double>> circle, int valuePoint){
        Vector<Vector<Double>> trigPoints = new Vector<>();
        trigPoints.add(circle.get(valuePoint));
        for(int i = 0; i < circle.size(); i++){
            for(int j = 0; j < minPoints.size(); j++){
                if(i == minPoints.get(j)){
                    trigPoints.add(circle.get(i));

                }
            }
        }
        return trigPoints;
    }

    public static Vector<Double> getCenterPoints(Vector<Vector<Double>> trigPoints){
        Vector<Double> centPoint = new Vector<>();
        Vector<Double> maxVect = new Vector<>();
        Vector<Double> minVect = new Vector<>();
        for(int i = 0; i < trigPoints.get(0).size(); i++){
            double maxValue = trigPoints.get(0).get(i);
            double minValue = trigPoints.get(0).get(i);
            for(int j = 0; j < trigPoints.size(); j++){
                if(maxValue < trigPoints.get(j).get(i)){
                    maxValue = trigPoints.get(j).get(i);
                }
                if(minValue > trigPoints.get(j).get(i)){
                    minValue = trigPoints.get(j).get(i);
                }
            }
            maxVect.add(maxValue);
            minVect.add(minValue);
        }

        for(int i = 0; i < trigPoints.get(0).size(); i++){
            centPoint.add((maxVect.get(i) + minVect.get(i))/2);
        }

        return centPoint;
    }

    public static boolean distanceToCenter(Vector<Vector<Double>> trigPoints,
                                           Vector<Double> centPoint, int radius){
        boolean findDist = true;
        Vector<Double> distanceCent = new Vector<>();
        for(int i = 0; i < trigPoints.size(); i++){
            Vector<Double> temp = new Vector<>();
            double distLength = 0;
            for(int j = 0; j < trigPoints.get(0).size(); j++){
                temp.add(trigPoints.get(i).get(j));
                distLength = distLength + Math.pow(temp.get(j) - centPoint.get(j), 2);
            }
            distLength = Math.sqrt(distLength);
            distanceCent.add(distLength);
        }

        for(int i = 0; i < distanceCent.size(); i++){
            if(distanceCent.get(i) < radius){
                findDist = false;
            }
        }

        return findDist;
    }
}
