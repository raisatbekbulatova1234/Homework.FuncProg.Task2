import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final int PLOTS = 20;

    public static void main(String[] args) throws IOException {
        System.out.println("Введите цену участка за кв.м (500 - 1499): ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int price = Integer.parseInt(reader.readLine());

        List<plotOfLand> landPlots = new ArrayList<>();
        for (int i = 0; i < PLOTS; i++) {
            landPlots.add(new plotOfLand());
        }
        System.out.println("Список участков с ценой, не более " + price + " рублей за кв.м: ");
        landPlots.stream()
                .filter(a -> a.getCost() / (a.getLength() * a.getWidth()) <= price)
                .toList()
                .forEach(System.out::println);
    }
}