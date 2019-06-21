package com.ferreirae.michelle.pokemon;

import org.springframework.data.repository.CrudRepository;

// the most Spring magic
// Spring will actually create a class that implements this interface
// it's magical
// we'll autowire it in
// CrudRepository contains findById, findAll, save, other useful methods
// We can add more methods, and if they match the instance variables of Trainer,
//   Spring knows how to build those methods too.
public interface TrainerRepository extends CrudRepository<Trainer, Long> {
    // Spring: looks at this and says, "OK, trainers have a username, so probably this means 'select * from trainer where username = [username param]'"
    // thanks Spring
    public Trainer findByUsername(String username);
}
