package com.challenge.pokemon.webservice;

import com.challenge.pokemon.entity.PokemonAPIQueryLog;
import com.challenge.pokemon.mapper.PokemonResponseMapper;
import com.challenge.pokemon.model.EnumMethodWS;
import com.challenge.pokemon.model.PokemonResponseModel;
import com.challenge.pokemon.pokedex.*;
import com.challenge.pokemon.service.PokemonAPIClient;
import com.challenge.pokemon.service.PokemonAPIQueryLogService;
import com.challenge.pokemon.utils.PokemonWSException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.time.LocalDate;

@Endpoint
@Log4j2
public class PokemonEndpoint {

    private final String NAMESPACE_URI = "http://webservice.pokemon.challenge.com/pokedex";
    private final String ERROR_API = "Error with API Response";
    private final String CLIENT_IP = "clientIp";

    private PokemonAPIClient pokemonAPIClient;
    private ObjectMapper objectMapper;
    private PokemonAPIQueryLogService pokemonAPIQueryLogService;

    private PokemonResponseMapper pokemonResponseMapper;

    public PokemonEndpoint(PokemonAPIClient pokemonAPIClient,
                           ObjectMapper objectMapper,
                           PokemonAPIQueryLogService pokemonAPIQueryLogService,
                           PokemonResponseMapper pokemonResponseMapper) {
        this.pokemonAPIClient = pokemonAPIClient;
        this.objectMapper = objectMapper;
        this.pokemonAPIQueryLogService = pokemonAPIQueryLogService;
        this.pokemonResponseMapper = pokemonResponseMapper;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAbilitiesRequest")
    @ResponsePayload
    public GetAbilitiesResponse getAbilities(@RequestPayload GetAbilitiesRequest getAbilitiesRequest, MessageContext messageContext) throws PokemonWSException {
        try {
            PokemonResponse responseAPI = getDataPokemon(getAbilitiesRequest.getPokemonRequest());
            registryLogQuery(messageContext, EnumMethodWS.ABILITIES);

            GetAbilitiesResponse getAbilitiesResponse = new GetAbilitiesResponse();
            PokemonResponse pokemonResponse = new PokemonResponse();
            pokemonResponse.getAbilities().addAll(responseAPI.getAbilities());
            getAbilitiesResponse.setPokemonResponse(pokemonResponse);
            return getAbilitiesResponse;
        } catch (JsonProcessingException e) {
            log.error("Error in getAbilities: {}", e.getMessage());
            throw new PokemonWSException(ERROR_API);
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBaseExperienceRequest")
    @ResponsePayload
    public GetBaseExperienceResponse getBaseExperience(
            @RequestPayload GetBaseExperienceRequest getBaseExperienceRequest, MessageContext messageContext) throws PokemonWSException {
        try {
            PokemonResponse responseAPI = getDataPokemon(getBaseExperienceRequest.getPokemonRequest());
            registryLogQuery(messageContext, EnumMethodWS.BASE_EXPERIENCE);

            GetBaseExperienceResponse getBaseExperienceResponse = new GetBaseExperienceResponse();
            PokemonResponse pokemonResponse = new PokemonResponse();
            pokemonResponse.setBaseExperience(responseAPI.getBaseExperience());
            getBaseExperienceResponse.setPokemonResponse(pokemonResponse);
            return getBaseExperienceResponse;
        } catch (JsonProcessingException e) {
            log.error("Error in getBaseExperience: {}", e.getMessage());
            throw new PokemonWSException(ERROR_API);
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHeldItemsRequest")
    @ResponsePayload
    public GetHeldItemsResponse getHeldItems(
            @RequestPayload GetHeldItemsRequest getHeldItemsRequest, MessageContext messageContext) throws PokemonWSException {
        try {
            PokemonResponse responseAPI = getDataPokemon(getHeldItemsRequest.getPokemonRequest());
            registryLogQuery(messageContext, EnumMethodWS.HELD_ITEMS);

            GetHeldItemsResponse getBaseExperienceResponse = new GetHeldItemsResponse();
            PokemonResponse pokemonResponse = new PokemonResponse();
            pokemonResponse.getHeldItems().addAll(responseAPI.getHeldItems());
            getBaseExperienceResponse.setPokemonResponse(pokemonResponse);
            return getBaseExperienceResponse;
        } catch (JsonProcessingException e) {
            log.error("Error in getHeldItems: {}", e.getMessage());
            throw new PokemonWSException(ERROR_API);
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIdRequest")
    @ResponsePayload
    public GetIdResponse getId(
            @RequestPayload GetIdRequest getIdRequest, MessageContext messageContext) throws PokemonWSException {
        try {
            PokemonResponse responseAPI = getDataPokemon(getIdRequest.getPokemonRequest());
            registryLogQuery(messageContext, EnumMethodWS.ID);

            GetIdResponse getIdResponse = new GetIdResponse();
            PokemonResponse pokemonResponse = new PokemonResponse();
            pokemonResponse.setId(responseAPI.getId());
            getIdResponse.setPokemonResponse(pokemonResponse);
            return getIdResponse;
        } catch (JsonProcessingException e) {
            log.error("Error in getId: {}", e.getMessage());
            throw new PokemonWSException(ERROR_API);
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getNameRequest")
    @ResponsePayload
    public GetNameResponse getName(
            @RequestPayload GetNameRequest getNameRequest, MessageContext messageContext) throws PokemonWSException {
        try {
            PokemonResponse responseAPI = getDataPokemon(getNameRequest.getPokemonRequest());
            registryLogQuery(messageContext, EnumMethodWS.NAME);

            GetNameResponse getNameResponse = new GetNameResponse();
            PokemonResponse pokemonResponse = new PokemonResponse();
            pokemonResponse.setName(responseAPI.getName());
            getNameResponse.setPokemonResponse(pokemonResponse);
            return getNameResponse;
        } catch (JsonProcessingException e) {
            log.error("Error in getName: {}", e.getMessage());
            throw new PokemonWSException(ERROR_API);
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLocationAreaEncountersRequest")
    @ResponsePayload
    public GetLocationAreaEncountersResponse getLocationAreaEncounters(
            @RequestPayload GetLocationAreaEncountersRequest getLocationAreaEncountersRequest, MessageContext messageContext) throws PokemonWSException {
        try {
            PokemonResponse responseAPI = getDataPokemon(getLocationAreaEncountersRequest.getPokemonRequest());
            registryLogQuery(messageContext, EnumMethodWS.LOCATION_AREA_ENCOUNTERS);

            GetLocationAreaEncountersResponse getLocationAreaEncountersResponse = new GetLocationAreaEncountersResponse();
            PokemonResponse pokemonResponse = new PokemonResponse();
            pokemonResponse.setLocationAreaEncounters(responseAPI.getLocationAreaEncounters());
            getLocationAreaEncountersResponse.setPokemonResponse(pokemonResponse);
            return getLocationAreaEncountersResponse;
        } catch (JsonProcessingException e) {
            log.error("Error in getLocationAreaEncounters: {}", e.getMessage());
            throw new PokemonWSException(ERROR_API);
        }
    }

    private PokemonAPIQueryLog createRegistryToLog(EnumMethodWS methodWS, String clientIp) {
        PokemonAPIQueryLog pokemonAPIQueryLog = new PokemonAPIQueryLog();

        pokemonAPIQueryLog.setMethod(methodWS.name());
        pokemonAPIQueryLog.setRequest(LocalDate.now());
        pokemonAPIQueryLog.setIpOrigin(clientIp);

        return pokemonAPIQueryLog;
    }

    private PokemonResponse getDataPokemon(String pokemon) throws JsonProcessingException {
        String pokemonJson = pokemonAPIClient.getPokemonByName(pokemon);
        PokemonResponseModel pokemonResponseModel = objectMapper.readValue(pokemonJson, PokemonResponseModel.class);
        return pokemonResponseMapper.toEntity(pokemonResponseModel);
    }

    private void registryLogQuery(MessageContext messageContext, EnumMethodWS enumMethodWS) {
        String clientIp = (String) messageContext.getProperty(CLIENT_IP);
        pokemonAPIQueryLogService
                .registryQuery(createRegistryToLog(enumMethodWS, clientIp));
    }

}
