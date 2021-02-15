import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoList todoList = new TodoList();

        while(true)
        {
            String input = scanner.nextLine();

            if (input.equals("EXIT"))
            {
                break;
            }

            String[] inputArgs = input.split("\\s");
            String command = inputArgs[0];

            if (command.equals("LIST"))
            {
                int i = 0;
                for (String item : todoList.getTodos())
                {
                    System.out.println(i + " - " + item);
                    i++;
                }
            }

            if (command.equals("ADD"))
            {
                /*
                если второй переданный параметр число, то используем его как номер места, на которое вставим задачу
                иначе добавляем задачу в конец списка
                * */
                if (Character.isDigit(inputArgs[1].charAt(0)))
                {
                    int indexTask = Integer.parseInt(inputArgs[1]);
                    String task = inputArgs[2] + " ";

                    for (int i = 3; i < inputArgs.length; i++)
                    {
                        task = task.concat(inputArgs[i] + " ");
                    }
                    task = task.trim();
                    todoList.add(indexTask, task);
                } else
                    {
                    String task = inputArgs[1] + " ";
                    for (int i = 2; i < inputArgs.length; i++)
                    {
                        task = task.concat(inputArgs[i] + " ");
                    }
                    task = task.trim();
                    todoList.add(task);
                    }
            }

            if (command.equals("EDIT"))
            {
                int index = Integer.parseInt(inputArgs[1]);
                String task = inputArgs[2] + " ";
                for (int i = 3; i < inputArgs.length; i++)
                {
                    task = task.concat(inputArgs[i] + " ");
                }
                todoList.edit(task, index);
            }

            if (command.equals("DELETE"))
            {
                int index = Integer.parseInt(inputArgs[1]);
                todoList.delete(index);
            }
        }
    }
}
