package com.learn.springboot.springbootprojectone.repositories;

import com.learn.springboot.springbootprojectone.domain.*;
import org.springframework.data.repository.*;

public interface AuthorRepository extends CrudRepository<Author,Long> {
    /*We are just providing the interface and Spring data JPA is going to implement all those methods for us to work with*/
}
