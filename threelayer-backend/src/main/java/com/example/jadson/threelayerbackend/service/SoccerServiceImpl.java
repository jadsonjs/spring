/*
 * Copyright (c) 2017 Jadson Santos
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * SoccerServiceImpl.java 
 * 5 de mai de 2018
 */
package com.example.jadson.threelayerbackend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jadson.threelayerbackend.model.Player;
import com.example.jadson.threelayerbackend.model.Team;
import com.example.jadson.threelayerbackend.repository.PlayerRepository;
import com.example.jadson.threelayerbackend.repository.TeamRepository;

/**
 * @author Jadson Santos - jadsonjs@gmail.com
 * This code was based on https://dzone.com/articles/spring-boot-jpa-hibernate-oracle
 */
@Service
public class SoccerServiceImpl implements SoccerService {

	@Autowired
    private PlayerRepository playerRepository;
   
	@Autowired
    private TeamRepository teamRepository;
    
    public List<String> getAllTeamPlayers(long teamId) {
        List<String> result = new ArrayList<String>();
        
        List<Player> players = playerRepository.findByTeamId(teamId);
        for (Player player : players) {
            result.add(player.getName());
        }
        return result;
    }
    
    public Player addPlayerToTeam(long teamId, Player newPlayer) {
        Optional<Team> team = teamRepository.findById(teamId);
        newPlayer.setTeam(team.get());
        playerRepository.save(newPlayer);
        return newPlayer;
    }

	/** 
     * Return all teams of the league
 	 * @see com.example.jadson.threelayerbackend.service.SoccerService#findAll()
	 */
	@Override
	public List<Team> getAllTeams() {
		return teamRepository.findAll();
	}
	
}
