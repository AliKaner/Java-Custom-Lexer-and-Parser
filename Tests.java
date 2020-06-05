
public class Tests {
	public static void main(String[] args) {

        Lexer lexer = new Lexer("C:/Users/Input.txt");

        System.out.println("Lexical Analysis");
        System.out.println("-----------------");
        while (!lexer.isExausthed()) {
            System.out.printf("%-18s :  %s \n",lexer.currentLexema() , lexer.currentToken());
            lexer.moveAhead();
        }

        if (lexer.isSuccessful()) {
            System.out.println(" *************************************************************");
        } else {
            System.out.println(lexer.errorMessage());
        }
        
        	System.out.println(lexer.getLexamaList());
    }

}
