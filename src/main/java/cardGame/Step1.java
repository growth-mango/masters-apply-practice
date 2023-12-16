package cardGame;

import java.util.*;

public class Step1 {
    public static void main(String[] args) {
        List<Integer> cards = generateNumbers();

        System.out.println(generateNumbers());
        System.out.println(generateNumbers().size());
        System.out.println(Arrays.deepToString(printGrid(cards)));
        printInitialGrid();

    }

    // 1부터 8까지 각 세 장씩 랜덤하게 들어있는 카드 생성하기
    public static List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            numbers.add(i);
            numbers.add(i);
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers;
    }

    // 생성된 카드를 3 * 6 형태로 18장 출력하기
    public static int[][] printGrid(List<Integer> numbers) {
        int[][] grid = new int[3][6];
        int index = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                grid[i][j] = numbers.get(index);
                index++;
            }
        }
        return grid;
    }

    // 처음에 X 출력하기
    public static void printInitialGrid() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print("X ");
            }
            System.out.println();
        }
    }

    // 사용자에게 좌표 입력받기
    public static int[][] getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int[][] inputs = new int[2][2]; // 좌표 크기 지정

        for (int i = 0; i < 2; i++) {
            while (true) { // true 면 계속 실행
                System.out.print("입력 " + (i + 1) + "? ");
                String input = scanner.nextLine();

                int[] coordinates = validateInput(input); // 입력 유효성 검증 메소드 구현 해야함
                if (coordinates != null) {
                    inputs[i] = coordinates;
                    break; // 가장 가까운 반복문 (즉 이 코드에서는 while문) 종료 시킴
                }
            }
        }
        return inputs;
    }

    public static

}
