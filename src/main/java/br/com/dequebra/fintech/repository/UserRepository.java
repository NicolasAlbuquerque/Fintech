package br.com.dequebra.fintech.repository;

import br.com.dequebra.fintech.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
