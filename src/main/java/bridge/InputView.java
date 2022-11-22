package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            System.out.println("다리의 길이를 입력해주세요.");
            String bridgeSizeString = Console.readLine();
            try {
                int result = Integer.parseInt(bridgeSizeString);
                validateBridgeSize(result);
                return result;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자를 입력하세요");
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String result = Console.readLine();
            try {
                validateMoving(result);
                return result;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private void validateBridgeSize(int bridgeSize) throws IllegalArgumentException {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private void validateMoving(String moving) throws IllegalArgumentException {
        if (!(moving.equals("U") || moving.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U와 D로 나타냅니다.");
        }
    }
}
