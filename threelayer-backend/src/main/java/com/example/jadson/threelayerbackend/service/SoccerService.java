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
 * SoccerService.java 
 * 5 de mai de 2018
 */
package com.example.jadson.threelayerbackend.service;

import java.util.List;

import com.example.jadson.threelayerbackend.model.Player;
import com.example.jadson.threelayerbackend.model.Team;

/**
 * @author Jadson Santos - jadsonjs@gmail.com
 *
 * This code was based on https://dzone.com/articles/spring-boot-jpa-hibernate-oracle
 */
public interface SoccerService {
	
	public List<Team> getAllTeams();
	
	public List<String> getAllTeamPlayers(long teamId);
	
    public Player addPlayerToTeam(long teamId, Player player);


}
