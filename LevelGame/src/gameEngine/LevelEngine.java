package gameEngine;

import java.util.ArrayList;

import levelPieces.GamePiece;

public class LevelEngine {
	public Drawable [] getBoard() {
		Drawable [] tempDrawable = new Drawable [1];
		return tempDrawable;
	}
	public ArrayList<Moveable> getMovingPieces() {
		ArrayList<Moveable> tempMoveable = null;
		return tempMoveable;
	}
	public ArrayList<GamePiece> getInteractingPieces(){
		ArrayList<GamePiece> tempGamePieces = null;
		return tempGamePieces;
	}
	
	public void createLevel(int levelNum) {
		if(levelNum ==1) {
			level1();
		}else if(levelNum == 2){
			level2();
		}
		return;
	}
	
	private void level1() {
		
	}
	
	private void level2() {
		
	}
	
	public int getPlayerStartLoc() {
		return 0;
	}
}
