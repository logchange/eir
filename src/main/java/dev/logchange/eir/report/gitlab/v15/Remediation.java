
package dev.logchange.eir.report.gitlab.v15;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fixes",
    "summary",
    "diff"
})
@Generated("jsonschema2pojo")
public class Remediation {

    /**
     * An array of strings that represent references to vulnerabilities fixed by this remediation.
     * (Required)
     * 
     */
    @JsonProperty("fixes")
    @JsonPropertyDescription("An array of strings that represent references to vulnerabilities fixed by this remediation.")
    public List<Fix> fixes = null;
    /**
     * An overview of how the vulnerabilities were fixed.
     * (Required)
     * 
     */
    @JsonProperty("summary")
    @JsonPropertyDescription("An overview of how the vulnerabilities were fixed.")
    public String summary;
    /**
     * A base64-encoded remediation code diff, compatible with git apply.
     * (Required)
     * 
     */
    @JsonProperty("diff")
    @JsonPropertyDescription("A base64-encoded remediation code diff, compatible with git apply.")
    public String diff;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
