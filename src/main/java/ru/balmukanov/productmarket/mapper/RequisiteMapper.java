package ru.balmukanov.productmarket.mapper;

import org.springframework.stereotype.Component;
import ru.balmukanov.productmarket.dto.RequisiteDto;
import ru.balmukanov.productmarket.entity.Requisite;

@Component
public class RequisiteMapper {
    public RequisiteDto toDto(Requisite requisite) {
        return new RequisiteDto(
                requisite.getId(),
                requisite.getBIC(),
                requisite.getBankName(),
                requisite.getINN(),
                requisite.getKPP(),
                requisite.getRecipientAccount(),
                requisite.getRecipient(),
                requisite.getCorrespondentAccount(),
                requisite.getProduct().getId()
        );
    }
}
