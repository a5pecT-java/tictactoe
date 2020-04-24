import java.util.Scanner;

public class tictactoe2
{
	static Scanner in = new Scanner(System.in);
	static Scanner inn = new Scanner(System.in);
	static Character[][] board = new Character[3][3];
	static boolean playing = true;
	static boolean winner = false;

	public static void main(String[] args)
	{
		clear();
		title();
		intro();
		clearConsole();
		int count = 0;
		print();
		System.out.println("You would enter a position like this. (b2)");
		while (playing)
		{
			count++;
			user();
			checkWin(count);
			System.out.println("CPU's Turn");
			cpu();
			checkWin(count);

			if (winner)
			{
				System.out.println("Do you want to play again?");
				String answer = in.nextLine();
				answer.toLowerCase();
				if (answer.contains("y"))
					clear();
				else
					playing = false;
			}
		}
	}

	public static void user()
	{
		int column;
		System.out.print("Your Turn: ");
		String location = in.nextLine();
		if (location.substring(0, 1).equals("a"))
		{
			column = 0;
		} else if (location.substring(0, 1).equals("b"))
		{
			column = 1;
		} else
		{
			column = 2;
		}
		if (board[Integer.parseInt(location.substring(1)) - 1][column].equals(' '))
			board[Integer.parseInt(location.substring(1)) - 1][column] = 'X';
		else
		{
			while (!(board[Integer.parseInt(location.substring(1)) - 1][column].equals(' ')))
			{
				System.out.print("Try Again: ");
				location = in.nextLine();
				if (location.substring(0, 1).equals("a"))
				{
					column = 0;
				} else if (location.substring(0, 1).equals("b"))
				{
					column = 1;
				} else
				{
					column = 2;
				}
			}
			board[Integer.parseInt(location.substring(1)) - 1][column] = 'X';
			print();
		}
	}

	public static void cpu()
	{

		int cpuColumn = (int) (Math.random() * 3) + 0;
		int cpuRow = (int) (Math.random() * 3) + 0;
		if (board[cpuColumn][cpuRow].equals(' '))
			board[cpuColumn][cpuRow] = 'O';
		else
		{
			while (!(board[cpuColumn][cpuRow].equals(' ')))
			{
				cpuColumn = (int) (Math.random() * 3) + 0;
				cpuRow = (int) (Math.random() * 3) + 0;
				if (board[cpuColumn][cpuRow].equals(' '))
					board[cpuRow][cpuColumn] = 'O';
				break;
			}
		}
		print();
	}

	public static void checkWin(int count)
	{
		if (hasWon('x'))
			System.out.println("You won!");
		else if (hasWon('o'))
			System.out.println("Computer wins!");
		else if (count == 9)
			System.out.println("You tied!");
		else
		{
			System.out.println("unfinished");
		}
	}

	private static boolean hasWon(char sign)
	{
		int x, y;

		// Check diagonals
		if (board[0][0] == sign && board[1][1] == sign && board[2][2] == sign)
			return true;
		if (board[0][2] == sign && board[1][1] == sign && board[2][0] == sign)
			return true;

		// Check row
		for (x = 0; x < 3; x++)
		{
			for (y = 0; y < 3; y++)
				if (board[x][y] != sign)
					break;
			if (y == 3)
				return true;
		}

		// Check col
		for (x = 0; x < 3; x++)
		{
			for (y = 0; y < 3; y++)
				if (board[y][x] != sign)
					break;
			if (y == 3)
				return true;
		}
		return false;
	}

	public static void print()
	{
		System.out.println("    A   B   C");
		for (int r = 0; r < board.length; r++)
		{
			System.out.print(r + 1 + " | ");
			for (int c = 0; c < board[r].length; c++)
			{
				System.out.print(board[r][c] + " | ");
			}
			System.out.println();
		}
	}

	public static void clear()
	{
		for (int r = 0; r < board.length; r++)
		{
			for (int c = 0; c < board[r].length; c++)
			{
				board[r][c] = ' ';
			}
		}
	}

	public static void rules()
	{
		System.out.println("Rules: ");
		System.out.println("\n1. The game is played on a grid that's 3 squares by 3 squares.\r\n"
				+ "\n2. You are X, your friend (or the computer in this case) is O. Players take turns putting their marks in empty squares.\r\n"
				+ "\n3. The first player to get 3 of there marks in a row (up, down, across, or diagonally) is the winner.\r\n"
				+ "\n4. When all 9 squares are full, the game is over. If no player has 3 marks in a row, the game ends in a tie.\n");
		in.nextLine();
		System.out.println("Press {Enter} to Continue");
	}

	public static void title()
	{
		System.out.println("___________");
		System.out.println();
		System.out.println("Tic-Tac-Toe");
		System.out.println("___________");
	}

	public static void intro()
	{
		System.out.print("\n[Welcome to Daniels's game, do you need to know the rules?]: ");
		String response = in.nextLine();
		response.toLowerCase();
		skipLine();
		skipLine();
		skipLine();

		if (response.contains("y"))
			rules();
		skipLine();
		skipLine();

	}

	public static void skipLine()
	{
		System.out.println();
	}

	public final static void clearConsole()
	{
		for (int i = 0; i < 50; ++i)
			System.out.println();
	}

}