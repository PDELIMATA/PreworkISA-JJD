import java.util.regex.Pattern;
import java.util.Scanner;

public class Game {

    private int guessNum=0;
    private int loop =0;
    private boolean alreadyGuessed = false;
    private boolean addPoint = false;

    public void Start(String selectedMovie) {
        String hidden = new String(new char[selectedMovie.length()]).replace('\0', '_');
        String lettersGuessed = "";
        String fixedMovie = selectedMovie;

        // System.out.println(hidden);

        //Start the game
        System.out.println("Can you guess the movie?");

        //fix movie title to remove colons, spaces, etc...
        char[] unwantedCharacters = {':', ' '};
        fixedMovie = fixedMovie.replace(":", "_");
        fixedMovie = fixedMovie.replace(" ", "_");
        fixedMovie = fixedMovie.replace(", ", "_");

        Scanner scanner = new Scanner(System.in);

        for (int i = 10; i > 0; i--) {
            System.out.println("You have " + i + " guess(es) left. Choose again: ");
            System.out.println("Type a letter into the box. The console will only count the first letter you type.");
            System.out.println("So far you have guessed " + lettersGuessed);
            System.out.println("You have made a total of " + guessNum + " guesses.");
            System.out.println("Current word " + hidden);


            String guess = scanner.nextLine();
            char currentGuess = guess.charAt(0);

            if (Pattern.matches("[a-zA-Z]+", guess)){

                for(int x=1; x<=loop; x++){

                    if(currentGuess == lettersGuessed.charAt(x-1)){
                        System.out.println(("You already guessed the latter "+ currentGuess));
                        i++;
                        guessNum++;
                        alreadyGuessed = true;
                                break;
                    } else {
                        alreadyGuessed = false;
                    }
                }

                if(!alreadyGuessed){

                    for(int w=0; w<=selectedMovie.length()-1; w++){

                        char current = selectedMovie.charAt(w);

                        //Convert answer to lowercase
                        currentGuess = Character.toLowerCase(currentGuess);
                        if (current == currentGuess) {
                            System.out.println("You guessed a correct letter");
                            char[] charHidden = hidden.toCharArray();
                            charHidden[w] = current;
                            hidden = String.valueOf(charHidden);
                            addPoint = true;
                        }


                    }

                    lettersGuessed = lettersGuessed + currentGuess;
                    if (addPoint){ i++; addPoint = false;}
                    guessNum++;
                    loop++;
                }

                if (fixedMovie.equals(hidden)){
                    System.out.println("YOU WIN!");
                    System.out.println("The movie was "+ selectedMovie);
                    break;
                }
            } else {
                System.out.println("Please enter alphabetical characer!");
               i++;
           }
        }
        if (!fixedMovie.equals(hidden)){
            System.out.println("You lose!");
            System.out.println("The movie was "+ selectedMovie);
        }

    }
}
