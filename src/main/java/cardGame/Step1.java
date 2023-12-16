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

    // 사용자에게 입력받은 좌표 유효성 검증하기
    public static int[] validateInput(String input) {
        try { // 예외가 발생할 수 있는 코드
            input = input.toString().replaceAll("[^0-9,]", ""); // 숫자와 쉼표 제외하고(즉 괄호와 공백은) 제거하기
            String[] parts = input.split(","); // 골호 공백 제거한 문자열을 배열로 만들기

            if (parts.length == 2) { // 배열의 길이가 두개가 맞으면
                // 이부분에서 사용자가 숫자를 입력하지 않았으면 catch 문으로 이동!
                int row = Integer.parseInt(parts[0]); // 숫자 한 개씩 범위 확인 row 3 이내
                int col = Integer.parseInt(parts[1]); // col 6 이내

                if (row >= 1 && row <= 3 && col >= 1 && col <= 6) {
                    return new int[]{row, col};
                } else { // 좌표 내에 있지 않다면
                    System.out.println("잘못된 입력 입니다. 범위 내의 좌표를 숫자로 입력하세요.");
                }
            } else { // 길이가 2개가 아니면
                System.out.println("잘못된 입력 입니다. (행, 열) 형태로 숫자를 입력해주세요.");
            }
        } catch (NumberFormatException e) { // 예외가 발생할 경우 어떻게 대처할지. try 내의 코드에서 예외가 발생하면
            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
        }
        return null;
    }

}
