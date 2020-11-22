package com.dpinc.springbootazureappservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User Repository 
 * @author Dhruvesh
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
