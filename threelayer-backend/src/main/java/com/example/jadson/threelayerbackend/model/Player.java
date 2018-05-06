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
 * Player.java 
 * 5 de mai de 2018
 */
package com.example.jadson.threelayerbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;

/**
 * @author Jadson Santos - jadsonjs@gmail.com
 * 
 * This code was based on https://dzone.com/articles/spring-boot-jpa-hibernate-oracle
 */
@Entity
public class Player {
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "player_Sequence")
    @SequenceGenerator(name = "player_Sequence", sequenceName = "PLAYER_SEQ")
    private Long id;
	
	@NotEmpty
    @Column(name = "name")
    private String name;
    
	@NotEmpty
    @Column(name = "number")
    private int number;
    
	@NotEmpty
    @Column(name = "position")
    private String position;
	
	@NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;
    
    public Player() {
    
    }
    
    /**
	 * A player without team
	 * @param name
	 * @param position
	 * @param number
	 */
	public Player(String name, String position, int number) {
		this.name = name;
		this.position = position;
		this.number = number;
	}

	/**
	 * @param name
	 * @param position
	 * @param number
	 * @param team
	 */
	public Player(String name, String position, int number, Team team) {
		this(name, position, number);
		this.team = team;
	}

	

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	public String getPosition() {
		return position;
	}

	public Team getTeam() {
		return team;
	}
	
	public void setTeam(Team team) {
		this.team = team;
	}
	

}
