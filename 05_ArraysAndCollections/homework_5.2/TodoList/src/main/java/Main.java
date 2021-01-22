import java.util.Scanner;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            String input = scanner.nextLine();
            if (input.equals("EXIT"))
            {
                break;
            }
            String[] inputArgs = input.split("\\s");

            if (inputArgs[0].equals("LIST"))
            {
                int i = 0;
                for (String item : todoList.getTodos())
                {
                    System.out.println(i + " - " + item);
                    i++;
                }
            }
            if (inputArgs[0].equals("ADD"))
            {
                //если вторым параметром введено число (номер задачи в списке дел)
                if (Character.isDigit(inputArgs[1].charAt(0)))
                {
                    String todo = inputArgs[2] + " ";
                    for (int i = 3; i < inputArgs.length; i++)
                    {
                        todo= todo.concat(inputArgs[i] + " ");
                    }
                    todoList.add(Integer.parseInt(inputArgs[1]), todo.trim());
                } else
                    {
                    String todo = inputArgs[1] + " ";
                    for (int i = 2; i < inputArgs.length; i++)
                    {
                        todo= todo.concat(inputArgs[i] + " ");
                    }
                    todoList.add(todo.trim());
                    }
            }
            if (inputArgs[0].equals("EDIT"))
            {
                String todo = inputArgs[2] + " ";
                for (int i = 3; i < inputArgs.length; i++)
                {
                    todo= todo.concat(inputArgs[i] + " ");
                }
                todoList.edit(todo, Integer.parseInt(inputArgs[1]));
            }
            if (inputArgs[0].equals("DELETE"))
            {
                todoList.delete(Integer.parseInt(inputArgs[1]));
            }
        }
    }
}
