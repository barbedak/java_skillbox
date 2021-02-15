import java.util.ArrayList;

public class TodoList {
private final ArrayList<String> todoList = new ArrayList<>();

    public void add(String todo) {
        todoList.add(todo);
        System.out.println( "Добавлено дело \"" + todo + "\"" );
    }

    public void add(int index, String todo) {
        if (index < todoList.size() && index >= 0)
        {
            todoList.add(index, todo);
        } else
            {
            todoList.add(todo);
            }
        System.out.println("Добавлено дело \"" + todo + "\"");
    }

    public void edit(String todo, int index) {
        String replacedTodo;
        if (index < todoList.size() && index >= 0)
        {
            replacedTodo = todoList.get(index);
            todoList.set(index, todo);
            System.out.println("Дело \"" + replacedTodo + "\"" + " заменено на \""+ todo + "\"");
        }
    }

    public void delete(int index) {
        String deletedTodo;
        if (index < todoList.size() && index >= 0)
        {
            deletedTodo = todoList.get(index);
            todoList.remove(index);
            System.out.println("Дело \"" + deletedTodo + "\" удалено");
        } else
        {
            System.out.println("Дело с таким индексом не существует");
        }
    }

    public ArrayList<String> getTodos() {
        return todoList;
    }

}