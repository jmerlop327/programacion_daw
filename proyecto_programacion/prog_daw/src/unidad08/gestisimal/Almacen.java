package unidad08.gestisimal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
			//Si ya está en bd sumamos al stock de bd el stock del fichero
			prod.setStock(aux.getStock() + prod.getStock());
			this.articuloDao.actualizar(prod);
			modificado = true;
		} else {
			//si no estaba en bd añadimos el prod con el stock que pone en el fichero
			this.articuloDao.aniadir(prod);
			modificado = true;
		}
		return modificado;
	}

	public void guardarDatosAlmacen(File fichero) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))) {
			// Escribir en el fichero los datos de los productos
			String cabecera = "codigo,descr,pre_compra,pre_venta,stock";
			bw.write(cabecera);
//			for (Articulo prod : articuloDao) {
//				String codigo = prod.getCodigo();
//				String desc = prod.getDesc();
//				String precioCompra = prod.getPrecioCompra().toString();
//				String precioVenta = prod.getPrecioVenta().toString();
//				String stock = prod.getStock().toString();
//				String productoCsv = codigo + "," + desc + "," + precioCompra + "," + precioVenta + "," + stock;
//				bw.write("\n" + productoCsv);
//			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mostrarArticulos() {
		System.out.println("ARTÍCULOS EN EL ALMACÉN");
		System.out.println("---------------------------------");
		for (Articulo art : this.articuloDao.obtenerArticulos()) {
			System.out.println(art);
		}
		
	}
}
