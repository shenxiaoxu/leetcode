/*
59. Spiral Matrix II

Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
*/
class spiral{
	public static void main(String[] args){
		spiral s = new spiral();
		int n = 4;
		int[][] res = s.spiral(n);
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}
	private int[][] spiral(int n){
		int e = (int)Math.pow(n, 2);
		int s = 1, level = 0;
		int[][] res = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				res[i][j] = 0;
			}
		}
		while(s <= e){
			for(int i = level; i < n - level; i++){
				res[level][i] = s;
				s++;
			}
			for(int i = level + 1; i < n - level; i++){
				res[i][n - level - 1] = s;
				s++;
			}
			for(int i = n - level - 2; i >= level; i--){
				res[n - level - 1][i] = s;
				s++;
			}
			for(int i = n - level - 2; i > level; i--){
				res[i][level] = s;
				s++;
			}
			level++;
		}
		return res;
	}
}