import cube.Block;
import cube.Cube;
import java.util.Scanner;

public class Main {
    /*
    Move log format:

    U – up
    UI – up inverted
    D – down
    DI – down inverted
    F – face
    FI – face inverted
    B – back
    BI – back inverted
    L – left
    LI – left inverted
    R – right
    RI – right inverted
    TL – turn left
    TR – turn right
    RF – roll forward
    RB – roll back

     */
    public static void main(String args[]) throws Exception {
        Cube c = new Cube();
        Scanner scanner = new Scanner(System.in);

        int selection = 0;
        do{
            System.out.println("1. Scramble");
            System.out.println("2. Solve");
            System.out.println("3. Print Cube");
            System.out.println("4. Enter a specific move:");
            selection = System.in.read();
            switch(selection){
                case '1':
                    c.scramble();
                    break;
                case '2':
                    c.clear_history();
                    Cube_solver.solve(c,0);
                    System.out.println(c.getHistory());
                    break;
                case '3':
                    printCube(c);
                    break;
                case '4':
                    System.out.println("Enter a move:");
                    String move = scanner.nextLine();
                    c.process(move);
                    break;
                default:
                    System.out.println("Next Input");
                    break;
            }
        }while(selection != '5');

    }
    public static void printCube(Cube c) {
        // Print top face
        System.out.print("      ");
        for(int i = 0; i < 3; i++) {
            System.out.print(c.get_col(new int[]{0, i, 1}, 'u') + " ");
        }
        System.out.println();

        for(int i = 0; i < 3; i++) {
            System.out.print("      ");
            for(int j = 0; j < 3; j++) {
                System.out.print(c.get_col(new int[]{0, j, 2-i}, 'b') + " ");
            }
            System.out.print(c.get_col(new int[]{0, 2-i, 0}, 'l') + " ");
            System.out.print(c.get_col(new int[]{0, 2-i, 2}, 'r') + " ");
            System.out.println(c.get_col(new int[]{0, 0, i}, 'f') + " ");
        }

        // Print bottom face
        System.out.print("      ");
        for(int i = 0; i < 3; i++) {
            System.out.print(c.get_col(new int[]{2, i, 1}, 'd') + " ");
        }
        System.out.println();
    }



}