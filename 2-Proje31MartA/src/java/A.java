/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author pelin
 */
@ManagedBean
@RequestScoped
public class A {   
 String message="Hello";
// you must define getMessage()
    public String getMessage() {
        message=message+"World from class A";
        return message;
    }
}
