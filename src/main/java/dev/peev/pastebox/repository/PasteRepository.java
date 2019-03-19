package dev.peev.pastebox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.peev.pastebox.domain.entities.Paste;

@Repository
public interface PasteRepository extends JpaRepository<Paste, String> {
}
