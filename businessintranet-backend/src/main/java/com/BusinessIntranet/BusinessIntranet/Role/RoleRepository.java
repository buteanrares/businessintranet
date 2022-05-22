package com.BusinessIntranet.BusinessIntranet.Role;

import java.util.Optional;

import com.BusinessIntranet.BusinessIntranet.Enums.EnumRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(EnumRole name);
}
