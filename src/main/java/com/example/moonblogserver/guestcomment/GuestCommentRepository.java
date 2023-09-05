package com.example.moonblogserver.guestcomment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestCommentRepository extends JpaRepository<GuestComment, Long> {
}
