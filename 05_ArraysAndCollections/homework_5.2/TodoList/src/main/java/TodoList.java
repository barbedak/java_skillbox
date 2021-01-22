import java.util.ArrayList;

public class TodoList {
    private static ArrayList<String> todoList = new ArrayList<>();

    public TodoList(){
        todoList.clear();
    }

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        todoList.add(todo);
        System.out.println("Добавлено дело \"" + todo + "\"");
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        if(index < todoList.size() && index >= 0)
        {
            todoList.add(index, todo);
        } else
        {
            todoList.add(todo);
        }
        System.out.println("Добавлено дело \"" + todo + "\"");
    }

    public void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения

        if (index < todoList.size() && index >= 0)
        {
            String replace = todoList.get(index);
            todoList.set(index, todo);
            System.out.println("Дело \"" + replace + "\"" + " заменено на \""+ todo + "\"");
        }
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if (index < todoList.size() && index >= 0)
        {
            String deleteTodo = todoList.get(index);
            todoList.remove(index);
            System.out.println("Дело \"" + deleteTodo + "\" удалено");
        } else
        {
            System.out.println("Дело с таким индексом не существует");
        }
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return todoList;
    }

}