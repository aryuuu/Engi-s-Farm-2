import com.Gameplay;
import java.util.Scanner;

// TESTER KESELURUHAN
// BUKA FILE MAIN BENERAN

public class DummyMain
{
    public static void main(String[] args) {
        Gameplay game = new Gameplay("map.txt", "farmAnimals.txt");
        String cmd = "";
        Scanner in = new Scanner(System.in);

        while (!cmd.toLowerCase().equals("exit"))
        {
            game.showGameplay();
            System.out.print("Command: ");
            cmd = in.nextLine();
            if (cmd.toLowerCase().equals("w")) {
                game.moveUp();
                game.everyTurn();
            }
            else if (cmd.toLowerCase().equals("a")) {
                game.moveLeft();
                game.everyTurn();
            }
            else if (cmd.toLowerCase().equals("s")) {
                game.moveDown();
                game.everyTurn();
            }
            else if (cmd.toLowerCase().equals("d")) {
                game.moveRight();
                game.everyTurn();
            }
            else if (cmd.toLowerCase().equals("grow")) {
                game.grow();
                game.everyTurn();
            }
            else if (cmd.toLowerCase().equals("talk")) {
                game.talk();
                game.everyTurn();
            }
            else if (cmd.toLowerCase().equals("interact")) {
                game.interact();
                game.everyTurn();
            }
            else if (cmd.toLowerCase().equals("kill")) {
                game.kill();
                game.everyTurn();
            }
            else if (cmd.toLowerCase().equals("help")) {
                System.out.println("Game Engi's Farm");
                System.out.println("Kelas 2 - Kelompok 02 -- Subscribe to Pewdiepie\n");
                System.out.println("Command list:");
                System.out.println("w - player move up");
                System.out.println("a - player move left");
                System.out.println("s - player move down");
                System.out.println("d - player move right");
                System.out.println("grow - player grows grass");
                System.out.println("talk - player talks to animal");
                System.out.println("interact - player interacts with an animal or a facility");
                System.out.println("kill - player kills an animal");
                System.out.println("help - command list");
                System.out.println("exit - exiting game");
            }
            else if (cmd.toLowerCase().equals("exit")) {
                System.out.println("Exiting game...");
            }
            else
            {
                System.out.println("Invalid command");
                System.out.println("Type 'help' for list of commands");
            }
        }
        in.close();
    }
}