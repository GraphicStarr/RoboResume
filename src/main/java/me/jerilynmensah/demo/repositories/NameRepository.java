package me.jerilynmensah.demo.repositories;

import me.jerilynmensah.demo.models.Name;
import org.springframework.data.repository.CrudRepository;

public interface NameRepository extends CrudRepository <Name, Long> {
}
