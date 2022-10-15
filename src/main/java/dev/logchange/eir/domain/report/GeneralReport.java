package dev.logchange.eir.domain.report;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class GeneralReport {

    private final List<Vulnerability> vulnerabilities;

}
