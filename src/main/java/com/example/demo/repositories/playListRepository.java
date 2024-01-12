package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Playlist;

public interface playListRepository  extends JpaRepository<Playlist, Integer>{

}
