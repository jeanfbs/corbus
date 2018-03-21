package br.com.infinity.corbus.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

/**
 * Role.java
 *
 * @author @author Jean Santos <a href="mailto:jeanufu21@gmail.com">jeanufu21@gmail.com</a>
 * @since 2018-03-17
 */

@Entity
@Table(name = "tbl_perfil")
public @Data class Role  implements GrantedAuthority{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "perfil_id")
    private Long id;

    @Column(name = "nome")
    private String name;

    @Override
    public String getAuthority() {
        return "ROLE_" + name;
    }
}
