package levelPieces;
import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import levelPieces.GamePiece;
import levelPieces.Fire;
public class Dragon extends GamePiece implements Moveable {
	private final static char symbol = 'D';
	private final static int FIRE_FREQ = 1;
	private int counter = 0;
	private int fireCount = 0;
	private ArrayList<GamePiece> interactables;

	public Dragon(int location,ArrayList<GamePiece> interactables) {
		super(symbol, location);
		this.interactables = interactables;
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		if(counter >= FIRE_FREQ && fireCount < 5) {
			fireCount++;
			counter = 0;
			int direction = 0;
			if(playerLocation > this.getLocation()) {
				direction = 1;
			} else {
				direction = -1;
			}
			Fire newFire =  new Fire(this.getLocation() + direction);
			int tempLanding = (newFire.getLocation());
			while(gameBoard[tempLanding] != null) {
				tempLanding += direction;
			}
			newFire.setLocation(tempLanding);
			interactables.add(newFire);
			gameBoard[tempLanding] = newFire;
		}
		counter++;
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(playerLocation == this.getLocation()) {
			return InteractionResult.KILL;
		}
		return InteractionResult.NONE;
	}

}
