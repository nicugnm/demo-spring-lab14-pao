package net.pao.laboratorpao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PersonType {
    FIZICA(0, "Fizica"),
    JURIDICA(1, "Juridica");

    private final Integer index;

    private final String name;
}
