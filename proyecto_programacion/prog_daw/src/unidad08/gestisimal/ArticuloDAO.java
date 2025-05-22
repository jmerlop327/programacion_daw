package unidad08.gestisimal;

import java.util.Set;

public interface ArticuloDAO {
	void aniadir(Articulo art);
	void actualizar(Articulo art);
	void eliminar(String codigo);
	Articulo obtener(String codigo);
	Set<Articulo> obtenerArticulos();
	Set<Articulo> buscarArticulos(String busqueda);
}
