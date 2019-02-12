package levelPieces;

import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;
import levelPieces.GamePiece;

public class LevelEngine {
	private ArrayList<Moveable> moveables;
	private ArrayList<GamePiece> gamePieces;
	private Drawable [] board;
	
	public LevelEngine() {
		super();
		clearBoard();
		
	}
	
	public Drawable [] getBoard() {
		return board;
	}
	public ArrayList<Moveable> getMovingPieces() {
		return moveables;
	}
	public ArrayList<GamePiece> getInteractingPieces(){
		return gamePieces;
	}
	
	public void createLevel(int levelNum) {
		clearBoard();
		if(levelNum ==1) {
			level1();
		}else if(levelNum == 2){
			level2();
		}
		return;
	}
	
	public void clearBoard() {
		board = new Drawable [GameEngine.BOARD_SIZE];
		moveables = new ArrayList<Moveable>();
		gamePieces = new ArrayList<GamePiece>();
	}
	
	private void level1() {
		//board[1] = new Tree();
		for (int i = 0; i < GameEngine.BOARD_SIZE; i+=15) {
			Ninja tempNinja = new Ninja(i);
			board[i] = tempNinja;
			gamePieces.add(tempNinja);
			moveables.add(tempNinja);
		}
		//GoldenSnitch tempGS = new GoldenSnitch(13);
		//board[13] = tempGS;
		//gamePieces.add(tempGS);
		//moveables.add(tempGS);
		
		/*Trophy tempTrophy = new Trophy(13);
		board[13] = tempTrophy;
		gamePieces.add(tempTrophy);*/
	}
	
	private void level2() {
		Trophy tempTrophy = new Trophy(16);
		board[16] = tempTrophy;
		gamePieces.add(tempTrophy);
		Dragon tempDragon = new Dragon(9,gamePieces);
		board[9] = tempDragon;
		gamePieces.add(tempDragon);
		moveables.add(tempDragon);
	}
	
	public int getPlayerStartLoc() {
		return 11;
	}
}
