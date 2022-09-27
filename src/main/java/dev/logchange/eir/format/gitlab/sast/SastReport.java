
package dev.logchange.eir.format.gitlab.sast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Report format for GitLab SAST
 * <p>
 * This schema provides the report format for Static Application Security Testing analyzers (https://docs.gitlab.com/ee/user/application_security/sast).
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "scan",
    "schema",
    "version",
    "vulnerabilities",
    "remediations"
})
@Generated("jsonschema2pojo")
public class SastReport {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("scan")
    public Scan scan;
    /**
     * URI pointing to the validating security report schema.
     * 
     */
    @JsonProperty("schema")
    @JsonPropertyDescription("URI pointing to the validating security report schema.")
    public String schema;
    /**
     * The version of the schema to which the JSON report conforms.
     * (Required)
     * 
     */
    @JsonProperty("version")
    @JsonPropertyDescription("The version of the schema to which the JSON report conforms.")
    public String version;
    /**
     * Array of vulnerability objects.
     * (Required)
     * 
     */
    @JsonProperty("vulnerabilities")
    @JsonPropertyDescription("Array of vulnerability objects.")
    public List<Vulnerability> vulnerabilities = null;
    /**
     * An array of objects containing information on available remediations, along with patch diffs to apply.
     * 
     */
    @JsonProperty("remediations")
    @JsonPropertyDescription("An array of objects containing information on available remediations, along with patch diffs to apply.")
    public List<Remediation> remediations = null;
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
