//package com.company.footballgame.entity;
//
//import com.haulmont.chile.core.annotations.NamePattern;
//import com.haulmont.cuba.core.entity.StandardEntity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
//@Table(name = "FOOTBALLGAME_TEAM")
//@Entity(name = "footballgame_Team")
//@NamePattern("%s|name")
//public class Team extends StandardEntity {
//    private static final long serialVersionUID = 5361580579003361447L;
//
//    @Column(name = "NAME", unique = true)
//    private String name;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}

package com.company.footballgame.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "FOOTBALLGAME_TEAM")
@Entity(name = "footballgame_Team")
@NamePattern("%s|name") // Simplifies search and display operations within the UI
public class Team extends StandardEntity {
    private static final long serialVersionUID = 5361580579003361447L;

    @NotNull // Ensures that the name cannot be null
    @Column(name = "NAME", unique = true)
    private String name;

    // Getters and setters...

    // Existing Team entity code...

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}



