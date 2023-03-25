import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки, отвечающие фильтру.
// NoteBook notebook1 = new NoteBook
// NoteBook notebook2 = new NoteBook
// NoteBook notebook3 = new NoteBook

// Например: “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет

// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.

// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

// Класс сделать в отдельном файле

// приветствие
// Выбор параметра
// выбор конкретнее
// вывод подходящих

public class notemain {
    public static void main(String[] args) {
        Set<NoteClass> noteSet = new HashSet<NoteClass>();

        NoteClass notebook1 = new NoteClass("Dell", "16.0", "Windows 11", 8, "512 Gb", "white");
        NoteClass notebook2 = new NoteClass("Lenovo", "15.4", "Linux", 16, "1 Tb", "blue");
        NoteClass notebook3 = new NoteClass("Acer", "14.5", "Windows 10", 4, "512 Gb", "red");
        NoteClass notebook4 = new NoteClass("Apple", "17.3", "MacOS", 8, "512 Gb", "grey");
        NoteClass notebook5 = new NoteClass("Sony", "15", "Windows 11", 32, "1 Tb", "black");
        NoteClass notebook6 = new NoteClass("Dell", "18.4", "Linux", 32, "1 Tb", "blue");
        NoteClass notebook7 = new NoteClass("Huawei", "15", "Windows 11", 16, "512 Gb", "white");

        noteSet.add(notebook1);
        noteSet.add(notebook2);
        noteSet.add(notebook3);
        noteSet.add(notebook4);
        noteSet.add(notebook5);
        noteSet.add(notebook6);
        noteSet.add(notebook7);

        filter(noteSet);
    }

    static void showSet(Set<NoteClass> notes) {
        int i = 1;
        for (NoteClass note : notes) {
            System.out.printf("Модель %d:\n", i);
            System.out.println(note);
            i++;
        }
    }

    public static void filter(Set<NoteClass> notes) {
        Set<NoteClass> filteredNotes = new HashSet<>();

        Scanner choiceScanner = new Scanner(System.in);
        Scanner choiceRefScanner = new Scanner(System.in);
        System.out.println("Добро пожаловать!");
        System.out.println("Введите цифру, соответствующую необходимому критерию:\n\t1 - Производитель\n\t2 - диагональ\n\t3 - Операционная система\n\t4 - Оперативная память\n\t5 - Объем жесткого диска\n\t6 - Цвет");
        Character choice = choiceScanner.next().charAt(0);

        switch (choice) {
            case '1':
                System.out.println("Какой производитель интересует? Введите название или часть названия: ");
                String choiceOne = choiceRefScanner.nextLine();
                for (NoteClass note : notes) {
                    if (note.containsManufacturer(choiceOne)) filteredNotes.add(note);            
                }
                break;
            case '2':
                System.out.println("Укажите размер диагонали: ");
                String choiceTwo = choiceRefScanner.nextLine();
                for (NoteClass note : notes) {
                    if (note.containSize(choiceTwo)) filteredNotes.add(note);          
                }
                break;
            case '3':
                System.out.println("Какая операционная система интересует? Введите название или часть названия: ");
                String choiceThree = choiceRefScanner.nextLine();
                for (NoteClass note : notes) {
                    if (note.containsOperation(choiceThree)) filteredNotes.add(note);          
                }
                break;
            case '4':
                System.out.println("Укажите размер оперативной памяти: ");
                Integer choiceFour = choiceRefScanner.nextInt();
                for (NoteClass note : notes) {
                    if (note.containsRam(choiceFour)) filteredNotes.add(note);          
                }
                break;
            case '5':
                System.out.println("\nУкажите интересующий объем жесткого диска: ");
                String choiceFive = choiceRefScanner.nextLine();
                for (NoteClass note : notes) {
                    if (note.containsHdd(choiceFive)) filteredNotes.add(note);          
                }
                break;
            case '6':
                System.out.println("\nКакой цвет интересует? Введите название или часть названия: ");
                String choiceSix = choiceRefScanner.nextLine();
                for (NoteClass note : notes) {
                    if (note.containsColor(choiceSix)) filteredNotes.add(note);          
                }
                break;
            default:
                break;
        }
        
        choiceScanner.close();
        choiceRefScanner.close();

        if (!filteredNotes.isEmpty()) {
            System.out.println("\nВот, что нашлось по выбранному параметру:\n");
            showSet(filteredNotes);
        }
        else {
            System.out.println("\nНет ноубуков по выбранному параметру, а может нет такого критерия, но можете посмотреть весь модельный ряд:\n");
            showSet(notes);
        }
    }
}
