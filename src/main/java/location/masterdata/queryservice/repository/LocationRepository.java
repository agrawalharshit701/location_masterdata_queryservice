package location.masterdata.queryservice.repository;

import location.masterdata.queryservice.repository.model.BdaTypeDTO;
import location.masterdata.queryservice.repository.model.LocationDTO;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public interface LocationRepository extends ReactiveCrudRepository<LocationDTO,String> {

    @Query("SELECT id, name, location_id, status, bda_type, geo_type, valid_to, hsud_name, latitude, port_flag, time_zone, longitude, valid_from, restricted, description, dialing_code, is_maersk_city, olson_timezone, alternate_names, sub_city_parents,utc_offset_minutes, workaround_reason, daylight_saving_end, daylight_saving_time, daylight_saving_start, postal_code_mandatory, dialing_code_description, state_province_mandatory, daylight_saving_shift_minutes FROM city_data.city WHERE id = :id")
    Mono<LocationDTO> findByLocationId(String id);


    @Query("SELECT id, city_id, name, type, bda_type, alternate_codes FROM city_data.bda WHERE city_id = :id")
    Flux<BdaTypeDTO> findBdaTypeByLocationId(String id);
    @Query("SELECT id, name, location_id, status, bda_type, geo_type, valid_to, hsud_name, latitude, port_flag, time_zone, longitude, valid_from, restricted, description, dialing_code, is_maersk_city, olson_timezone, alternate_names, sub_city_parents,utc_offset_minutes, workaround_reason, daylight_saving_end, daylight_saving_time, daylight_saving_start, postal_code_mandatory, dialing_code_description, state_province_mandatory, daylight_saving_shift_minutes FROM city_data.city ")
    Flux<LocationDTO> findAllLocations();


    @Query("SELECT id, name, location_id, status, bda_type, geo_type, valid_to, hsud_name, latitude, port_flag, time_zone, longitude, valid_from, restricted, description, dialing_code, is_maersk_city, olson_timezone, alternate_names, sub_city_parents,utc_offset_minutes, workaround_reason, daylight_saving_end, daylight_saving_time, daylight_saving_start, postal_code_mandatory, dialing_code_description, state_province_mandatory, daylight_saving_shift_minutes FROM city_data.city WHERE name = :name")
    Flux<LocationDTO> findLocationsByName(String name);


}
