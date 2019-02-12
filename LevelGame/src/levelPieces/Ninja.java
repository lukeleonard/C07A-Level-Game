package levelPieces;
import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import levelPieces.GamePiece;
public class Ninja extends GamePiece implements Moveable {
	private final static char symbol = 'N';

	public Ninja(int location) {
		super(symbol, location);
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		int direction = 0;
		int saveLocation = this.getLocation();
		gameBoard[saveLocation] = null;
		if(playerLocation > this.getLocation()) {
			direction = 1;
		} else {
			direction = -1;
		}
		int tempLanding = (this.getLocation() + 3*direction);
		
		//tempLanding = (tempLanding + GameEngine.BOARD_SIZE) % (GameEngine.BOARD_SIZE);
		while(gameBoard[tempLanding] != null) {
			tempLanding += direction;
		}
		this.setLocation(tempLanding); 
		gameBoard[tempLanding] = this;
		
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(playerLocation == this.getLocation()) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}

}
