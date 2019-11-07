package com.codeup.blog.repositories;

import com.codeup.blog.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdRepository extends JpaRepository<Ad, Long> {

    Ad findByTitle(String title);

    @Query("from Ad a where a.id like ?1")
    Ad getAdById(long id);

    @Query("select title from Ad where LENGTH(title) < 10")
    List<String> getAdsOfCertainTitleLength();

    @Query(nativeQuery = true, value = "SELECT title FROM ads WHERE LENGTH(title) < 10")
    List<String> getAdsOfCertainTitleLengthNative();

}
