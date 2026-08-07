package com.czo.restaurantes_api.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("CLIENTE")
public class Cliente extends Usuario{

}
