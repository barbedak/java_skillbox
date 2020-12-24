import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 29;
        int month = 2;
        int year = 1992;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue

        GregorianCalendar birthday = new GregorianCalendar(year, month-1, day);
        Calendar now = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(" - dd.MM.yyyy - E", Locale.US);
        String text = "";

        int i = 0;
        while (!birthday.after(now)) {
            if (birthday.isLeapYear(birthday.get(Calendar.YEAR))) {
                birthday.set(Calendar.DAY_OF_MONTH, day);
            }
            text = text.concat(i + dateFormat.format(birthday.getTime()) + System.lineSeparator());
            birthday.add(Calendar.YEAR, 1);
            i++;
        }
        return text;
    }
}
