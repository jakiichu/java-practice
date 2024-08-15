import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Интерфейс Production
interface Production {
    double calculateDefectPercentage(int totalProduced, int defectiveItems);
    void displayProductInfo();
}

// Класс Техника
class Technics implements Production {
    private String name;
    private int totalProduced;
    private int defectiveItems;

    public Technics(String name, int totalProduced, int defectiveItems) {
        this.name = name;
        this.totalProduced = totalProduced;
        this.defectiveItems = defectiveItems;
    }

    @Override
    public double calculateDefectPercentage(int totalProduced, int defectiveItems) {
        if (totalProduced == 0) {
            return 0.0;
        }
        return (double) defectiveItems / totalProduced * 100;
    }

    @Override
    public void displayProductInfo() {
        System.out.println("Техника: " + name);
        System.out.println("Общий объем производства: " + totalProduced);
        System.out.println("Количество бракованных изделий: " + defectiveItems);
        System.out.println("Процент брака: " + calculateDefectPercentage(totalProduced, defectiveItems) + "%");
    }
}

// Класс Канцелярия
class Stationery implements Production {
    private String name;
    private int totalProduced;
    private int defectiveItems;

    public Stationery(String name, int totalProduced, int defectiveItems) {
        this.name = name;
        this.totalProduced = totalProduced;
        this.defectiveItems = defectiveItems;
    }

    @Override
    public double calculateDefectPercentage(int totalProduced, int defectiveItems) {
        if (totalProduced == 0) {
            return 0.0;
        }
        return (double) defectiveItems / totalProduced * 100;
    }

    @Override
    public void displayProductInfo() {
        System.out.println("Канцелярия: " + name);
        System.out.println("Общий объем производства: " + totalProduced);
        System.out.println("Количество бракованных изделий: " + defectiveItems);
        System.out.println("Процент брака: " + calculateDefectPercentage(totalProduced, defectiveItems) + "%");
    }
}

// Класс Info
class Info {
    public void displayProductsWithHighDefectRate(List<Production> products, double threshold) {
        System.out.println("\nПродукция с процентом брака выше " + threshold + "%:");
        for (Production product : products) {
            if (product.calculateDefectPercentage(100, 50) > threshold) {
                product.displayProductInfo();
                System.out.println("--------------------");
            }
        }
    }
}

// Основной класс
public class index {
    public static void main(String[] args) {
        // Создание объектов классов Техника и Канцелярия
        Technics technics1 = new Technics("Ноутбук", 1000, 50);
        Technics technics2 = new Technics("Телефон", 500, 20);
        Stationery stationery1 = new Stationery("Ручка", 2000, 100);
        Stationery stationery2 = new Stationery("Тетрадь", 1500, 75);

        // Создание группы объектов
        List<Production> products = new ArrayList<>();
        products.add(technics1);
        products.add(technics2);
        products.add(stationery1);
        products.add(stationery2);

        // Ввод порога процента брака с клавиатуры
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите порог процента брака: ");
        double threshold = scanner.nextDouble();

        // Вывод информации о продукции с высоким процентом брака
        Info info = new Info();
        info.displayProductsWithHighDefectRate(products, threshold);
    }
}