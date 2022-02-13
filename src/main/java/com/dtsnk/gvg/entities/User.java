package com.dtsnk.gvg.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;
    private String piva;    //TODO: check exactly 11 chars

    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                ", piva='" + piva + '\'' +
                '}';
    }
}