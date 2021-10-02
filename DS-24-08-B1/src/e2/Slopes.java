package e2;

public class Slopes {


    public static void testRequirements(char[][] slopeMap, int right, int down) throws IllegalArgumentException {       //Comprobacion de requisitos previos
        int mMapSize = slopeMap.length;
        if (mMapSize > 1) {           //Comprueba tamaño del mapa
            for (char[] mMap : slopeMap) {  //Comprueba que sea cuadrado
                if (mMap.length != mMapSize)
                    throw new IllegalArgumentException("El mapa tiene que ser cuadrado");
            }

            for (char[] cc : slopeMap) {    //Comprueba que el mapa solo contenga . o #
                for (char c : cc) {
                    if (c != '.' && c != '#')
                        throw new IllegalArgumentException("Hay caracteres erroneos en el mapa pasado");
                }
            }

        } else
            throw new IllegalArgumentException("Tamaño del mapa ha de ser superior");

        if (right <= 0 || down <= 0 || right >= mMapSize || down >= mMapSize)   //Comprueba que right y down no sean valores invalidos
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

        testRequirements(slopeMap, right, down);    //Realiza comprobaciones

        int mMapSize = slopeMap.length;
        int treesOnTheWay = 0;
        boolean sliding = true;
        int posX = 0, posY = 0;


        char c = slopeMap[posY][posX];
        if (c == '#')           //Compruebo primera posición
            treesOnTheWay++;

        while (sliding) {
            for (int r = 0; r < right; r++) {   //Movimiento a la derecha
                posX++;
                if (posX >= mMapSize) {     //Vuelve al principio si se sale de rango
                    posX = 0;
                }

                c = slopeMap[posY][posX];
                if (c == '#')               //Comprueba posicion
                    treesOnTheWay++;


            }
            for (int d = 0; d < down; d++) {    //Movimiento abajo
                posY++;
                if (posY >= mMapSize) {     //LLega al final
                    sliding = false;
                } else {
                    c = slopeMap[posY][posX];
                    if (c == '#')           //Comprueba posicion
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

        testRequirements(slopeMap, right, down);    //Realiza comprobaciones

        int mMapSize = slopeMap.length;
        int treesOnTheWay = 0;
        boolean sliding = true;
        int posX = 0, posY = 0;

        char c = slopeMap[posY][posX];
        if (c == '#')           //Compruebo primera posición
            treesOnTheWay++;


        while (sliding) {
            posX += right;          //Salta a la derecha
            posX = posX % mMapSize; //Evito que se salga del rango

            posY += down;           //Muevo abajo
            if (posY >= mMapSize) { //Compruebo si termine
                sliding = false;
                continue;
            }
            c = slopeMap[posY][posX];
            if (c == '#')           //Comprueba posicion
                treesOnTheWay++;
        }

        return treesOnTheWay;
    }

}
