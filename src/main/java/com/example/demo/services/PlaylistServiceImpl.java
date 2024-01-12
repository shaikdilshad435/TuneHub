package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Playlist;
import com.example.demo.repositories.playListRepository;
@Service
public class PlaylistServiceImpl implements PlaylistService {
	@Autowired
	playListRepository playListRepository;
	@Override
	public void addPlayList(Playlist playlist) {
	playListRepository.save(playlist);
	}
	@Override
	public List<Playlist> fetchAllPlayList() {
		return playListRepository.findAll();
	}

}
