/*
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 *
 * spring-security
 * br.com.jadson.springsecurity.model
 * Usuario
 * 27/05/21
 */
package br.com.jadson.springsecurity.model;

import javax.persistence.*;

/**
 * Representa um usuário com permissões no sistema
 * Jadson Santos - jadsonjs@gmail.com
 */
@Entity
@Table(name = "usuario")
public class Usuario  {

    @Id
    private String username;
    private String password;

    @Column(name = "active")
    private boolean active;

    /**
     * Papeis que o usáurio pode ter. Cada papel dará permissão
     * a recursos diferentes dentro do sistema
     * NO caso aqui cada usuário vai ter apenas "1 papel"
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Papel role;

    public Usuario() {

    }

    public Usuario(String username, String password, boolean active, Papel role) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.role = role;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Papel getRole() {
        return role;
    }

    public void setRole(Papel papel) {
        this.role = papel;
    }
}
