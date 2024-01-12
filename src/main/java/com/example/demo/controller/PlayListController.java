package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;
import com.example.demo.services.PlaylistService;
import com.example.demo.services.SongService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PlayListController {
	@Autowired
	SongService songservice;
	@Autowired
	PlaylistService playlistService;
	@GetMapping("/createPlaylist")
	public String createPlayList(Model model) {
		List<Song> songList=songservice.fetchAllSongs();

		model.addAttribute("songs", songList);
		return "createPlaylist";
	}
	@PostMapping("/addPlayList")
	public String addPlayList(@ModelAttribute Playlist playlist) {
		playlistService.addPlayList(playlist);
		List<Song> songList=songservice.fetchAllSongs();
		for(Song s:songList) {
			s.getPlaylist().add(playlist);
			songservice.updateSong(s);
		}
		
		return "adminHome";
	}
	@GetMapping("viewPlaylists")
	public String viewPlaylists(Model model) {
		List<Playlist> allplaylists=playlistService.fetchAllPlayList();
		model.addAttribute("allplaylists", allplaylists);
		return "diaplayAllPlayLists" ;
	}
	
}
