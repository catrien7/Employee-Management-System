public class Login {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";

    public boolean authenticate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }
        return username.equals(USERNAME)
                && password.equals(PASSWORD);
    }
}