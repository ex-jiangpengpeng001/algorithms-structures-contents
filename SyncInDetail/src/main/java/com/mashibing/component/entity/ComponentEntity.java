package com.mashibing.component.entity;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
public class ComponentEntity implements Serializable {
    private String id;
    private String name;
    private String type;
    private String supId;

}
