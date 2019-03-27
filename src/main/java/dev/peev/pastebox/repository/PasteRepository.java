package dev.peev.pastebox.repository;

import dev.peev.pastebox.domain.entities.Paste;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasteRepository extends JpaRepository<Paste, String> {
}
