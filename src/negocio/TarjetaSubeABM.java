package negocio;

import modelo.dao.TarjetaSubeDao;
import java.math.BigDecimal;
import modelo.TarjetaSube;

public class TarjetaSubeABM {
	TarjetaSubeDao dao = new TarjetaSubeDao();
	
	public TarjetaSube traerTarjeta(int idTarjeta)throws Exception {
		TarjetaSube t = dao.traerTarjeta(idTarjeta);
		if(t == null) throw new Exception("No existe una tarjeta con id: " + idTarjeta); 
		return t;
	}
	
	public TarjetaSube traerTarjetaPorCodigo(String codigo) throws Exception{
		TarjetaSube t = dao.traerTarjeta(codigo);
		if(t == null) throw new Exception("No existe una tarjeta con codigo: " + codigo) ;
		return t;
	}
	
	public int agregar(String codigo, BigDecimal saldo) {
		//validar si existe una tarjeta con ese codigo, si la hay tirar excepcion
		
		TarjetaSube t = new TarjetaSube(codigo, saldo);
		return dao.agregarTarjetaSube(t);
	}
	
	public void modificar(TarjetaSube t) {
		//falta hacer el metodo "actualizar" en el dao
	}
	
	public void eliminarPorId(int idTarjeta) {
		TarjetaSube t = dao.traerTarjeta(idTarjeta);
		//si es null arrojar exception
		dao.eliminarTarjetaSube(t);
	}
}
