//백트래킹

class Solution {    
    public void solveSudoku(char[][] board) {
        isSolvedSudoku(board);
    }
    
    //완성된 수도쿠인지 체크하는 메서드
    public boolean isSolvedSudoku(char[][] board) {
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(board[row][col]== '.'){
                    for(char number='1'; number<='9';number++){
                        if(isValidNumber(board,row,col,number)){
                            board[row][col] = number;
                            if(isSolvedSudoku(board)) return true;
                            board[row][col] = '.';
                        }
                    }
                    return false; // 빈칸임에도 불구하고, 1~9까지 넣을 수있는 수가 없다면 false를 return
                }
            }
        }
        return true; // '.'이 하나도 없을경우 true를 return
    }
    
    //해당 칸에 주어진 number가 들어갈 수 있는지 확인하는 메서드
    public boolean isValidNumber(char[][] board, int row,int col, char number){
        for(int i=0;i<9;i++){
            //같은행에  주어진 숫자가 없는지
            if(board[row][i] == number) return false;
            //같은열에 주어진 숫자가 없는지
            if(board[i][col] == number) return false;
        }

        //같은 3*3칸 안에 주어진 숫자가 없는지
        int rowStart = (row/3)*3;
        int colStart = (col/3)*3;
        for(int i=rowStart;i<rowStart+3;i++){
            for(int j = colStart;j<colStart+3;j++){
                if(board[i][j]==number) return false;
            }
        }
        return true;
    }
}