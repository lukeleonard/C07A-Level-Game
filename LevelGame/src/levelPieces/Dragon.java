package levelPieces;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import levelPieces.GamePiece;
import levelPieces.Fire;
public class Dragon extends GamePiece implements Moveable {
	private final static char symbol = 'D';
	private final static int FIRE_FREQ = 3;
	private int counter = 0;

	public Dragon(int location) {
		super(symbol, location);
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		if(counter >= FIRE_FREQ) {
			counter = 0;
			int direction = 0;
			if(playerLocation > this.getLocation()) {
				direction = 1;
			} else {
				direction = -1;
			}
			Fire newFire =  new Fire(this.getLocation() + direction, direction);
			int tempLanding = (newFire.getLocation());
			while(gameBoard[tempLanding] != null) {
				tempLanding += direction;
			}
			newFire.setLocation(tempLanding);
			gameBoard[tempLanding] = newFire;
		}
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(playerLocation == this.getLocation()) {
			return InteractionResult.KILL;
		}
		return InteractionResult.NONE;
	}

}
