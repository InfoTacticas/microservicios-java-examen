package com.newhorizons.takeitnow.users.infrastructure.pas;

import com.newhorizons.takeitnow.users.domain.entity.UserApplication;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "users")
public interface IUserRepository extends PagingAndSortingRepository<UserApplication, Long> {

    UserApplication findByUsername(String username);

    @Query(value = "select u.* from users u where u.username=?1 and u.password=?2", nativeQuery = true)
    UserApplication signInApplication(String username, String password);
}
