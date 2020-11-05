package diesel.masapp.orders.domain;

import lombok.Getter;

@Getter
public enum CustomerGroup {

    GROEP("G"),
    BESTMED("B"),
    PRIVAAT("P");

    private String code;

    CustomerGroup(final String code) {
        this.code = code;
    }
}
