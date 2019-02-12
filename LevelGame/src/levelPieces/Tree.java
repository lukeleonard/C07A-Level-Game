package levelPieces;
import gameEngine.Drawable;
public class Tree implements Drawable{
	private final static char symbol = 't';
	
	public Tree() {
		super();
	}

	@Override
	public void draw() {
		System.out.print(symbol);
	}
}
