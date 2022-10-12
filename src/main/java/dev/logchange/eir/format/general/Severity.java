package dev.logchange.eir.format.general;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public enum Severity {

    UNKNOWN("Unknown"),
    INFO("Info"),
    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High"),
    CRITICAL("Critical");

    private final String value;

    public static Severity ofName(String name) {
        for(Severity severity: values()){
            if(severity.name().equals(name)){
                return severity;
            }
        }

        log.warn("Could not find severity with name: " + name + " using UNKNOWN instead.");
        return UNKNOWN;
    }

    @Override
    public String toString() {
        return this.value;
    }


}