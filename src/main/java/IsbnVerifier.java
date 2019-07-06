class IsbnVerifier {

    boolean isValid(String stringToVerify) {

        String stringHiphenRemoved = stringToVerify.replaceAll("-", "");
        char[] digits = stringHiphenRemoved.toCharArray();

        int number, isbnConversionMultiplier = 10;
        int isbnNumber = 0;

        if (digits.length == 0 || digits.length != isbnConversionMultiplier) {
            return false;
        }

        for (int i = 0; i < digits.length; i++) {


            if (digits[i] == 'X' && i == digits.length - 1) {
                number = 10;
            } else if (digits[i] >= 'A' && digits[i] <= 'Z') {
                return false;
            } else {
                number = Integer.parseInt("" + digits[i]);
            }

            isbnNumber += number * isbnConversionMultiplier--;


        }
        return (isbnNumber % 11 == 0);
    }

}
