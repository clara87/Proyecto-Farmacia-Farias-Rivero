package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

public class FarmaciaTest extends SpringTest{
	
	/* 2) Hacer con junit un test que busque todas las farmacias de turno los días martes. */
	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	@Rollback(true)
	public void test2FarmaciasConTurnoDiasMartes() {
	
		/*Preparacion*/
	Session session = getSession();	
		
	Farmacia f1 = new Farmacia();
	f1.setNombre("Farmacia-Sol");
	f1.setDiaDeTurno("Martes");
	session.save(f1);
	
	Farmacia f2 = new Farmacia();
	f2.setNombre("Farmacia-LaNueva");
	f2.setDiaDeTurno("Martes");
	session.save(f2);
	
	
	Farmacia f3 = new Farmacia();
	f3.setNombre("Farmacia-Cascarria");
	f3.setDiaDeTurno("Martes");
	session.save(f3);
	
	Farmacia f4 = new Farmacia();
	f4.setNombre("Farmacia-4170");
	f4.setDiaDeTurno("Lunes");
	session.save(f4);
	
	Farmacia f5 = new Farmacia();
	f5.setNombre("Farmacia-Juana");
	f5.setDiaDeTurno("Jueves");
	session.save(f5);
	
		/*Ejecucion*/
	
	
		 List<Farmacia> resultados;
		
		 resultados = session.createCriteria(Farmacia.class)
				 	.add(Restrictions.eq("diaDeTurno", "Martes"))
					.list();
			
			
	   /*Validacion*/	
		
		assertThat(resultados).hasSize(3);

}
	
	/* 3) Hacer con junit un test que busque todas las farmacias de una calle. */
	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	@Rollback(true)
	public void test2FarmaciasDeUnaCalle() {
	
		/*Preparacion*/
	Session session = getSession();	
		
	Farmacia f1 = new Farmacia();
	f1.setNombre("Farmacia-Sol");
	f1.setDiaDeTurno("Martes");
	Direccion d1 = new Direccion();
	f1.setDireccion(d1);
	session.save(f1);
	
	Farmacia f2 = new Farmacia();
	f2.setNombre("Farmacia-LaNueva");
	f2.setDiaDeTurno("Martes");
	f1.setDireccion(d1);
	session.save(f2);
	
	
	Farmacia f3 = new Farmacia();
	f3.setNombre("Farmacia-Cascarria");
	f3.setDiaDeTurno("Martes");
	f1.setDireccion(d1);
	session.save(f3);
	
	Farmacia f4 = new Farmacia();
	f4.setNombre("Farmacia-4170");
	f4.setDiaDeTurno("Lunes");
	f1.setDireccion(d1);
	session.save(f4);
	
	Farmacia f5 = new Farmacia();
	f5.setNombre("Farmacia-Juana");
	f5.setDiaDeTurno("Jueves");
	f1.setDireccion(d1);
	session.save(f5);
	
		/*Ejecucion*/
	
	
		 List<Farmacia> resultados;
		
		 resultados = session.createCriteria(Farmacia.class)
				 	.add(Restrictions.eq("diaDeTurno", "Martes"))
					.list();
			
			
	   /*Validacion*/	
		
		assertThat(resultados).hasSize(3);

	//	asserThat(resultados.get(0).getPrecio().minor(1000));

}
	
}	
