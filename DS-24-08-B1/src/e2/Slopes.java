package e2;

public class Slopes {


    public static void testRequirements(char[][] slopeMap, int right, int down) throws IllegalArgumentException {
        int mMapSize = slopeMap.length;
        if (mMapSize > 1) {
            for (char[] mMap : slopeMap) {
                if (mMap.length != mMapSize)
                    throw new IllegalArgumentException("El mapa tiene que ser cuadrado");
            }

            for (char[] cc : slopeMap) {
                for (char c : cc) {
                    if (c != '.' && c != '#')
                        throw new IllegalArgumentException("Hay caracteres erroneos en el mapa pasado");
                }
            }

        } else
            throw new IllegalArgumentException("Tamaño del mapa ha de ser superior");

        if (right <= 0 || down <= 0 || right >= mMapSize || down >= mMapSize)
            throw new IllegalArgumentException("Asegurate de que rigth y down tengan valores correctos");


    }

    /*** Traverses the slope map making the right and down movements and
     * returns the number of trees found along the way .
     * @param slopeMap A square matrix representing the slope with spaces
     * represented as "." and trees represented as "#".
     * @param right Movement to the right
     * @param down Downward movement
     * @return Number of trees
     * @throws IllegalArgumentException if the matrix is incorrect because :
     * - It is not square .
     * - It has characters other than "." and "#"
     * - right >= number of columns or right < 1
     * - down >= number of rows of the matrix or down < 1
     */
    public static int downTheSlope(char[][] slopeMap, int right, int down) throws IllegalArgumentException {

        testRequirements(slopeMap, right, down);

        int mMapSize = slopeMap.length;
        int treesOnTheWay = 0;
        boolean sliding = true;
        int posX = 0, posY = 0;


        char c = slopeMap[posY][posX];
        if (c == '#')
            treesOnTheWay++;

        while (sliding) {
            for (int r = 0; r < right; r++) {
                posX++;
                if (posX >= mMapSize) {
                    posX = 0;
                }

                c = slopeMap[posY][posX];
                if (c == '#')
                    treesOnTheWay++;


            }
            for (int d = 0; d < down; d++) {
                posY++;
                if (posY >= mMapSize) {
                    sliding = false;
                } else {
                    c = slopeMap[posY][posX];
                    if (c == '#')
                        treesOnTheWay++;
                }


            }
        }
        return treesOnTheWay;
    }

    /**
     * Traverses the slope map making the right and down movements and
     * returns the number of trees found along the way .
     * Since it " jumps " from the initial position to the final position ,
     * only takes into account the trees on those initial / final positions .
     * <p>
     * Params , return value and thrown exceptions as in downTheSlope ...
     */
    public static int jumpTheSlope(char[][] slopeMap, int right, int down) { /* */

        testRequirements(slopeMap, right, down);

        int mMapSize = slopeMap.length;
        int treesOnTheWay = 0;
        boolean sliding = true;
        int posX = 0, posY = 0;

        char c = slopeMap[posY][posX];
        if (c == '#')
            treesOnTheWay++;


        while (sliding) {
            posX += right;
            posX = posX % mMapSize;

            posY += down;
            if (posY >= mMapSize) {
                sliding = false;
                continue;
            }
            c = slopeMap[posY][posX];
            if (c == '#')
                treesOnTheWay++;
        }

        return treesOnTheWay;
    }

}
