package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

public class FarmaciaTest extends SpringTest{
	// Validar cantidad que tiene que traer
	// Que sean los correctos
	// Validar direcciones no solo por cantidad sino por 
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
		
		for (Farmacia result : resultados) {
			assertThat (result.getDiaDeTurno()).isEqualTo(f3.getDiaDeTurno());
		}

		
}
	
	/* 3) Hacer con junit un test que busque todas las farmacias de una calle. */
	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	@Rollback(true)
	public void test3FarmaciasDeUnaCalle() {
	
		/*Preparacion*/
	Session session = getSession();	
	
	// Farmacia 1
	Farmacia f1 = new Farmacia();
	f1.setNombre("Farmacia-Sol");
	
	Direccion d1 = new Direccion();
	d1.setCalle("Florencio Varela");
	session.save(d1);
	
	f1.setDireccion(d1);
	session.save(f1);
	
	// Farmacia 2
	Farmacia f2 = new Farmacia();
	f2.setNombre("Farmacia-LaNueva");
	
	Direccion d2 = new Direccion();
	d2.setCalle("Florencio Varela");
	session.save(d2);
	
	f1.setDireccion(d2);
	session.save(f2);
	
	// Farmacia 3
	Farmacia f3 = new Farmacia();
	f3.setNombre("Farmacia-Cascarria");

	Direccion d3 = new Direccion();
	d3.setCalle("Puan");
	session.save(d3);
	
	f3.setDireccion(d3);
	session.save(f3);
	
	
	// Farmacia 4
	Farmacia f4 = new Farmacia();
	f4.setNombre("Farmacia-4170");
	
	Direccion d4 = new Direccion();
	d4.setCalle("Jujuy");
	session.save(d4);
	
	f4.setDireccion(d4);
	session.save(f4);
	
	// Farmacia 5
	Farmacia f5 = new Farmacia();
	f5.setNombre("Farmacia-4170");
	
	Direccion d5 = new Direccion();
	d5.setCalle("Puan");
	session.save(d5);
	
	f5.setDireccion(d5);
	session.save(f5);
	
		/*Ejecucion*/
	
	
		 List<Farmacia> resultados;
		
		 resultados = session.createCriteria(Farmacia.class)
				    .createAlias("direccion", "DireccionAlias")
				    .add(Restrictions.eq("DireccionAlias.calle", "Puan"))
					.list();
			
			
	   /*Validacion*/	
		
		assertThat(resultados).hasSize(2);
		
		for(Farmacia result : resultados){
			assertThat(result.getDireccion().getCalle()).isEqualTo(d5.getCalle());
		}
		
	// FOR dentro asserThat	Validar nombre de la calle sea el solicitado
	//	asserThat(resultados.get(0).getPrecio().minor(1000));

}

	/* 4) Hacer con junit un test que busque todas las farmacias de un barrio. */
	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	@Rollback(true)
	public void test4FarmaciasDeUnBarrio() {
	
		/*Preparacion*/
	Session session = getSession();	
	
	// Barrio 1		-- Farmacia 1
	
	Barrio b1 = new Barrio();
	b1.setNombre("San Nicolas");
	session.save(b1);
	
	Direccion d1 = new Direccion();
	d1.setCalle("Florencio Varela");	
	d1.setBarrio(b1);	
	session.save(d1);
	
	Farmacia f1 = new Farmacia();
	f1.setNombre("Farmacia-Sol");
	f1.setDireccion(d1);
	session.save(f1);
	
	// Barrio 2	-- Farmacia 2
	Barrio b2 = new Barrio();
	b2.setNombre("Luz y fuerza");
	session.save(b2);
	
	Direccion d2 = new Direccion();
	d2.setCalle("Marmol");	
	d2.setBarrio(b2);	
	session.save(d2);
	
	Farmacia f2 = new Farmacia();
	f2.setNombre("Farmacia-LaNueva");
	f2.setDireccion(d2);	
	session.save(f2);
	
	// Farmacia 3
	Farmacia f3 = new Farmacia();
	f3.setNombre("Farmacia-Cascarria");

	Direccion d3 = new Direccion();
	d3.setCalle("Puan");
	d3.setBarrio(b2);
	session.save(d3);
	
	f3.setDireccion(d3);
	session.save(f3);
	
	
	// Farmacia 4
	Farmacia f4 = new Farmacia();
	f4.setNombre("Farmacia-4170");
	
	Direccion d4 = new Direccion();
	d4.setCalle("Jujuy");
	d4.setBarrio(b1);
	session.save(d4);
	
	f4.setDireccion(d4);
	session.save(f4);
	
	// Farmacia 5
	Farmacia f5 = new Farmacia();
	f5.setNombre("Farmacia-4170");
	
	Direccion d5 = new Direccion();
	d5.setCalle("Puan");
	d5.setBarrio(b1);
	session.save(d5);
	
	f5.setDireccion(d5);
	session.save(f5);
	
		/*Ejecucion*/
	
	
		 List<Farmacia> resultados;
		
		 resultados = session.createCriteria(Farmacia.class)
				    .createAlias("direccion", "dire")
				    .createAlias("dire.barrio", "bar")
				    .add(Restrictions.eq("bar.nombre","San Nicolas"))
					.list();
		 
			
	   /*Validacion*/	
		
		assertThat(resultados).hasSize(3);
		
		for(Farmacia result : resultados){
			assertThat(result.getDireccion().getBarrio()).isEqualTo(d1.getBarrio());
		}
		
	
}
	
	
}	
