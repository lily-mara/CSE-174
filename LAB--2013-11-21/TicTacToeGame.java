import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        
        TicTacToe board = new TicTacToe();
        
        Scanner in = new Scanner(System.in);
        int row, col;
        for (int i = 0; i < 9; i++) {
            System.out.print("Enter row and column: ");
            row = in.nextInt();
            col = in.nextInt();
            if (board.isEmpty(row, col))
                board.makeMove(Cell.X, row, col);
                
            System.out.println(board.toString());
            
            if(board.getStatus() == TicTacToe.X_WINS) {
                System.out.println("You won!");
                System.exit(0);
            }
        }
    }
    
}