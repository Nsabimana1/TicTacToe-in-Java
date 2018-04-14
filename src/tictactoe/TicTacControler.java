package tictactoe;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TicTacControler {
	private double x = 0;
	private double y = 0;
	private boolean switchplayers = true;
	private int Score1 = 0;
	private int Score2 = 0;
	private int ScoreTies = 0;
	private Tictac Move;
	private Board ticBoad = new Board(3);
	private Main Main  = new Main();

	@FXML
	private Canvas board;

	@FXML
	public void initialize() {
		this.DrawBoard();
		this.PrintScore();

		board.setOnMouseClicked(event -> {
			if (this.switchplayers == true) {
				this.Move = Tictac.X;	
			}else {
				this.Move = Tictac.O;
			}

			if (event.getX() > 10 && event.getX() < 520 && event.getY() > 10 && event.getY() < 550) {
				this.x = (int) event.getX();
				this.y = (int) event.getY();
				this.setOutputCoordinates();
			}

			if(this.Move == Tictac.X && this.Main.GoalReached(this.Move, ticBoad) == true ) {
				this.Score1 += 1;
				this. ClearBoard();
			}else if(this.Move == Tictac.O && this.Main.GoalReached(this.Move, ticBoad) == true ) {
				this.Score2 += 1;
				this. ClearBoard();
			}else if(this.Main.BoardIsfull(ticBoad) == true) {
				this.ScoreTies += 1;
				this. ClearBoard();
			}

			this.PrintScore();
		});
	}

	@FXML public void RestartGame() {
		this.Score1 = 0;
		this.Score2 = 0;
		this.ScoreTies = 0;
		this. ClearBoard();
	}

	public void draw(String d) {
		board.getGraphicsContext2D().setFont(new Font("Courier", 100));
		board.getGraphicsContext2D().fillText(d, this.x, this.y);
	}

	public void DrawBoard(){
		board.getGraphicsContext2D().setFill(Color.BLACK);

		board.getGraphicsContext2D().fillRect(10, 10, 510, 3);
		board.getGraphicsContext2D().fillRect(10, 200, 510, 3);
		board.getGraphicsContext2D().fillRect(10, 400, 510, 3);
		board.getGraphicsContext2D().fillRect(10, 560, 510, 3);
		board.getGraphicsContext2D().fillRect(10, 610, 510, 3);

		board.getGraphicsContext2D().fillRect(10, 10, 3, 550);
		board.getGraphicsContext2D().fillRect(180, 10, 3, 550);
		board.getGraphicsContext2D().fillRect(350, 10, 3, 550);
		board.getGraphicsContext2D().fillRect(520, 10, 3, 550);
	}

	public void ClearBoard() {
		board.getGraphicsContext2D().setFill(Color.WHITESMOKE);
		board.getGraphicsContext2D().fillRect(0, 0, 620, 620);
		this.DrawBoard();
		this.PrintScore();
		this.ticBoad = new Board(3);
		this.x = 0;
		this.y = 0;
	}

	public void PrintScore() {
		board.getGraphicsContext2D().setFont(new Font("Courier", 20));
		board.getGraphicsContext2D().fillText("Player1('X'): " + Integer.toString(this.Score1) + "     |   " , 30, 600);
		board.getGraphicsContext2D().fillText("Ties: " + Integer.toString(this.ScoreTies) + "      | " , 210, 600);
		board.getGraphicsContext2D().fillText("Player2('O'): " + Integer.toString(this.Score2), 350, 600);
	}

	public void UpdateSpot(double x, double y, int Bx, int By) {
		this.x = x;
		this.y = y;
		if (this.ticBoad.IsEmpty(Bx, By)) {
			this.ticBoad.set(Bx, By, this.Move);
			this.draw(this.Move.toString());
			this.switchplayers = !this.switchplayers;
		}
	}

	public void setOutputCoordinates() {
		if(this.x >= 10 && this.x <= 180 && this.y >= 10 && this.y <= 200) {
			UpdateSpot(66.0, 134.0, 0, 0);

		}else if(this.x > 180 && this.x <= 350 && this.y >= 10 && this.y <= 200) {
			UpdateSpot(229.0, 134.0, 0, 1);

		}else if(this.x > 350 && this.x <= 500 && this.y >= 10 && this.y <= 200) {
			UpdateSpot(392.0, 134.0, 0, 2);

		}else if(this.x >= 10 && this.x <= 180 && this.y > 200 && this.y <= 400) {
			UpdateSpot(71.0, 342.0, 1, 0);

		}else if(this.x > 180 && this.x <= 350 && this.y > 200 && this.y <= 400) {
			UpdateSpot(234.0, 342.0, 1, 1);

		}if(this.x > 350 && this.x <= 500 && this.y > 200 && this.y <= 400) {
			UpdateSpot(397.0, 342.0, 1, 2);

		}else if(this.x >= 10 && this.x <= 180 && this.y > 400 && this.y <= 550) {
			UpdateSpot(71.0, 520, 2, 0);

		}else if(this.x > 180 && this.x <= 350 && this.y > 400 && this.y <= 550) {
			UpdateSpot(234.0, 520, 2, 1);

		}if(this.x > 350 && this.x <= 500 && this.y > 400 && this.y <= 550) {
			UpdateSpot(397.0, 520, 2, 2);

		}
	}

}
