package leetcode;

import java.util.Arrays;

import org.junit.Test;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		int n=board.length;
		int m=board[0].length;
        boolean[][] rows=new boolean[n][10];
        boolean[][] cols=new boolean[m][10];
        boolean[][] cells=new boolean[m*n/9][10];
		for(int i=0;i<9;i++)
        	for(int j=0;j<9;j++)
        	{
        		char c=board[i][j];
        		if(c>='1'&&c<='9')
        		{
        			int cc=c-'0';
	        		if(rows[i][cc]||cols[j][cc]||cells[3*(i/3)+j/3][cc])
	        			return false;
	        		rows[i][cc]=true;
	        		cols[j][cc]=true;
	        		cells[3*(i/3)+j/3][cc]=true;
        		}
        	}
		return true;
    }
	public boolean isValidSudoku1(char[][] board) {
		int [] vset=new int[9];
		int[] hset=new int[9];
		int[] cells=new int[9];
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(board[i][j]!='.')
				{
					int c=1<<(board[i][j]-'0');
					if((hset[i]&c)>0||(vset[j]&c)>0||(cells[3*(i/3)+j/3]&c)>0)
						return false;
					hset[i]|=c;
					vset[j]|=c;
					cells[3*(i/3)+j/3]|=c;
				}
			}
		}
		return true;
	}
	@Test
	public void test(){
	char[][] board={
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','9','.','.','.','.','.','.','1'},
            {'8','.','.','.','.','.','.','.','.'},
            {'.','9','9','3','5','7','.','.','1'},
            {'.','.','.','.','.','.','.','4','.'},
            {'.','.','.','8','.','.','.','.','.'},
            {'.','1','.','.','.','.','4','.','9'},
            {'.','.','.','5','.','4','.','.','.'}
			};

	System.out.println(isValidSudoku1(board));
	}
}
