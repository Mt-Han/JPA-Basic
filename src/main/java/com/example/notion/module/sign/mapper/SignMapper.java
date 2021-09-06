package com.example.notion.module.sign.mapper;

import com.example.notion.module.sign.dto.SignResponse;
import com.example.notion.module.sign.entity.Sign;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SignMapper {
    SignMapper SIGN_MAPPER = Mappers.getMapper(SignMapper.class);

    SignResponse toSignResponse(Sign sign);

    List<SignResponse> toSignResponseList(List<Sign> signs);

}
