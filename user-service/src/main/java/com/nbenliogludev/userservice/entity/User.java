package com.nbenliogludev.userservice.entity;

import com.nbenliogludev.userservice.entity.common.Auditable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(name = "name", length = 80, nullable = false)
    @Size(min = 2, max = 80, message = "Name must be between 2 and 80 characters")
    private String name;

    @NotNull(message = "Surname is required")
    @Column(name = "surname", length = 80, nullable = false)
    @Size(min = 2, max = 80, message = "Surname must be between 2 and 80 characters")
    private String surname;

    @NotBlank(message = "Email is required")
    @Column(name = "email", length = 100, nullable = false, unique = true)
    @Email(message = "Email is not valid")
    private String email;

    @NotBlank(message = "Password is required")
    @Column(name = "password", length = 80, nullable = false)
    @Size(min = 2, max = 80, message = "Password must be between 2 and 80 characters")
    private String password;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (obj == null || getClass() != obj.getClass()) { return false; }

        User user = (User) obj;

        if (!id.equals(user.id)) { return false; }
        if (!name.equals(user.name)) { return false; }
        if (!surname.equals(user.surname)) { return false; }
        if (!email.equals(user.email)) { return false; }
        if (!password.equals(user.email)) { return false; }
        return email == user.email;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

}
