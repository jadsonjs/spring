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
 * TestApplication.java 
 * 5 de mai de 2018
 */
package com.example.jadson.threelayerbackend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.example.jadson.threelayerbackend.model.Player;
import com.example.jadson.threelayerbackend.service.SoccerService;

/**
 * Start the application via command line for tests
 * 
 * @author Jadson Santos - jadsonjs@gmail.com
 * 
 * This code was based on https://dzone.com/articles/spring-boot-jpa-hibernate-oracle
 *
 */
public class TestApplication implements CommandLineRunner{

	@Autowired
	SoccerService soccerService;
	
	public static void main(String[] args) {
		SpringApplication.run(ThreelayerBackendApplication.class, args);
	}
	
	/**
	 * Run spring boot via command line
	 */
	@Override
    public void run(String... arg0) throws Exception {
		
        soccerService.addPlayerToTeam(1, new Player("Xavi Hernandez", "Midfielder", 6));
        
        List<String> players = soccerService.getAllTeamPlayers(1);
        System.out.println("Listing all players");
        for(String player : players){
            System.out.println("player => " + player);
        }
    }
}
