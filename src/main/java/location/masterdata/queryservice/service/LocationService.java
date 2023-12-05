package location.masterdata.queryservice.service;

import location.masterdata.queryservice.domain.Bda;
import location.masterdata.queryservice.domain.RequestLocation;
import location.masterdata.queryservice.repository.model.BdaTypeDTO;
import location.masterdata.queryservice.repository.model.LocationDTO;
import location.masterdata.queryservice.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class LocationService {
    private final LocationRepository locationRepository;

    public Mono<ServerResponse> getLocationDetails(ServerRequest request) {
        String id = request.pathVariable("id");
        Flux<BdaTypeDTO> bdaTypeFlux = locationRepository.findBdaTypeByLocationId(id);
        Mono<LocationDTO> locationMono = locationRepository.findByLocationId(id);

     /*   Flux<Bda> bda = bdaTypeFlux
                .doOnNext(bdaTypeDTO -> System.out.println("Printing BDA DETAILS :" + bdaTypeDTO.getType()))
                .map(bdaTypeDTO -> Bda
                    .builder()
                    .type(bdaTypeDTO.getBdaType())
                    .bdaType(bdaTypeDTO.getBdaType())
                    .alternateCodes(bdaTypeDTO.getAlternateCodes())
                    .name(bdaTypeDTO.getName())
                    .build());
        bda.subscribe();

        Mono<RequestLocation> locationDTOMono = locationMono.flatMap(
                locationDTO -> {
                    RequestLocation requestLocation = RequestLocation.builder()
                            .name(locationDTO.getName())
                            .locationId(locationDTO.getLocationId())
                            .bdaType(locationDTO.getBdaType())
                            .daylightSavingEnd(locationDTO.getDaylightSavingEnd())
                            .daylightSavingShiftMinutes(locationDTO.getDaylightSavingShiftMinutes())
                            .daylightSavingStart(locationDTO.getDaylightSavingStart())
                            .description(locationDTO.getDescription())
                            .dialingCode(locationDTO.getDialingCode())
                            .bdaLocations(bda)
                            .build();
                    return Mono.just(requestLocation); // Return the Mono containing the RequestLocation
                });
 */

        return locationMono.flatMap(location ->
                ServerResponse.status(HttpStatus.ACCEPTED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(location))
                .switchIfEmpty(ServerResponse.noContent().build());

    }
    public Mono<ServerResponse> getAllLocations(ServerRequest request) {
        log.info("request is : {}",request);
        Flux<LocationDTO> locationFlux = locationRepository.findAllLocations();
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(locationFlux, LocationDTO.class);
    }
    public Mono<ServerResponse> getByLocationName(ServerRequest request){
        log.info("Entered into getByLocationName method");
        String namePathVariable = request.pathVariable("name");
        Flux<LocationDTO> locationFlux = locationRepository.findLocationsByName(namePathVariable);

        return locationFlux
                .doOnNext(location -> System.out.println("Print location ID:" + location.getLocationId()))
                .collectList()
                .flatMap(locations -> ServerResponse.status(!locations.isEmpty() ? HttpStatus.OK : HttpStatus.NO_CONTENT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(locations))
                .switchIfEmpty(ServerResponse.noContent().build());
    }

    public Mono<ServerResponse> getBdaTypeById(ServerRequest request) {
        String id = request.pathVariable("id");
        Flux<BdaTypeDTO> bdaTypeFlux=locationRepository.findBdaTypeByLocationId(id);

        bdaTypeFlux
                .doOnNext(bdaTypeDTO -> System.out.println("Before Map: " + bdaTypeDTO.getType()))
                .map(bdaTypeDTO -> Bda.builder().type(bdaTypeDTO.getBdaType()).build())
                .doOnNext(bdaItem -> System.out.println("After Map: " + bdaItem))
                .doOnError(error -> System.err.println("Error in Bda processing: " + error));
        return bdaTypeFlux
                .collectList()
                .flatMap(bdaType ->
                ServerResponse.status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(bdaType)
                        .switchIfEmpty(ServerResponse.noContent().build()));

    }
}
