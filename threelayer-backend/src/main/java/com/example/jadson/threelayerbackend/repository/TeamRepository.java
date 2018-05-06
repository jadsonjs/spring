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
 * TeamRepository.java 
 * 5 de mai de 2018
 */
package com.example.jadson.threelayerbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jadson.threelayerbackend.model.Team;

/**
 * @author Jadson Santos - jadsonjs@gmail.com
 *
 * This code was based on https://dzone.com/articles/spring-boot-jpa-hibernate-oracle
 *
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{
	
	Team findByPlayers(long playerId);
}
