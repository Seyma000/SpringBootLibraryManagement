package dev.seyma.springbootlibrarymanagement.v1.core.config.ModelMapper;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forRequest();
    ModelMapper forResponse();
}