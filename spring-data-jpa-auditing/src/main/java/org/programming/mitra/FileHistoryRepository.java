package org.programming.mitra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface FileHistoryRepository extends JpaRepository<FileHistory, Integer> {
}