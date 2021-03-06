package levelPieces;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import levelPieces.GamePiece;
public class Fire extends GamePiece{
	private final static char symbol = '~';

	public Fire(int location) {
		super(symbol, location);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(playerLocation == this.getLocation()) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}

}
