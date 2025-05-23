package unidad08.gestisimal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class Almacen {
	// Es el DAO que me ofrece las funcionalidades CRUD
	private ArticuloDAO articuloDao;

	public Almacen() {
		this.articuloDao = new ArticuloDAOImpl();
	}

	public void actualizarAlmacen(File fichero) {
		try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
			// Leer el fichero y tratarlo
			String linea = br.readLine();
			linea = br.readLine();
			while (null != linea) {
				String[] datos = linea.split(",");
				String codigo = datos[0];
				String desc = datos[1];
				Float precioCompra = Float.parseFloat(datos[2]);
				Float precioVenta = Float.parseFloat(datos[3]);
				Integer stock = Integer.parseInt(datos[4]);
				try {
					Articulo prod = new Articulo(codigo, desc, precioCompra, precioVenta, stock);
					actualizaProducto(prod);
				} catch (ArticuloException e) {
					System.err.println("El producto con código " + codigo + " no es correcto");
				}
				linea = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private boolean actualizaProducto(Articulo prod) {
		Articulo aux = this.articuloDao.obtener(prod.getCodigo());
		boolean modificado = false;
		if (null != aux) {
			// Si ya está en bd sumamos al stock de bd el stock del fichero
			prod.setStock(aux.getStock() + prod.getStock());
			this.articuloDao.actualizar(prod);
			modificado = true;
		} else {
			// si no estaba en bd añadimos el prod con el stock que pone en el fichero
			this.articuloDao.aniadir(prod);
			modificado = true;
		}
		return modificado;
	}

	public void mostrarArticulos() {
		System.out.println("ARTÍCULOS EN EL ALMACÉN");
		System.out.println("---------------------------------");
		boolean vacio = true;
		for (Articulo art : this.articuloDao.obtenerArticulos()) {
			System.out.println(art);
			vacio = false;
		}
		if (vacio) {
			System.out.println("NO HAY ARTÍCULOS EN EL ALMACÉN");
		}
	}

	public void mostrarArticulos(String cadenaBusqueda) {
		Set<Articulo> articulosBusqueda = this.articuloDao.obtenerArticulos(cadenaBusqueda);
		if (articulosBusqueda.size() <= 0) {
			System.out.println("No se encontró ningún articulo para los argumentos de la búsqueda");
		} else {
			System.out.println("ARTÍCULOS EN EL ALMACÉN CON BÚSQUEDA: " + cadenaBusqueda);
			System.out.println("---------------------------------");
			for (Articulo art : articulosBusqueda) {
				System.out.println(art);
			}
		}
	}

	public boolean eliminarArtículo(String codigo) {
		Articulo art = articuloDao.obtener(codigo);
		if (null != art) {
			// elimino
			articuloDao.eliminar(codigo);
			return true;
		} else {
			return false;
		}
	}

	public Articulo obtenerArticulo(String cod) {
		return articuloDao.obtener(cod);
	}

	public void actualizarArticulo(Articulo art) {
		articuloDao.actualizar(art);
	}
}
