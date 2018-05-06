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
 * ThreelayerBackendApplication.java 
 * 5 de mai de 2018
 */
package com.example.jadson.threelayerbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jadson.threelayerbackend.service.SoccerService;

/**
 * Start the deploy of back-end on TOMCAT
 * 
 * @author Jadson Santos - jadsonjs@gmail.com
 * 
 */
@SpringBootApplication
public class ThreelayerBackendApplication{

	@Autowired
	SoccerService soccerService;
	
	public static void main(String[] args) {
		SpringApplication.run(ThreelayerBackendApplication.class, args);
	}

}
