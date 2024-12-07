package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.validator.CommonValidator;

public class InputView {
    private final CommonValidator commonInputValidator;

    public InputView() {
        commonInputValidator = new CommonValidator();
    }

    public String getMonthAndWeek() {
        System.out.println("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        return getInput();
    }

    public String getWeekdaysOnCall() {
        System.out.println("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        return getInput();
    }

    public String getWeekendOnCall() {
        System.out.println("주말 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        return getInput();
    }
    private String getInput() {
        String input = Console.readLine();
        commonInputValidator.validateEmpty(input);
        return input;
    }
}
