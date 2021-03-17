/*
 * @author Edu
 * 
 * @version 1.0
 */

package pruebas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import datos.MapaUsuarios;
import model.Usuario;

public class Test {
	
	private static Logger logger;
	
	static
	{
		try
		{
			logger = LogManager.getLogger(Test.class);
		}
		catch (Throwable e)
		{
			System.out.println("Logger Don't work");
		}
	}
	
	public static void _01_clase_Usuario() {
		
		Usuario u1 = new Usuario();
		u1.setNombre("Trump");
		u1.setCiudadResidencia("Cartagena");
		u1.setDia(1);
		u1.setMes(5);
		u1.setYear(2010);
		u1.generarFechaNac();
		/*u1.setEmail("ejemplo@ejemplo.com");
		u1.setPassword("X/kO*mn76//dJJK");*/
		
		Usuario u2 = new Usuario("Cardasian",1971,5,1,"Elche");
		
		System.out.println(u1);
		System.out.println(u2);
		
	}
	
	public static void _02_clase_MapaUsuarios() {
		
		MapaUsuarios mu = new MapaUsuarios();
		
		Usuario u1 = new Usuario("Cardasian",1971,10,5,"Elche");
		Usuario u2 = new Usuario("FDFDDFGn",2010,4,1,"Mostoles");
		Usuario u3 = new Usuario("bbbbbbbbb",1024,11,20,"Gijón");
		
		mu.getMapaUsuarios().put(1, u1);
		mu.getMapaUsuarios().put(2, u2);
		mu.getMapaUsuarios().put(3, u3);
		
		System.out.println(mu);
		
		mu.listarUsuarios();
	}
	
	

}
