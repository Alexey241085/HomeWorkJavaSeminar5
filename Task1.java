// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1{
    public static void main(String[] args) {

        HashMap<String, ArrayList<Integer>> contacts = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while(true){
            menu();
            int numMenu = scanner.nextInt();
            if(numMenu == 1){
                System.out.print("Введите Имя: ");
                String inputName = scanner.next();
                System.out.print("Введите номер: ");
                System.out.println();
                int inputNumber = scanner.nextInt();
               addNumber(inputName, inputNumber, contacts);
               System.out.println(contacts);
            }
            else if (numMenu == 2){
                printBook(contacts);
            }
        }
    }
    
        //    метод МЕНЮ
    public static void menu(){
        System.out.println();
            System.out.println("      МЕНЮ     ");
            System.out.println("1. Добавить номер ");
            System.out.println("2. Вывод всего ");
            System.out.print("Выбере пункт меню: 1 или 2: ");
            System.out.println();
        }


    public static void addNumber(String key, int value, Map<String, ArrayList<Integer>> map){
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }

        
    public static void printBook(Map<String, ArrayList<Integer>> map){
        for (var item : map.entrySet()) {
            String phones = "";
            for(int el: item.getValue()){
                phones = phones + el + ", ";
            }
            System.out.printf("%s: %s \n", item.getKey(), phones);
        }
    }
}



