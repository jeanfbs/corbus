package br.com.infinity.corbus.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * User.java
 *
 * @author @author Jean Santos <a href="mailto:jeanufu21@gmail.com">jeanufu21@gmail.com</a>
 * @since 2018-03-17
 */
@Entity
@Table(name = "tbl_usuario")
public @Data class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usuario_id")
    private Long id;

    private String username;

    private String password;

    @Transient
    private String passwordConfirm;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tbl_perfil_usuario", joinColumns = @JoinColumn(name = "perfil_id"), inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private Set<Role> roles;

}
