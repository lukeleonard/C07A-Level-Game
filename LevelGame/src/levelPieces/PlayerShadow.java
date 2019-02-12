package levelPieces;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import levelPieces.GamePiece;
public class PlayerShadow extends GamePiece implements Moveable{
	private final static char symbol = '_';

	public PlayerShadow(int playerLocation) {
		super(symbol, playerLocation);
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		gameBoard[playerLocation] = this;
		
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		// TODO Auto-generated method stub
		return null;
	}
}
