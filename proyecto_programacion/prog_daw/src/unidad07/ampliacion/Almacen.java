package unidad07.ampliacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Almacen {
	private Set<Producto> productos;

	/**
	 * @return the productos
	 */
	public Set<Producto> getProductos() {
		return productos;
	}

	/**
	 * @param productos the productos to set
	 */
	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	public Almacen() {
		this.productos = new HashSet<Producto>();
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
					Producto prod = new Producto(codigo, desc, precioCompra, precioVenta, stock);
					actualizaProducto(prod);
				} catch (ProductoException e) {
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

	private void actualizaProducto(Producto prod) {
		if (this.productos.contains(prod)) {
			boolean modificado = false;
			Iterator<Producto> itProd = this.productos.iterator();
			while (!modificado && itProd.hasNext()) {
				Producto prodAtc = itProd.next();
				if (prodAtc.equals(prod)) {
					prodAtc.setDesc(prod.getDesc());
					prodAtc.setStock(prodAtc.getStock() + prod.getStock());
					modificado = true;
				}
			}
		} else {
			this.productos.add(prod);
		}

	}

	public void guardarDatosAlmacen(File fichero) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))) {
			// Escribir en el fichero los datos de los productos
			String cabecera = "codigo,descr,pre_compra,pre_venta,stock";
			bw.write(cabecera);
			for (Producto prod : productos) {
				String codigo = prod.getCodigo();
				String desc = prod.getDesc();
				String precioCompra = prod.getPrecioCompra().toString();
				String precioVenta = prod.getPrecioVenta().toString();
				String stock = prod.getStock().toString();
				String productoCsv = codigo + "," + desc + "," + precioCompra + "," + precioVenta + "," + stock;
				bw.write("\n" + productoCsv);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
