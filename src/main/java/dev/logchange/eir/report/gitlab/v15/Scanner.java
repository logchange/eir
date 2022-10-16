
package dev.logchange.eir.report.gitlab.v15;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;


/**
 * Object defining the scanner used to perform the scan.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "url",
    "version",
    "vendor"
})
@Generated("jsonschema2pojo")
public class Scanner {

    /**
     * Unique id that identifies the scanner.
     * (Required)
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Unique id that identifies the scanner.")
    public String id;
    /**
     * A human readable value that identifies the scanner, not required to be unique.
     * (Required)
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("A human readable value that identifies the scanner, not required to be unique.")
    public String name;
    /**
     * A link to more information about the scanner.
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("A link to more information about the scanner.")
    public String url;
    /**
     * The version of the scanner.
     * (Required)
     * 
     */
    @JsonProperty("version")
    @JsonPropertyDescription("The version of the scanner.")
    public String version;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("vendor")
    public Vendor vendor;
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
