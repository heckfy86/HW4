package pagebox.components;

import org.junit.jupiter.api.Tag;

import static com.codeborne.selenide.Selenide.$;

@Tag("1")
public class CalendarComnponent {

    public void setDate(String year, String month, String day) {

        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0"+day).click();
    }
}
