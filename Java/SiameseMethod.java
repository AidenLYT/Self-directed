public class MagicSquareFactory {
    private int[][] square;
    private int sizing;

    public MagicSquareFactory(int size){
        this.sizing = size;
        this.square = new int[size][size];
    }

    public void createMagicSquare(){
        int row = 0;
        int column = sizing/2;
        square[row][column] = 1;

        for (int i = 2; i <= sizing * sizing; i++){
            if (square[(row + 2) % sizing][(column + 1) % sizing] == 0){
                row = (row + 2) % sizing;
                column = (column + 1) % sizing;
            } else {
                row = (row + 1 + sizing) % sizing;
            }
            square[row][column] = i;
        }
        
        for (int j = 0; j < sizing; j++){
            for (int q = 0; q < sizing; q++){
                System.out.print(square[j][q] + " ");
            }
            System.out.println();
        }

    }
}
