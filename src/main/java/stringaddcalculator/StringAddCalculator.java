package stringaddcalculator;

import stringaddcalculator.util.StringUtil;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DELIMITER = ",|:";
    private static final String CUSTOM_PATTERN = "//(.)\n(.*)";

    public static int splitAndSum(String expression) {
        if (StringUtil.isBlank(expression)) {
            return 0;
        }

        Matcher matchResult = Pattern.compile(CUSTOM_PATTERN).matcher(expression);
        if (matchResult.find()) {
            String customDelimiter = matchResult.group(1);
            String[] tokens = matchResult.group(2).split(customDelimiter);
            return sum(tokens);
        }

        return sum(expression.split(DELIMITER));
    }

    private static int sum(String[] splitExpression) {
        return Arrays.stream(splitExpression)
                .mapToInt(StringAddCalculator::toInt)
                .reduce(0, (total, number) -> total + number)
                ;
    }

    private static int toInt(String str) {
        try {
            int result = Integer.parseInt(str);
            if (result < 0) {
                throw new IllegalArgumentException("0 또는 자연수만 입력하세요.");
            }
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("0 또는 자연수만 입력하세요.");
        }
    }

}