package testngproject.selectors;

public class Selectors {
    private Selectors() {
    }

    // Elements
    public static final String LOGIN_BUTTON = "login-button";
    public static final String ERROR_MESSAGE = "[data-test=\"error\"]";
    public static final String USERNAME_FIELD = "[data-test=\"username\"]";
    public static final String PASSWORD_FIELD = "[data-test=\"password\"]";

    // User credentials
    public static final String DUMMY_USERNAME = "dummy_username";
    public static final String DUMMY_PASSWORD = "dummy_password";
    public static final String STANDARD_USER = "standard_user";
    public static final String LOCKED_OUT_USER = "locked_out_user";
    public static final String PPROBLEM_USER = "problem_user";
    public static final String PERFORMANCE_GLITCH_USER = "performance_glitch_user";
    public static final String CORRECT_PASSWORD = "secret_sauce";

    // Error messages
    public static final String ERROR_MESSAGE_WHEN_CLICKED_ON_THE_LOGIN_BUTTON_WITH_EMPTY_FORM = "Epic sadface: Username is required";
    public static final String ERROR_MESSAGE_WHEN_CLICKED_ON_THE_LOGIN_BUTTON_WITH_EMPTY_USERNAME_FIELD = "Epic sadface: Username is required";
    public static final String ERROR_MESSAGE_WHEN_CLICKED_ON_THE_LOGIN_BUTTON_WITH_EMPTY_PASSWORD_FIELD = "Epic sadface: Password is required";
    public static final String ERROR_MESSAGE_FOR_WRONG_CREDENTIALS = "Epic sadface: Username and password do not match any user in this service";
}
