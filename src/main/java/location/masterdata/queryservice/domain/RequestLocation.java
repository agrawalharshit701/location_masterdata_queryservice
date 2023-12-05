package location.masterdata.queryservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import reactor.core.publisher.Flux;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestLocation {
  private List<Bda> bdas;
  private String name;
  private String locationId;
  private String status;
  private String bdaType;
  private Country country;
  private String geoType;
  private List<Parent> parents;
  private String validTo;
  private String hsudName;
  private String latitude;
  private boolean portFlag;
  private String timeZone;
  private String longitude;
  private String validFrom;
  private String restricted;
  private String description;
  private String dialingCode;
  private Flux<Bda> bdaLocations;
  private boolean isMaerskCity;
  private String olsonTimezone;
  private List<AlternateCode> alternateCodes;
  private List<AlternateName> alternateNames;
  private List<String> subCityParents;
  private Integer utcOffsetMinutes;
  private String workaroundReason;
  private String daylightSavingEnd;
  private String daylightSavingTime;
  private String daylightSavingStart;
  private Boolean postalCodeMandatory;
  private String dialingCodeDescription;
  private Boolean stateProvinceMandatory;
  private Integer daylightSavingShiftMinutes;
}
