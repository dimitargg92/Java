package Abstraction.telephony;
import Abstraction.Interfaces.Browsable;
import Abstraction.Interfaces.Callable;
import java.util.regex.Matcher;

import java.util.List;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {

    private static final String PHONE_REGEX = "^[0-9]+$";
    private static final String URL_REGEX = "^\\D+$";

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers,List<String>urls){

        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {

//        final Pattern pattern = Pattern.compile(URL_REGEX, Pattern.MULTILINE);

        StringBuilder sb = new StringBuilder();

        for (String url : this.urls) {

            if (url.matches(URL_REGEX)){

                sb.append(String.format("Browsing: %s!",url));
            }else {
                sb.append("Invalid URL!");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public String call() {

//        final Pattern pattern = Pattern.compile(PHONE_REGEX, Pattern.MULTILINE);

        StringBuilder sb = new StringBuilder();

        for (String number : this.numbers) {

            if (number.matches(PHONE_REGEX)) {

                sb.append(String.format("Calling... %s", number));
            } else {
                sb.append("Invalid number!");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

//   -> Optional <-
//    private boolean matchesRegex (String input,Pattern pattern){
//
//        final Matcher matcher = pattern.matcher(input);
//        return matcher.matches();
//    }
}
