package pages;

import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.NotImplementedException;

public abstract class BasePage {
    /**
     * Возвращает уникальный элемент, по которому можно идентифицировать PageObject.
     *
     * @return SelenideElement, найденный по заданному локатору.
     */
    protected abstract SelenideElement getMainElement();

    /**
     * Получение URL страницы. Должен быть переопределен в каждом классе, описывающем конкретную страницу приложения.
     *
     * @return URL страницы.
     */
    protected String getPageUrl() {
        throw new NotImplementedException();
    }


}
