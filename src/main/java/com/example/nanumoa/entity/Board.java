package com.example.nanumoa.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    private String content;

    @ManyToOne
    @JoinColumn( name = "user_info_id", referencedColumnName = "id")
    private UserInfo userInfo;

//    private String filename;
//    private String filepath;

}
