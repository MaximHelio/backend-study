package com.example.demo.presentation.dto;

import com.example.demo.domain.Owner;
import lombok.Getter;

@Getter
// Getter annotation 추가를 해야 노란색 경고 사라짐
// Jackson lib. 사용 시 getter annotation 추가 되어 있어야 함
public class OwnerV1Response {

    private final String address;

    private final String city;

    private final String telephone;

    public OwnerV1Response(Owner owner) {
        this.address = owner.getAddress();
        this.city = owner.getCity();
        this.telephone = owner.getTelephone();
    }
}
