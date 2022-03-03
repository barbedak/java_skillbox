package response;

public class Task {
    private static int id;
    private static String name;
    private static String text;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Task.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Task.name = name;
    }

    public static String getText() {
        return text;
    }

    public static void setText(String text) {
        Task.text = text;
    }


}
