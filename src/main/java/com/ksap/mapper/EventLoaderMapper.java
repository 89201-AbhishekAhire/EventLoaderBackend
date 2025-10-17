package com.ksap.mapper;

import com.ksap.entity.EventLoader;
import com.ksap.dto.EventLoaderDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventLoaderMapper {

    public EventLoaderDTO toDto(EventLoader eventLoader) {
        EventLoaderDTO dto = new EventLoaderDTO();
        dto.setSHIPMENT_ID(eventLoader.getSHIPMENT_ID());
        dto.setEVENT_DATE(eventLoader.getEVENT_DATE());
        dto.setSTOP_SEQ(eventLoader.getSTOP_SEQ());
        dto.setSTATUS_CODE(eventLoader.getStatusCode());
        dto.setREMARKS(eventLoader.getREMARKS());
        dto.setSERVPROV_ALIAS_VALUE(eventLoader.getSERVPROV_ALIAS_VALUE());
        dto.setEditing(eventLoader.getEditing());
        return dto;
    }

    public List<EventLoaderDTO> toDtoList(List<EventLoader> eventLoaders) {
        return eventLoaders.stream()
                           .map(this::toDto)
                           .collect(Collectors.toList());
    }

    public EventLoader toEntity(EventLoaderDTO dto) {
        EventLoader eventLoader = new EventLoader();
        eventLoader.setSHIPMENT_ID(dto.getSHIPMENT_ID());
        eventLoader.setEVENT_DATE(dto.getEVENT_DATE());
        eventLoader.setSTOP_SEQ(dto.getSTOP_SEQ());
        eventLoader.setStatusCode(dto.getSTATUS_CODE());
        eventLoader.setREMARKS(dto.getREMARKS());
        eventLoader.setSERVPROV_ALIAS_VALUE(dto.getSERVPROV_ALIAS_VALUE());
        eventLoader.setEditing(dto.isEditing());
        return eventLoader;
    }
}