package location.masterdata.queryservice.router;


import location.masterdata.queryservice.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.reactive.function.server.*;


@Configuration
@RequiredArgsConstructor
public class LocationRouter {
    @Bean
    public RouterFunction<ServerResponse> route(LocationService locationHandler) {
        return RouterFunctions.route()
                .GET("/getAllLocations", locationHandler::getAllLocations)
                .GET("/getLocationById/{id}", locationHandler::getLocationDetails)
                .GET("/getLocationByName/{name}", locationHandler::getByLocationName)
                .GET("/getBdaTypeById/{id}", locationHandler::getBdaTypeById)
                .build();
    }

}
