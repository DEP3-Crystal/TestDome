package Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInput {
    static List<Object> cha = new ArrayList();

    public static class TextInput {
        void add(char c){
            cha.add(c);
        }

        String getValue() {
            return listToString(cha);
        }
    }

    public static class NumericInput extends TextInput {
        @Override
        public void add(final char c) {
            if (Character.isDigit(c))
                super.add(c);
        }
    }
    public static String listToString(List<Object> list) {
        StringBuilder sb = new StringBuilder();

        for (Object object : list) {
            if (object != null) {
                if (object.getClass().isArray()) {
                    sb.append(Arrays.toString((Object[]) object));
                } else {
                    sb.append(object.toString());
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}
