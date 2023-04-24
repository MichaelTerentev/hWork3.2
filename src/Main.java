public class Main {
     SinglyLinkedList<String> list = new SinglyLinkedList<>();
     //добавление элементов
     list.add("Hello world");
     list.add("123");
     list.add("abcdef");
     //удаление элемента
     list.remove(1);
     //вывод элементов списка в консоль
     for(int i = 0; i < list.size(); i++) {
         System.out.println(list.get(i));
     }
}
