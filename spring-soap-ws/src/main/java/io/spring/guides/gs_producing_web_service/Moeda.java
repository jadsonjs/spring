//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.02.19 às 02:19:07 PM BRT 
//


package io.spring.guides.gs_producing_web_service;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de moeda.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="moeda"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="REAL"/&gt;
 *     &lt;enumeration value="EURO"/&gt;
 *     &lt;enumeration value="DOLAR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "moeda")
@XmlEnum
public enum Moeda {

    REAL,
    EURO,
    DOLAR;

    public String value() {
        return name();
    }

    public static Moeda fromValue(String v) {
        return valueOf(v);
    }

}
