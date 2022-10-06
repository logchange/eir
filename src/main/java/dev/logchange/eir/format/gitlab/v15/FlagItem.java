
package dev.logchange.eir.format.gitlab.v15;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Informational flags identified and assigned to a vulnerability.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "origin",
    "description"
})
@Generated("jsonschema2pojo")
public class FlagItem {

    /**
     * Result of the scan.
     * (Required)
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Result of the scan.")
    public Type type;
    /**
     * Tool that issued the flag.
     * (Required)
     * 
     */
    @JsonProperty("origin")
    @JsonPropertyDescription("Tool that issued the flag.")
    public String origin;
    /**
     * What the flag is about.
     * (Required)
     * 
     */
    @JsonProperty("description")
    @JsonPropertyDescription("What the flag is about.")
    public String description;
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


    /**
     * Result of the scan.
     * 
     */
    @Generated("jsonschema2pojo")
    public enum Type {

        FLAGGED_AS_LIKELY_FALSE_POSITIVE("flagged-as-likely-false-positive");
        private final String value;
        private final static Map<String, Type> CONSTANTS = new HashMap<String, Type>();

        static {
            for (Type c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Type(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static Type fromValue(String value) {
            Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
