package views;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/auth/login")
public class PageLogin extends PageObject {

    public static Target TXTUSER = Target.the("Nombre de usuario").located(By.id("email"));
    public static Target TXTPASS = Target.the("Clave de usuario").located(By.id("password"));
    public static Target USERNAME = Target.the("Alias de usuario").located(By.id("user-name"));

    public static Target LOGIN = Target.the("Login").located(By.cssSelector(".is-small > .is-hidden-tablet-only"));
    public static Target OPTION_MENU = Target.the("Opcion de menu").located(By.id("user-container"));
    public static Target ACTION_LOGIN = Target.the("Iniciar sesion").located(By.cssSelector(".has-primary"));
    public static Target LOGOUT = Target.the("Cerrar sesion").located(By.linkText("Cerrar sesión"));


}
