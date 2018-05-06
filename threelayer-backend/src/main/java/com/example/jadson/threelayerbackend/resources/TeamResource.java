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
 * TeamResource.java 
 * 5 de mai de 2018
 */
package com.example.jadson.threelayerbackend.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jadson.threelayerbackend.model.Player;
import com.example.jadson.threelayerbackend.model.Team;
import com.example.jadson.threelayerbackend.service.SoccerService;

/**
 * @author Jadson Santos - jadsonjs@gmail.com
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200") // allow access or application form other adresses
public class TeamResource {

	@Autowired
	SoccerService soccerService;
	
	@GetMapping("/teams")
	public List<Team> listar() {
		return soccerService.getAllTeams();
	}
	
	/**
	 * @PathVariable = variable pass as a part of the path of the URL
	 * 
	 * @RequestBody = convert the body of the post to item object
	 * 
	 * @Valid = valid information annotated with @NotEmpty
	 * 
	 * @param item
	 * @return
	 */
	@PostMapping(path="/team/{id}/player", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Player adicionar(@PathVariable("id") Long teamId, @RequestBody @Valid Player player) {
		return soccerService.addPlayerToTeam(teamId, player);
	}
	
	
	
}
