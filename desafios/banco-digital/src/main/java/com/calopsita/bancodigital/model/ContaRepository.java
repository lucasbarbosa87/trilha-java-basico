package com.calopsita.bancodigital.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends CrudRepository<Conta, Long> {
}
