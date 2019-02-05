import gameEngine.Drawable;
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
		if(playerLocation > this.getLocation()) {
			direction = 1;
		} else {
			direction = -1;
		}
		int tempLanding = (this.getLocation() + 3*direction);
		while(gameBoard[tempLanding] != null) {
			tempLanding += direction;
		}
		this.setLocation(tempLanding);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		return InteractionResult.HIT;
	}

}
