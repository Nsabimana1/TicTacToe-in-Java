package tictactoe;

public class Board {
	private int height = 0;
	private int width = 0;
	private Tictac[][] Arrayboard;

	public Board(int size) {
		Arrayboard = new Tictac[size][size];
		this.height = size;
		this.width = size;
		for (int i = 0; i < this.width; i++) {
			for (int j = 0; j < this.height; j++) {
				this.Arrayboard[i][j] = null;
			}
		}

	}

	public void set(int x, int y, Tictac value) {
		this.Arrayboard[x][y] = value;
	}

	public Tictac get(int x, int y) {
		return this.Arrayboard[x][y];
	}

	public boolean IsEmpty(int x, int y) {
		if(Arrayboard[x][y] == null){
			return true;
		}
		else {
			return false;
		}
	}

}
