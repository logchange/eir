
package dev.logchange.eir.format.gitlab.sast;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "name",
    "url",
    "value"
})
@Generated("jsonschema2pojo")
public class PrimaryIdentifier {

    /**
     * for example, cve, cwe, osvdb, usn, or an analyzer-dependent type such as gemnasium).
     * (Required)
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("for example, cve, cwe, osvdb, usn, or an analyzer-dependent type such as gemnasium).")
    public String type;
    /**
     * Human-readable name of the identifier.
     * (Required)
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Human-readable name of the identifier.")
    public String name;
    /**
     * URL of the identifier's documentation.
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("URL of the identifier's documentation.")
    public String url;
    /**
     * Value of the identifier, for matching purpose.
     * (Required)
     * 
     */
    @JsonProperty("value")
    @JsonPropertyDescription("Value of the identifier, for matching purpose.")
    public String value;
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
