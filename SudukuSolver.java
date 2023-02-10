import java.util.Scanner;
public class SudukuSolver {
    public boolean isNumberRow(int [][]board,int num,int row){
        for(int i = 0;i<board.length;i++){
            if(board[row][i] == num){
                return true;
            }

        }
        return false;
    }

    public boolean isNumberCol(int [][]board,int num,int col){
        for(int i=0;i<board.length;i++){
            if(board[i][col] == num){
                return true;
            }


        }
        return false;
    }

    public boolean isNumberBox(int [][]board,int num,int row,int col){
        int localBoxRow = row-row%3;
        int localBoxCol = col-col%3;
        for(int i=localBoxRow;i<localBoxRow+3;i++){
            for(int j=localBoxCol;j<localBoxCol+3;j++){
                if(board[i][j] == num){
                    return true;

                }
            }
        }
        return false;

    }

    public boolean isPlacementValid(int [][]board,int num,int row,int col){
        if(!isNumberBox(board, num, row, col) && !isNumberCol(board, num, col) && !isNumberRow(board, num, row)){
            return true;
        }
        return false;
    }

    //Now that we have checked the palcement we need to write the code that auctually places the number
    public boolean bestPlacement(int [][]board){
        for(int i=0;i<board.length;i++){
            for(int j = 0;j<board.length;j++){
                if(board[i][j] == 0){
                    for(int numToTr=1;numToTr<=9;numToTr++){
                        if(isPlacementValid(board, numToTr, i,j)){
                            board[i][j] = numToTr;
                            if(bestPlacement(board)){
                                return true;
                            }
                            else{
                                board[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }

        }
        return true;
    }

    public void printBoard(int [][]board){
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board.length;j++){
                System.out.print(board[i][j]+"    ");

                
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        SudukuSolver obj = new SudukuSolver();
        int[][]arr = new int[9][9];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<9;i++){
            for(int j =0;j<9;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();
        obj.bestPlacement(arr);
        System.out.println("the solved sududku is:");
        obj.printBoard(arr);
        
    }
    
}
