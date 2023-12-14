package cardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Step1 {
    public static void main(String[] args) {
        System.out.println(generateNumbers());
        System.out.println(generateNumbers().size());

    }

    // 1부터 8까지 각 세 장씩 랜덤하게 들어있는 카드 생성하기
    public static List<Integer> generateNumbers(){
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            numbers.add(i);
            numbers.add(i);
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers;
    }



}
