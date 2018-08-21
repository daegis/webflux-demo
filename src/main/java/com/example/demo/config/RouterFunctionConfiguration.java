package com.example.demo.config;

import com.example.demo.domain.User;
import com.example.demo.vo.GeneralResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Using IntelliJ IDEA.
 *
 * @author XIANYINGDA at 8/20/2018 2:49 PM
 */
@SuppressWarnings("ALL")
@Configuration
public class RouterFunctionConfiguration {

    @Bean
    public RouterFunction<ServerResponse> userFindAll() {
        List<User> userList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(i);
            user.setName(UUID.randomUUID().toString().substring(0, 8));
            userList.add(user);
        }
        return RouterFunctions.route(RequestPredicates.GET("/user/find/all"),
                request -> {
                    Flux<User> userFlux = Flux.fromIterable(userList);
                    return ServerResponse.ok().body(userFlux, User.class);
                });
    }

    @Bean
    public RouterFunction<ServerResponse> userFindMore() {
        List<User> userList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(i);
            user.setName(UUID.randomUUID().toString().substring(0, 8));
            userList.add(user);
        }
        return RouterFunctions.route(RequestPredicates.POST("/user/find/more"),
                request -> {
                    Optional<String> message = request.queryParam("message");
                    if(message.isPresent()){
                        System.out.println(message.get());
                    }
                    GeneralResponse response = new GeneralResponse();
                    response.setNow(LocalDateTime.now());
                    response.setUserList(userList);
                    Mono<GeneralResponse> responseMono = Mono.just(response);
                    return ServerResponse.ok().body(responseMono, GeneralResponse.class);
                });
    }
}
