package chapter05;

import chaprer02.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static chaprer02.Dish.menu;
import static java.util.stream.Collectors.toList;

public class Edu01 {
    public static void main(String[] args) {

        List<Dish> vegetarianDishes = new ArrayList<>();
        for (Dish d : menu) {
            if (d.isVegetarian()) {
                vegetarianDishes.add(d);
            }
        }
        //데이터 컬렉션 반복을 명시적으로 관리하는 외부 반복 코드
        System.out.println(vegetarianDishes.toString());

        //스트림으로 변경
        //함수를 인자로 넘긴 예
        List<Dish> vegetarianDishesStream = new ArrayList<>();
        vegetarianDishesStream = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList())
        ;


        System.out.println(vegetarianDishesStream.toString());
        System.out.println("야채 갯수 : " + vegetarianDishesStream.size());

        /**********************************************************
         5.1 필터링
         **********************************************************/

        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)  //2,4 만이 2로 나눌 수 있음.
                .distinct()  // 2,2,4->2,4 요만 출력
                .forEach(System.out::println);  //출력

        /**********************************************************
         5.2 스트림 슬라이싱
         **********************************************************/

        List<Dish> specialMenu = Arrays.asList(
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        List<Dish> filteredMenu = specialMenu.stream()
                .filter(d-> {
                    //System.out.println(d.toString());
                    return d.getCalories() < 320;
                })
                .collect(toList());

        System.out.println(filteredMenu.toString());

        System.out.println("===============================================");
        System.out.println("5-2 슬라이싱");
        System.out.println("===============================================");

        System.out.println("Sorted menu sliced with takeWhile():");
        /*
        List<Dish> slicedMenu1 = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .collect(toList());
        slicedMenu1.forEach(System.out::println);
         */
    }
}
