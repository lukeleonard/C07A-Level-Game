package levelPieces;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import levelPieces.GamePiece;
public class Trophy extends GamePiece{
	private final static char symbol = 'T';

	public Trophy(int location) {
		super(symbol, location);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(playerLocation == this.getLocation()) {
			return InteractionResult.ADVANCE;
		}
		return InteractionResult.NONE;
	}

}
