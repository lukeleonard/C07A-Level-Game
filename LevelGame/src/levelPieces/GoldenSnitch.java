package levelPieces;
import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import levelPieces.GamePiece;
import java.util.Random;
public class GoldenSnitch extends GamePiece implements Moveable {
	private final static char symbol = 'G';
	private int speedMultiplier = 1;

	public GoldenSnitch(int location) {
		super(symbol, location);
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		int direction = 0;
		int saveLocation = this.getLocation();
		Random rand = new Random();
		if(playerLocation > this.getLocation()) {
			direction = rand.nextInt(4) - 2;
		} else {
			direction = rand.nextInt(4) - 1;
		}
		int tempLanding = (this.getLocation() + speedMultiplier*direction);
		tempLanding = tempLanding % (GameEngine.BOARD_SIZE-1);
		while(gameBoard[tempLanding] != null) {
			if (direction == 0) {
				break;
			}
			tempLanding += direction;
			tempLanding = tempLanding % (GameEngine.BOARD_SIZE-1);
		}
		this.setLocation(tempLanding); 
		gameBoard[tempLanding] = this;
		gameBoard[saveLocation] = null;
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(playerLocation == this.getLocation()) {
			speedMultiplier++;
			return InteractionResult.GET_POINT;
		}
		return InteractionResult.NONE;
	}

}
