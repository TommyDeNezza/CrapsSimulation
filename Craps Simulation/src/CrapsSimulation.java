import java.util.Scanner;

public class CrapsSimulation
	{
	static Scanner userStringInput = new Scanner(System.in);
	static Scanner userIntInput = new Scanner (System.in);
	static String loss1;
	static boolean playing = true;
	static String name;
	static int totalRoll;
	static boolean pointRolling = false;
	static int point;
	///I am doing this because he told me to
	public static void main(String[] args)
		{
		introducePlayer();
		tellRules();
		while(playing)
			{
			diceRoll();
			evaluation1();
			while(pointRolling)
				{
				diceRoll();
				evaluation2();
				}
			playAgain();
			}
		}
	public static void introducePlayer()
		{
		System.out.println("Welcome to Tony Hawk's Craps table! What is your name?");
		name = userStringInput.nextLine();
		System.out.println("Welcome " + name + ", ready to test your luck?");
	}
	public static void tellRules()
		{
		System.out.println("                       Here are the rules:");
		System.out.println("	Two six-sided dice are rolled and are added together. If the sum is a");
		System.out.println("2 (snake eyes) or a 12 (box cars), the player loses instantly. If the sum is"); 
		System.out.println("a 7 or an 11, the player wins instantly. If any other sum is rolled, that");
		System.out.println("number becomes “the point.” Now the player rolls until he or she either gets");
		System.out.println("the point and wins or rolls a 7 and loses..");
		}
	public static void diceRoll()
		{
		System.out.println("Click enter to roll.");
		String garbage = userStringInput.nextLine();
		int roll1 = (int)(Math.random()*6)+1;
		int roll2 = (int)(Math.random()*6)+1;
		totalRoll = roll1 + roll2;
		System.out.println("You rolled one " + roll1 + " and one " +roll2+ " for a total of " +totalRoll+ ".");
		}
	public static void evaluation1()
		{
		if (totalRoll == 2 || totalRoll == 12)
			{
			if(totalRoll == 2)
				{
				loss1 = "snake eyes";
				}
			else if(totalRoll == 12)
				{
				loss1 = "box car";
				}
			System.out.println("Sorry, you rolled a "+ loss1 +", you lose.");
				}
		else if(totalRoll == 7 || totalRoll == 11)
				{
				winner();
				}
		else
			{
			point = totalRoll;
			System.out.println("You're in the game, with point number at " +point+ ".");
			pointRolling = true;
			}
		}
	public static void evaluation2()
		{
		if(totalRoll == 7)
			{
			System.out.println("Sorry, you rolled a 7, you lose.");
			pointRolling = false;
			}
		else if(totalRoll == point)
			{
			System.out.println("Wow! You rolled "+point+", which is your point number!");
			pointRolling = false;
			winner();	
			}
		else
			{
			System.out.println("Not the point, keep rolling!");
			}
		}
	public static void winner()
		{
		System.out.println("Congratulations "+name+"! You've won Tony Hawks Craps Game!");
		}
	public static void playAgain()
		{
		System.out.println("Yes or no, would you like to play again?");
		String keepPlaying = userStringInput.nextLine();
		keepPlaying = keepPlaying.toLowerCase();
		if(keepPlaying.equals("yes"))
			{
			System.out.println("Lets try this one more time!");
			playing = true;
			}
		else if(keepPlaying.equals("no"))
			{
			System.out.println("Thanks for playing Tony Hawk's Craps table!");
			playing = false;
			}
		}
	}

	