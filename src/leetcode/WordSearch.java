package leetcode;

import org.junit.Test;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0)
			return false;
		int n = board.length, m = board[0].length;
		boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				if (dfs(board, word, visited, 0, i, j))
					return true;
			}
		return false;
	}

	private boolean dfs(char[][] board, String word, boolean[][] visited, int level, int i, int j) {
		// TODO Auto-generated method stub
		if (level == word.length())
			return true;
		int n = board.length, m = board[0].length;
		if (i < 0 || j < 0 || i >= n || j >= m || visited[i][j] || board[i][j] != word.charAt(level))
			return false;
		visited[i][j] = true;
		boolean res = dfs(board, word, visited, level + 1, i, j + 1) || dfs(board, word, visited, level + 1, i + 1, j)
				|| dfs(board, word, visited, level + 1, i - 1, j) || dfs(board, word, visited, level + 1, i, j - 1);
		visited[i][j]=false;
		return res;
				
	}

	@Test
	public void test() {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		char[][] board1 = { { 'b', 'a' } };
		char[][] board2 = { { 'a', 'b' }, { 'c', 'd' } };
		System.out.println(exist(board1, "ab"));
	}
}
