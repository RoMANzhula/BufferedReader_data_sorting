import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); // відкриваємо потік для вводу даних з клавіатури

        String inputString; // створюємо змінну без ініціалізації (вона буде контейнером для введених користувачем даних)

        while (true) { // створюємо цикл, який буде виконуватись безкінечно
            System.out.println("Please input data: "); // запрошуємо користувача ввести дані в консоль
            inputString = bufferedReader.readLine(); // ініціалізуємо змінну контейнера = введеній користувачем рядку, при цьому ми
            // передаємо в головний метод main() виключення потоку вводу-виводу (throws IOException) або можна використати
            // блок try-catch для перехоплення виключень, або try-with-resource

            if (inputString.equals("exit")) { // щоб уникнути безкінечності циклу, ми встановлюємо перевірку - якщо введена користувачем строка буде = exit, то
                break; // виконуємо команду для зупинки програми
            }

            try {
                if (inputString.indexOf(".") > 0) { // якщо в введеній користувачем строкі є точка, то
                    // метод indexOf поверне індекс першого знаходження цього елементу, якщо не знайде - поверне -1, і якщо є
                    // точка, то виконуються наступні дії

                    Double doubleValue = Double.parseDouble(inputString); // створюємо змінну типу Double і ініціалізуємо
                    // її введеними користувачем даними, але при цьому перетворюємо їх у тип Double (клас-обгортка для роботи з об'єктами)
                    print(doubleValue); // за допомогою методу print, виводимо значення в консоль
                    continue; // передаємо управління користувачу для вводу нових даних з клавіатури
                }

                int intValue = Integer.parseInt(inputString); // створюємо змінну типу int і ініціалізуємо
                // її введеними користувачем даними, але при цьому перетворюємо їх у тип Integer (клас-обгортка для роботи з об'єктами)
                if (intValue > 0 && intValue < 128) { // якщо введене число більше 0 і менше 128 (в такому діапазоні)
                    print((short) intValue); // виводимо число, приведене до типу short
                    continue; // передаємо управління користувачу для вводу нових даних
                }
                if (intValue >= 128 || intValue <= 0) { // якщо введене число більше або рівне 128 або менше або рівне 0
                    print(intValue); // виводимо це значення в консоль
                    continue; // передаємо управління користувачу для вводу нових даних
                }
            } catch (NumberFormatException numberFormatException) { // перехоплюємо виключення, коли неможливо перетворити String в числовий тип

            }
            print(inputString); // в інших випадках (коли дані є строкою) виводимо введену строку користувача
        }
    }

    public static void print(Double value) { // публічний статичний метод, який приймає на вхід дані типу Double
        System.out.println("It is type Double, value " + value); // виводить повідомлення + значення
    }

    public static void print(String value) { // публічний статичний метод, який приймає на вхід дані типу String
        System.out.println("It is type String, value " + value); // виводить повідомлення + значення
    }

    public static void print(short value) { // публічний статичний метод, який приймає на вхід дані типу short
        System.out.println("It is type short, value " + value); // виводить повідомлення + значення
    }

    public static void print(Integer value) { // публічний статичний метод, який приймає на вхід дані типу Integer
        System.out.println("It is type Integer, value " + value); // виводить повідомлення + значення
    }
}

//У цьому завдання тобі потрібно:
//Зчитувати з консолі дані, доки буде введено слово " exit " .
//Для кожного значення, крім "exit", викликати метод print(). Якщо значення:
//містить точку '.', викликати метод print() для Double;
//Більше нуля, але менше 128, викликати метод print() для short;
//менше або дорівнює нулю або більше або дорівнює 128, викликати метод print() для Integer;
/ / Інакше - викликати метод print () для String.
