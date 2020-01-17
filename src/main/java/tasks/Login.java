package tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static views.PageLogin.*;

public class Login implements Task {
    private String user;
    private String password;

    public Login(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public static Login loginWith(String user, String password) {
        return Instrumented.instanceOf(Login.class).withProperties(user, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Enter.keyValues(user).into(TXTUSER),
                Enter.keyValues(password).into(TXTPASS),
                Click.on(ACTION_LOGIN));
    }
}
