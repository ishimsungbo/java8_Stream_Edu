package chaprer02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Edu0404 {
    public static void main(String[] args) {

        List<String> names = Dish.menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(names.toString());

        /**********************************************************************/
        /* 예제 시스템 로그를 찍어봄
        /* filter나 sorted 같은 중간 연산은 다른 스트림을 반환한다.
            따라서 여러 중간 연산을 연결해서 질의를 만들 수 있다. 중간 연산의 중요한 특징은 단말 연산을
            스트림 파이프라인에 실행하기 전꺼지는 아무 연산도 수행하지 않는다는 것, 즉 게이르다. lazy
            중간 연산을 합친 다음에 합쳐진 중간 연산을 최종 연산으로 한 번에 처리한다.

            스트림 파이프라인에서 어떤 일이 일어나는지 쉽게 확인할 수 있도록 람다가 현채 처리 중인
            요리를 출력하자. 실제 운영 코드에서는 제거해 이와 같은 출력 코드를 추가하지 않는 것이 좋다.
            하지만 출력문 덕분에 프로그램 실행 과정을 쉽게 확인할 수 있으므로 학습용으로는 매우 좋은 기법이다.
         */

        List<String> names02 = Dish.menu.stream()
                .filter(dish ->{
                    System.out.println("filtering : " + dish.toString());
                    return dish.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("mapping : " + dish.toString());
                    return dish.getName();
                })
                .limit(3)
                .collect(Collectors.toList());

                System.out.println(names02);
    }
}
