package levelPieces;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import levelPieces.GamePiece;
public class Fire extends GamePiece implements Moveable {
	private final static char symbol = '~';
	private int direction;

	public Fire(int location, int direction) {
		super(symbol, location);
		this.direction = direction;
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		int tempLanding = (this.getLocation() + direction);
		while(gameBoard[tempLanding] != null) {
			tempLanding += direction;
		}
		this.setLocation(tempLanding);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(playerLocation == this.getLocation()) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}

}
