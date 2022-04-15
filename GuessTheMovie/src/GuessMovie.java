import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GuessMovie {

    public static void main(String [] args) throws FileNotFoundException {

        int lines = 0;
        String selectedMovie ="";

        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            lines ++;
        }
        //System.out.println("Number of movies: " + lines);
        int whichLine = (int) (Math.random()*(lines));
        //System.out.println("Number of selected movie: " + whichLine);

        File file2 = new File("movies.txt");
        Scanner scanner2 = new Scanner((file2));

        int i = 0;
        while (i<=whichLine){
            selectedMovie = scanner2.nextLine();
            i++;
        }

       // System.out.println(selectedMovie);

        Game game = new Game();
        game.Start(selectedMovie);

    }
}

