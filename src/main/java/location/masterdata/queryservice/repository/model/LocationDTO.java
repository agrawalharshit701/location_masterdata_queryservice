package location.masterdata.queryservice.repository.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table("city")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class LocationDTO {
    @Id
    @Column("id")
    private String id;

    @Column("name")
    private String name;
    @Column("location_id")
    private String locationId;
    @Column("status")
    private String status;
    @Column("bda_type")
    private String bdaType;
    @Column("geo_type")
    private String geoType;
    @Column("valid_to")
    private LocalDate validTo;
    @Column("hsud_name")
    private String hsudName;
    @Column("latitude")
    private String latitude;
    @Column("port_flag")
    private boolean portFlag;
    @Column("time_zone")
    private String timezone;
    @Column("longitude")
    private String longitude;
    @Column("valid_from")
    private LocalDate validFrom;
    @Column("restricted")
    private String restricted;
    @Column("description")
    private String description;
    @Column("dialing_code")
    private String dialingCode;
    @Column("is_maersk_city")
    private boolean isMaerskCity;
    @Column("olson_timezone")
    private String olsonTimeZone;
    @Column("alternate_names")
    private String alternateNames;
    @Column("sub_city_parents")
    private String subCityParents;

    @Column("utc_offset_minutes")
    private int utcOffsetMinutes;
    @Column("workaround_reason")
    private String workAroundReason;
    @Column("daylight_saving_end")
    private String daylightSavingEnd;
    @Column("daylight_saving_start")
    private String daylightSavingStart;
    @Column("postal_code_mandatory")
    private String postalCodeMandatory;
    @Column("dialing_code_description")
    private String dialingCodeDescription;
    @Column("state_province_mandatory")
    private String stateProvinceMandatory;
    @Column("daylight_saving_shift_minutes")
    private int daylightSavingShiftMinutes;

}