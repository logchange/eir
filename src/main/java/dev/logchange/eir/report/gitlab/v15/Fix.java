
package dev.logchange.eir.report.gitlab.v15;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id"
})
@Generated("jsonschema2pojo")
public class Fix {

    /**
     * Unique identifier of the vulnerability. This is recommended to be a UUID.
     * (Required)
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Unique identifier of the vulnerability. This is recommended to be a UUID.")
    public String id;
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
