package br.com.QuizSystem.Functions;

public class Style {

    public void createMenu(int number) {

        System.out.println(title("Quiz ", number));
        System.out.println("[1]Start quiz ");
        System.out.println("[2]View your score ");
        System.out.println("[3]Exit ");
        System.out.println(line(number));

    }

    public String title(String message, int number) {
        String line = "==".repeat(number);
        return line + "\n" + message + "\n" + line;
    }

    public String line(int number) {
        return "==".repeat(number);
    }
}
