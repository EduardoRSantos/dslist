package com.devsuperior.dslist.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameListServices;
import com.devsuperior.dslist.services.GameServices;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameServices gameService;
    @Autowired
    private GameListServices gameListServices;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListServices.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByID(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }
}
