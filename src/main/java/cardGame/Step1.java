package cardGame;

import java.util.*;

public class Step1 {
    public static void main(String[] args) {
        List<Integer> cards = generateNumbers();

        System.out.println(generateNumbers());
        System.out.println(generateNumbers().size());
        System.out.println(Arrays.deepToString(printGrid(cards)));
        printInitialGrid();
        int[][] inputs = getUserInput();
        revealCards(printGrid(cards),inputs);

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
        int[][] inputs = new int[2][2];

        System.out.println("좌표를 입력하세요.");

        for (int i = 0; i < 2; i++) {
            while (true) {
                System.out.print("입력 " + (i + 1) + "? "); // 입력 1 ?
                String input = scanner.nextLine();

                int[] coordinates = validateInput(input); // 입력받은 좌표의 유효성 검증
                if (coordinates != null) { // 입력받은 좌표가 null 이 아니면 -
                    inputs[i] = coordinates;
                    break; // 가장 가까운 반복문 빠져나감 // 여기서는 while 문
                }
            }
        }
        return inputs;
    }

    // 사용자에게 입력받은 좌표 유효성 검증하기
    public static int[] validateInput(String input) {
        try {
            input = input.toString().replaceAll("[^0-9,]", ""); // 괄호와 공백 없애기 // 숫자와 쉼표만 남음
            String[] parts = input.split(","); // 쉼표로 구분된 문자열 배열로 저장

            if (parts.length == 2) {
                int row = Integer.parseInt(parts[0]);
                int col = Integer.parseInt(parts[1]);

                if (row >= 1 && row <= 3 && col >= 1 && col <= 6) {
                    return new int[]{row, col};
                } else {
                    System.out.println("잘못된 입력입니다. 범위 내의 좌표를 입력해주세요.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            }
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
        }
        return null;
    }

    // 사용자에게 입력받은 좌표의 카드를 뒤집어서 보여주기
    public static void revealCards(int[][] grid, int[][] inputs) {
        for(int[] input : inputs){
            int row = input[0] -1 ; // 입력은 1부터, 인덱스는 0부터 시작하니까 조정
            int col = input[1] -1 ;
            System.out.println(grid[row][col]);
        }
    }

}
