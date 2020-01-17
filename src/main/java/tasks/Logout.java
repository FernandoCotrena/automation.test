package tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static views.PageLogin.LOGOUT;
import static views.PageLogin.OPTION_MENU;

public class Logout implements Task {


    public static Logout logout (){
        return Instrumented.instanceOf(Logout.class).newInstance();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(OPTION_MENU),
                Click.on(LOGOUT));
    }
}
