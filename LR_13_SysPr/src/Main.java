import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String fileName = "24_demo.txt";

        try {
            int longestSequence = findLongestXSequence(fileName);
            System.out.println("Длина самой длинной последовательности символов 'X': " + longestSequence);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public static int findLongestXSequence(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int maxLength = 0;
        int currentLength = 0;
        int character;

        // Читаем файл посимвольно
        while ((character = reader.read()) != -1) {
            char ch = (char) character;

            if (ch == 'X') {
                currentLength++; // Если символ 'X', увеличиваем текущую длину
            } else {
                maxLength = Math.max(maxLength, currentLength); // Обновляем максимальную длину, если текущая больше
                currentLength = 0; // Сбрасываем текущую длину
            }
        }

        // Последняя проверка после выхода из цикла
        maxLength = Math.max(maxLength, currentLength);

        reader.close(); // Закрываем поток чтения
        return maxLength;
    }
}
