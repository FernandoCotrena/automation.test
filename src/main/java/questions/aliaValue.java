package questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import views.PageLogin;

public class aliaValue {

    public static Question<Boolean> getAlia(String alias) {
        return actor -> Text.of(PageLogin.USERNAME).viewedBy(actor).asString().equalsIgnoreCase(alias);
    }

}
