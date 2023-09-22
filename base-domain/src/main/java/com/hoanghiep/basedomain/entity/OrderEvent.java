package com.hoanghiep.basedomain.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderEvent {

    private String message;

    private String status;

    private Order order;

}
