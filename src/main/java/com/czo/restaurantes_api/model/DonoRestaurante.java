package com.czo.restaurantes_api.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("DONO")
public class DonoRestaurante  extends Usuario{

}
