package com.sipi.webstore.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/// \brief Класс описывающий пользователя в системе
/// Класс который используется как модель для работы с данными всех пользователей,
//          описывает поля пользователя в БД и связывает класс с таблица в БД
@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users implements UserDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; /// Поле илентификатор пользователя в БД

    @Column(name = "name")
    private String name; /// Поле имя пользователя в БД

    @Column(name = "login")
    private  String login; /// Поле почта пользователя в БД
    @Column(name = "phone")
    private String phone; /// Поле телефон пользователя в БД
    @Column(name = "password")
    private String password; /// Поле пароль пользователя в БД

    @Enumerated(EnumType.STRING)
    private Role role;

    public Users(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
