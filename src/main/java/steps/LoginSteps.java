package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.aliaValue;
import tasks.Login;
import views.PageLogin;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static util.WebDriverSupplier.getDriver;
import static util.WebDriverSupplier.quitDriver;

public class LoginSteps {

    private Actor actor;

    @Before
    public void setTheStage() {

        OnStage.setTheStage(new OnlineCast());
        actor = theActorCalled("Fernando").can(BrowseTheWeb.with(getDriver()));
    }

    @After
    public void afterStep() {
        quitDriver();
    }

    @Dado("^un usuario que accede a la pagina principal de la voz del interior$")
    public void un_usuario_que_accede_a_la_pagina_principal_de_la_voz_del_interior() {
        actor.attemptsTo(Open.browserOn().the(PageLogin.class));
    }

    @Cuando("^accede a iniciar session con su usuario \"([^\"]*)\" y clave \"([^\"]*)\"$")
    public void accede_a_iniciar_session_con_su_usuario_y_clave(String user, String pass) {
        actor.attemptsTo(Login.loginWith(user, pass));
    }

    @Entonces("^inicia session y visualiza su alias \"([^\"]*)\" en la pagina principal$")
    public void inicia_session_y_visualiza_su_alias_en_la_pagina_principal(String name) {
        actor.should(seeThat(aliaValue.getAlia(name)));
    }
}
