import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {

        //루프를 이용한 외부반복
        List<String> names = new ArrayList<>();
        for(Dish dish: Dish.menu){
            names.add(dish.getName());
        }
        System.out.println(names.toString());

        //명시적 반복
        List<String> names2 = new ArrayList<>();
        Iterator<Dish> iterator = Dish.menu.iterator();

        while (iterator.hasNext()){  // <----명시적 반복
            Dish dish = iterator.next();
            names2.add(dish.getName());
        }

        System.out.println(names2);

        System.out.println("-----------------------------------------------------");
        System.out.println("--스트림을 이용한 방법");
        System.out.println("-----------------------------------------------------");

        //스트림 내부반복
        List<String> names3 = Dish.menu.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println(names3.toString());
    }
}