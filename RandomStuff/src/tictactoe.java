import java.util.ArrayList;
import java.util.Scanner;

public class tictactoe
{
	private static Scanner in = new Scanner(System.in);
	private static Board board = new Board();

	private static boolean playing = false;
	private static boolean user = true;

	public static void main(String[] args)
	{

	}

	private static Board findBestMove(Board board)
	{
		ArrayList<Position> positions = board.getFreePositions();
		Board bestChild = null;
		int previous = Integer.MIN_VALUE;
		for (Position p : positions)
		{
			Board child = new Board(board, p, PlayerSign.Circle);
			int current = min(child);
			if (current > previous)
			{
				bestChild = child;
				previous = current;
			}
		}
		return bestChild;
	}
}
