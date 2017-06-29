package encryptor.passwordchecker;

public class PasswordChecker {

    public boolean isValid(String password) {


        if(!containsUppercase(password)) {
            return false;
        } else  if (!containsDigit(password)){
            return false;
        } else if (password.length() < 8){
            return false;
        }
        return true;
    }

    private boolean containsUppercase(String password) {
        for(char c : password.toCharArray()) {
            if(Character.isUpperCase(c))
                return true;
        }
        return false;
    }

    private boolean containsDigit(String password) {

        for(char c : password.toCharArray()) {
            if(Character.isDigit(c))
                return true;
        }
        return false;
    }
}
