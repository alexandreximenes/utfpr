import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Identifier {

    public Identifier(String input) {
        this.input = input;
    }

    private String input;


    public boolean validate() {
        if (this.input == null)
            throw new RuntimeException("Palavra não pode ser nula");
        return this.minCaracter() && this.maxCaracter() && comecaComLetra() && contemLetraOuNumero();
    }

    public boolean minCaracter() {
        if (this.input == null)
            throw new RuntimeException("Palavra não pode ser nula");
        if (this.input.length() == 0)
            throw new RuntimeException("Palavra deve ter pelo menos 1 caracter");
        return this.input.length() >= 1;
    }


    public boolean maxCaracter() {
        if (this.input == null)
            throw new RuntimeException("Palavra não pode ser nula");
        if (this.input.length() > 6)
            throw new RuntimeException("Palavra Não pode ser maior que 6");
        return this.input.length() <= 6;
    }

    public boolean comecaComLetra() {
        if (this.input == null )
            throw new RuntimeException("Palavra não pode ser nula");
        if (!Character.isLetter(this.input.charAt(0)) )
            throw new RuntimeException("Palavra deve começar com letras");
        return Character.isLetter(this.input.charAt(0));
    }


    public boolean contemLetraOuNumero() {
        if (this.input == null)
            throw new RuntimeException("Palavra não pode ser nula");
        if (!(Pattern.compile("[A-Za-z]+[0-9]+").matcher(this.input).matches()))
            throw new RuntimeException("Palavra não deve conter caracteres especiais");
        return Pattern.compile("[A-Za-z]+[0-9]+").matcher(this.input).matches();
    }
}

